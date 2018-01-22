package ojass.in.ojass_18.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.Util;

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
    RelativeLayout subscribe;
    RelativeLayout notifications;
    private Fragment newFragment;
    ImageView bottomHomeImage;
    TextView bottomHomeText;
    com.nightonke.boommenu.BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subscribe=findViewById(R.id.toolbar_subscribe);
        notifications= findViewById(R.id.toolbar_notification);
        setBottomNavigation();
        bmb = findViewById(R.id.bmb);

        addHomeFragment();
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

        String[] BMBtext = {"Gurugyan", "Maps" , "CoreTeam","About Us","Developers" , "Faq"};
        int[] BMBimage = {R.drawable.icongurugyan, R.drawable.ic_place_black_48dp , R.drawable.iconteam , R.drawable.iconaboutus , R.drawable.iconappdev,R.drawable.iconfaq};
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                    .normalImageRes(BMBimage[i])
                    .typeface(Typeface.DEFAULT_BOLD)
                    .rippleEffect(true)
                    .textSize(13)

                    //.imageRect(new Rect(Util.dp2px(300), Util.dp2px(300), Util.dp2px(300), Util.dp2px(300)))
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if(index == 0)
                            {
                                Intent intent = new Intent(MainActivity.this, GurugyanActivity.class);
                                startActivity(intent);
                            }
                            if(index == 1)
                            {
                                Toast.makeText(MainActivity.this, "2nd btn", Toast.LENGTH_SHORT).show();
                            }
                            if(index == 2)
                            {
                                Intent intent = new Intent(MainActivity.this, TeamPage.class);
                                startActivity(intent);
                            }
                            if(index == 3)
                            {
                                Toast.makeText(MainActivity.this, "3rd btn", Toast.LENGTH_SHORT).show();
                            }if(index == 4)
                            {
                                Toast.makeText(MainActivity.this, "4th btn", Toast.LENGTH_SHORT).show();
                            }
                            if(index == 5)
                            {
                                Toast.makeText(MainActivity.this, "5th btn", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .normalText(BMBtext[i]);
            bmb.addBuilder(builder);
        }

    }






    private void addHomeFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.activity_main_fragmentcontainer,new HomeFragment(),"Home").commit();
        currentFragmentTag="Home";
        findViewById(R.id.bottom_nav_home).setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    private void setBottomNavigation() {
        findViewById(R.id.bottom_nav_home).setOnClickListener(this);
        findViewById(R.id.bottom_nav_events).setOnClickListener(this);
        findViewById(R.id.bottom_nav_qrcode).setOnClickListener(this);
        findViewById(R.id.bottom_nav_itinary).setOnClickListener(this);
        findViewById(R.id.bottom_nav_profile).setOnClickListener(this);
        findViewById(R.id.scroll_up_button).setOnClickListener(this);
        findViewById(R.id.gurugyan_scroll).setOnClickListener(this);
        findViewById(R.id.about_scroll).setOnClickListener(this);
        findViewById(R.id.core_scrollUp).setOnClickListener(this);
        findViewById(R.id.developers_scroll).setOnClickListener(this);
        findViewById(R.id.faq_scroll).setOnClickListener(this);
        findViewById(R.id.maps_scroll).setOnClickListener(this);

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
            }


        }
        if(viewId==R.id.bottom_nav_events)
        {
            if(currentFragmentTag!="Events")
            {
                newFragment=new EventsFragment();
                changeFragment(newFragment,"Events");
                currentFragmentTag="Events";
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
            }

        }
        if(viewId==R.id.bottom_nav_profile)
        {
            if(currentFragmentTag!="Profile")
            {
                newFragment=new ProfileFragment();
                changeFragment(newFragment,"Profile");
                currentFragmentTag="Profile";

            }
        }

        if(view.getId()==R.id.close_popup)
        {
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.dismiss();
        }

        if(view.getId()==R.id.scroll_up_button)
        {
            RelativeLayout scrollUp=findViewById(R.id.scroll_up);
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