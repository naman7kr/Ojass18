package ojass.in.ojass_18.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
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
        bottomNavigationView = findViewById(R.id.activity_main_bottomnavigation);
        slidingLayout=findViewById(R.id.sliding_layout);
        rLayout=findViewById(R.id.activity_main_relativelayout);
        slidingLayout.setVisibility(View.GONE);
        slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);

        slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);

        mDialog=new Dialog(this);

        viewPager = findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new bottomNavigationAdapter(getSupportFragmentManager()));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        viewPager.setCurrentItem(0);

                        //        barCodeWindow.dismiss();
                        return true;
                    case R.id.bottom_nav_events:
                        viewPager.setCurrentItem(1);
                        //       barCodeWindow.dismiss();
                        return true;

                    case R.id.bottom_nav_itinary:
                        viewPager.setCurrentItem(2);

                        //   barCodeWindow.dismiss();
                        return true;
                    case R.id.bottom_nav_profile:
                        viewPager.setCurrentItem(3);

                        //   barCodeWindow.dismiss();
                        return true;
                    case R.id.bottom_nav_barcode:

                        createBarCodePopUp();
                        // barCodeWindow.dismiss();
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
    private void createBarCodePopUp() {
       mDialog.setContentView(R.layout.qrcode_popup);
       mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
       mDialog.show();
        TextView closePopUp=mDialog.findViewById(R.id.close_popup);
        closePopUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.activity_main_relativelayout)
        {
            slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            slidingLayout.setVisibility(View.GONE);
        }
        if(view.getId()==R.id.close_popup)
        {
            mDialog.getWindow().getAttributes().windowAnimations=R.style.pop_up_anim;
            mDialog.dismiss();
        }
    }
}