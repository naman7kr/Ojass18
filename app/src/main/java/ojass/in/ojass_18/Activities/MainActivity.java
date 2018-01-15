package ojass.in.ojass_18.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ojass.in.ojass_18.Adapters.bottomNavigationAdapter;

import ojass.in.ojass_18.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        setBottomNavigation();


    }

    private void setBottomNavigation() {
        bottomNavigationView=findViewById(R.id.activity_main_bottomnavigation);
        viewPager= findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(new bottomNavigationAdapter(getSupportFragmentManager()));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.bottom_nav_events:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.bottom_nav_profile:
                        viewPager.setCurrentItem(2);
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
                }  if (position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_events);

                } if(position==2) {
                    bottomNavigationView.setSelectedItemId(R.id.bottom_nav_profile);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
