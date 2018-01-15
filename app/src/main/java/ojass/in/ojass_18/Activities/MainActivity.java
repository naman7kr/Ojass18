package ojass.in.ojass_18.Activities;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.lang.reflect.Field;

import ojass.in.ojass_18.Adapters.bottomNavigationAdapter;

import ojass.in.ojass_18.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private Toolbar toolbar;
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
        slidingLayout.setVisibility(View.GONE);
        slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);

        slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);


        viewPager = findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new bottomNavigationAdapter(getSupportFragmentManager()));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        viewPager.setCurrentItem(0);
                        slidingLayout.startAnimation(slide_down);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        slidingLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.bottom_nav_events:
                        viewPager.setCurrentItem(1);
                        slidingLayout.startAnimation(slide_down);
                        slidingLayout.setVisibility(View.GONE);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

                        return true;
                    case R.id.bottom_nav_ojass:
                        viewPager.setCurrentItem(2);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                        slidingLayout.setVisibility(View.VISIBLE);
                        slidingLayout.startAnimation(slide_up);
                        return true;
                    case R.id.bottom_nav_itinary:
                        viewPager.setCurrentItem(3);
                        slidingLayout.startAnimation(slide_down);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        slidingLayout.setVisibility(View.GONE);
                        return true;
                    case R.id.bottom_nav_profile:
                        viewPager.setCurrentItem(4);
                        slidingLayout.startAnimation(slide_down);
                        slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        slidingLayout.setVisibility(View.GONE);
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
                if(position == 2){
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_ojass);
                }
                if (position == 3) {
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_itinary);
                }
                if(position ==4)
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_profile);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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

}
