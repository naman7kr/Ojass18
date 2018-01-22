package ojass.in.ojass_18.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.lang.reflect.Field;

import ojass.in.ojass_18.Adapters.BottomNavigationAdapter;
import ojass.in.ojass_18.Dialog.NotificationsDialog;
import ojass.in.ojass_18.Fragments.EventsFragment;
import ojass.in.ojass_18.Fragments.HomeFragment;
import ojass.in.ojass_18.Fragments.ItinaryFragment;
import ojass.in.ojass_18.Fragments.ProfileFragment;
import ojass.in.ojass_18.R;
import ojass.in.ojass_18.Dialog.SubscribeDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Dialog mDialog;
    private String currentFragmentTag;
    private RelativeLayout subscribe;
    private RelativeLayout notifications;
    private LinearLayout toolbar;
    private Fragment newFragment;
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private RelativeLayout scrollUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subscribe=findViewById(R.id.toolbar_subscribe);
        notifications= findViewById(R.id.toolbar_notification);
        toolbar=findViewById(R.id.include_toolbar);
         scrollUp=findViewById(R.id.scroll_up);

         scrollUp.setVisibility(View.GONE);
        setBottomNavigation();

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubscribeDialog dialogFragment=new SubscribeDialog();
                dialogFragment.show(getSupportFragmentManager(),"Subscribe");
            }
        });
                notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationsDialog dialogFragment=new NotificationsDialog();
                dialogFragment.show(getFragmentManager(),"Notifications");

            }
        });

    }

    private void setBottomNavigation() {
        bottomNavigationView = findViewById(R.id.activity_main_bottomnavigation);
        viewPager = findViewById(R.id.activity_main_fragmentcontainer);
        viewPager.setAdapter(new BottomNavigationAdapter(getSupportFragmentManager()));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        viewPager.setCurrentItem(0);
                        toolbar.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.bottom_nav_events:
                        viewPager.setCurrentItem(1);
                        toolbar.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.bottom_nav_itinary:
                        viewPager.setCurrentItem(2);
                        toolbar.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.bottom_nav_profile:
                        viewPager.setCurrentItem(3);
                        toolbar.setVisibility(View.GONE);
                        return true;
                    case R.id.bottom_nav_qrcode:
                        createQRPopup();
                        return true;
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
                }
                if (position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_events);

                }
                if (position == 2) {
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_itinary);
                }
                if(position ==3)
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_profile);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        disableShiftMode(bottomNavigationView);

        findViewById(R.id.scroll_up_button).setOnClickListener(this);
        findViewById(R.id.gurugyan_scroll).setOnClickListener(this);
        findViewById(R.id.about_scroll).setOnClickListener(this);
        findViewById(R.id.core_scrollUp).setOnClickListener(this);
        findViewById(R.id.developers_scroll).setOnClickListener(this);
        findViewById(R.id.faq_scroll).setOnClickListener(this);
        findViewById(R.id.maps_scroll).setOnClickListener(this);

    }
    @SuppressLint("RestrictedApi")
    void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
    @Override
    public void onClick(View view) {
        int viewId=view.getId();
        if(viewId==R.id.bottom_nav_home)
        {
            if(currentFragmentTag!="Home")
            {
                newFragment=new HomeFragment();
                changeFragment(newFragment,"Home");
                currentFragmentTag="Home";
                toolbar.setVisibility(View.VISIBLE);
            }


        }
        if(viewId==R.id.bottom_nav_events)
        {
            if(currentFragmentTag!="Events")
            {
                newFragment=new EventsFragment();
                changeFragment(newFragment,"Events");
                currentFragmentTag="Events";
                toolbar.setVisibility(View.VISIBLE);
            }

        }
        if(viewId==R.id.bottom_nav_qrcode)
        {
            //create qr dialog
            mDialog=new Dialog(this);
            createQRPopup();
        }
        if(viewId==R.id.bottom_nav_itinary)
        {
            if(currentFragmentTag!="Itinary")
            {
                newFragment=new ItinaryFragment();
                changeFragment(newFragment,"Itinary");
                currentFragmentTag="Itinary";
                toolbar.setVisibility(View.VISIBLE);
            }

        }
        if(viewId==R.id.bottom_nav_profile)
        {
            if(currentFragmentTag!="Profile")
            {
                newFragment=new ProfileFragment();
                changeFragment(newFragment,"Profile");
                currentFragmentTag="Profile";
                toolbar.setVisibility(View.GONE);

            }
        }

        if(view.getId()==R.id.close_popup)
        {
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.dismiss();
        }

        if(view.getId()==R.id.scroll_up_button)
        {

            if(scrollUp.getVisibility()==View.GONE)
            {
                scrollUp.setVisibility(View.VISIBLE);
            }
            else if(scrollUp.getVisibility()==View.VISIBLE)
            {
                scrollUp.setVisibility(View.GONE);
            }
        }

        if(view.getId()==R.id.gurugyan_scroll)
        {
            startActivity(new Intent(MainActivity.this,GurugyanActivity.class));
        }

        if(view.getId()==R.id.developers_scroll)
        {

        }
        if (view.getId()==R.id.about_scroll)
        {

        }
        if(view.getId()==R.id.faq_scroll)
        {

        }
        if(view.getId()==R.id.maps_scroll)
        {

        }
        if(view.getId()==R.id.core_scrollUp)
        {
            startActivity(new Intent(MainActivity.this,TeamPage.class));

        }
    }
    private void createQRPopup() {
        mDialog=new Dialog(this);
        mDialog.setContentView(R.layout.qrcode_popup);
        mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
        setQRCode(mDialog);
        mDialog.show();
        TextView closePopUp=mDialog.findViewById(R.id.close_popup);
        closePopUp.setOnClickListener(this);
    }
    void changeFragment(Fragment fragment, String tag)
    {
        FragmentManager fm=getSupportFragmentManager();
        if(fm!=null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_out,R.anim.fade_in)
                    .replace(R.id.activity_main_fragmentcontainer, fragment,tag);
            transaction.commit();
        }
    }
    private void setQRCode(Dialog view) {
        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
        try {
            BitMatrix bMatrix=multiFormatWriter.encode("https://google.com",
                    BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder encoder=new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(bMatrix);
            ImageView QRImage=view.findViewById(R.id.qr_code);
            QRImage.setImageBitmap(bitmap);
        }
        catch (WriterException e)
        {
            e.printStackTrace();
        }
    }
}