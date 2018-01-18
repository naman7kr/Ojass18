package ojass.in.ojass_18.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.lang.reflect.Field;

import ojass.in.ojass_18.Adapters.bottomNavigationAdapter;

import ojass.in.ojass_18.Fragments.EventsFragment;
import ojass.in.ojass_18.Fragments.HomeFragment;
import ojass.in.ojass_18.Fragments.ItinaryFragment;
import ojass.in.ojass_18.Fragments.ProfileFragment;
import ojass.in.ojass_18.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private RelativeLayout rLayout;
    private Toolbar toolbar;
    private Dialog mDialog;
    private Button slideUpButton;
    private SlidingUpPanelLayout slidingLayout;
    Animation slide_down;
    Animation slide_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        setBottomNavigation();
    }

    private void setBottomNavigation() {
        findViewById(R.id.bottom_nav_home).setOnClickListener(this);
        findViewById(R.id.bottom_nav_events).setOnClickListener(this);
        findViewById(R.id.bottom_nav_barcode).setOnClickListener(this);
        findViewById(R.id.bottom_nav_itinary).setOnClickListener(this);
        findViewById(R.id.bottom_nav_profile).setOnClickListener(this);

        mDialog=new Dialog(this);




    }


    private void createBarCodePopUp() {
       mDialog.setContentView(R.layout.qrcode_popup);
       mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
       mDialog.show();
        TextView closePopUp=mDialog.findViewById(R.id.close_popup);
        closePopUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int viewId=view.getId();
        if(viewId==R.id.bottom_nav_home)
        {
            changeFragment(new HomeFragment(),R.layout.fragment_home);
        }
        if(viewId==R.id.bottom_nav_events)
        {
            changeFragment(new EventsFragment(),R.layout.fragment_events);
        }
        if(viewId==R.id.bottom_nav_barcode)
        {
            createBarCodePopUp();
        }
        if(viewId==R.id.bottom_nav_itinary)
        {
            changeFragment(new ItinaryFragment(),R.layout.fragment_itinary);
        }
        if(viewId==R.id.bottom_nav_profile)
        {
            changeFragment(new ProfileFragment(),R.layout.fragment_profile);
        }

        if(view.getId()==R.id.close_popup)
        {
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.dismiss();
        }
    }
    void changeFragment(Fragment fragment, int layoutId)
    {
        FragmentManager fm=getSupportFragmentManager();
        fm.beginTransaction().replace(layoutId, fragment).commit();
    }
}