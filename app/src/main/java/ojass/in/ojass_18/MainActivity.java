package ojass.in.ojass_18;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager mviewPager;
    LinearLayout mdotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] mdots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewPager = findViewById(R.id.mainactivity_viewpager);
        mdotsLayout = findViewById(R.id.mainactivity_linearLayout);
        sliderAdapter = new SliderAdapter(this);
        mviewPager.setAdapter(sliderAdapter);

        adddotsindicator(0);
        mviewPager.addOnPageChangeListener(viewlistner);
    }

    public void adddotsindicator(int position){
        mdots = new TextView[3];
        mdotsLayout.removeAllViews();
        for(int i=0;i<mdots.length;i++)
        {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorAccent));

            mdotsLayout.addView(mdots[i]);
        }

        if(mdots.length > 0)
        {
            mdots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {

            adddotsindicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}