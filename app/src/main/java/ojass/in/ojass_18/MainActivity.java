package ojass.in.ojass_18;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager mviewPager;
    SliderAdapter sliderAdapter;
    CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewPager = findViewById(R.id.mainactivity_viewpager);
        indicator = findViewById(R.id.mainactivity_dots);
        sliderAdapter = new SliderAdapter(this);
        mviewPager.setAdapter(sliderAdapter);
        indicator.setViewPager(mviewPager);

    }

}