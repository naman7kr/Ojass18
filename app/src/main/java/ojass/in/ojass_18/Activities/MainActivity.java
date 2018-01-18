package ojass.in.ojass_18.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.lang.reflect.Field;

import ojass.in.ojass_18.Adapters.bottomNavigationAdapter;

import ojass.in.ojass_18.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private RelativeLayout rLayout;
    private Toolbar toolbar;
    private Dialog mDialog;
    private LinearLayout slideUpButton;
    private SlidingUpPanelLayout slidingLayout;
    Animation slide_down;
    Animation slide_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        setBottomNavigation();

    }

    private void setBottomNavigation() {
        bottomNavigationView = findViewById(R.id.activity_main_bottomnavigation);
        slidingLayout=findViewById(R.id.sliding_layout);


        rLayout=findViewById(R.id.main_content);

        slideUpButton=findViewById(R.id.slide_up_button);
        slideUpButton.setOnClickListener(this);
        mDialog=new Dialog(this);

        viewPager = findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new bottomNavigationAdapter(getSupportFragmentManager()));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        viewPager.setCurrentItem(0);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        //        barCodeWindow.dismiss();
                        return true;
                    case R.id.bottom_nav_events:
                        viewPager.setCurrentItem(1);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                        return true;

                    case R.id.bottom_nav_itinary:
                        viewPager.setCurrentItem(2);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                        return true;
                    case R.id.bottom_nav_profile:
                        viewPager.setCurrentItem(3);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                        return true;
                    case R.id.bottom_nav_barcode:
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        createQRCodePopUp();
                        return false;
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
        slidingLayout.setOnClickListener(this);
        rLayout.setOnClickListener(this);

        disableShiftMode(bottomNavigationView);
    }
    @SuppressLint("RestrictedApi")
    private void disableShiftMode(BottomNavigationView view) {
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
    private void createQRCodePopUp() {
       mDialog.setContentView(R.layout.qrcode_popup);
       mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
        setQRCode(mDialog);
       mDialog.show();

        TextView closePopUp=mDialog.findViewById(R.id.close_popup);
        closePopUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
//        if(view.getId()==R.id.main_content)
//        {
//
//            Log.e("LIL","LJS");
//            slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
//        }
        if(view.getId()==R.id.close_popup)
        {
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.dismiss();
        }
        if(view.getId()==R.id.slide_up_button)
        {

            if(slidingLayout.getPanelState()==SlidingUpPanelLayout.PanelState.EXPANDED)
            {
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
            else
            {
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        }
        if(view.getId()==R.id.main_content)
        {
            if(slidingLayout.getPanelState()==SlidingUpPanelLayout.PanelState.EXPANDED)
            {
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        }
        if(view.getId()==R.id.sliding_layout)
        {
            if(slidingLayout.getPanelState()==SlidingUpPanelLayout.PanelState.EXPANDED)
            {
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
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