package ojass.in.ojass_18.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import me.relex.circleindicator.CircleIndicator;
import ojass.in.ojass_18.Adapters.IntroAdapter;
import ojass.in.ojass_18.R;

public class IntroActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager IntroPager;
    private int layout[] = {R.layout.welcome1, R.layout.welcome2, R.layout.welcome3, R.layout.welcome4};
    private IntroAdapter Introadapter;
    private Button gotit;
    private Button btn_next;
    private Button btn_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        IntroPager = (ViewPager) findViewById(R.id.introviewpager);
        btn_skip = findViewById(R.id.btn_skip);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layout.length - 1) {
                    // move to next screen
                    IntroPager.setCurrentItem(current);
                } else if (current == layout.length - 1) {
                    IntroPager.setCurrentItem(current);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                }
            }
        });
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        Introadapter = new IntroAdapter(layout, this);
        IntroPager.setAdapter(Introadapter);
        indicator.setViewPager(IntroPager);
        IntroPager.setOnPageChangeListener(this);

    }

    private int getItem(int i) {
        return IntroPager.getCurrentItem() + i;
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == layout.length - 1) {
            // last page. make button text to GOT IT
            btn_next.setText(getString(R.string.start));
            btn_skip.setVisibility(View.GONE);
        } else {
            // still pages are left
            btn_next.setText(getString(R.string.next));
            btn_skip.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
