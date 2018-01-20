package ojass.in.ojass_18.Activities;

import android.app.Dialog;


import android.graphics.Bitmap;

import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.animation.Animation;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import ojass.in.ojass_18.Fragments.EventsFragment;
import ojass.in.ojass_18.Fragments.HomeFragment;
import ojass.in.ojass_18.Fragments.ItinaryFragment;
import ojass.in.ojass_18.Fragments.ProfileFragment;
import ojass.in.ojass_18.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private RelativeLayout rLayout;

    private Dialog mDialog;
    private Button slideUpButton;
    private SlidingUpPanelLayout slidingLayout;
    String currentFragmentTag;
    private Fragment newFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomNavigation();
        addHomeFragment();
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
        mDialog=new Dialog(this);
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
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_events).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_itinary).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_profile).setBackgroundColor(Color.parseColor("#FFFFFF"));

            }


        }
        if(viewId==R.id.bottom_nav_events)
        {
            if(currentFragmentTag!="Events")
            {
                newFragment=new EventsFragment();
                changeFragment(newFragment,"Events");
                currentFragmentTag="Events";
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_home).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_itinary).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_profile).setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

        }
        if(viewId==R.id.bottom_nav_qrcode)
        {
            createQRPopup();
        }
        if(viewId==R.id.bottom_nav_itinary)
        {
            if(currentFragmentTag!="Itinary")
            {
                newFragment=new ItinaryFragment();
                changeFragment(newFragment,"Itinary");
                currentFragmentTag="Itinary";
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_home).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_events).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_profile).setBackgroundColor(Color.parseColor("#FFFFFF"));

            }

        }
        if(viewId==R.id.bottom_nav_profile)
        {
            if(currentFragmentTag!="Profile")
            {
                newFragment=new ProfileFragment();
                changeFragment(newFragment,"Profile");
                currentFragmentTag="Profile";
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_home).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_itinary).setBackgroundColor(Color.parseColor("#FFFFFF"));
                findViewById(R.id.bottom_nav_events).setBackgroundColor(Color.parseColor("#FFFFFF"));


            }
        }

        if(view.getId()==R.id.close_popup)
        {
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.dismiss();
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