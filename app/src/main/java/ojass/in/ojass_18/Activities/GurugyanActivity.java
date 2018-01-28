package ojass.in.ojass_18.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import ojass.in.ojass_18.Adapters.GurugyanPagerAdapter;
import ojass.in.ojass_18.Modals.GurugyanModel;
import ojass.in.ojass_18.Modals.IntroPageTransform;
import ojass.in.ojass_18.R;

public class GurugyanActivity extends BaseActivity {

    ViewPager GurugyanPager;
    List<GurugyanModel> guruList;
    GurugyanPagerAdapter adapter;
    CardView myCardView;
    TextView guruName;
    CardView OnTap;
    LinearLayout expandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurugyan);

        //initialising elements
        guruName=findViewById(R.id.gurugyan_name);
        expandableView=findViewById(R.id.expandable_layout);
        OnTap=findViewById(R.id.mycardview);
        final CircleIndicator indicator=findViewById(R.id.gurugyan_dots);
        myCardView=findViewById(R.id.mycardview);
        GurugyanPager =findViewById(R.id.guru_viewpager);


        //Adding elements in slides
        guruList=new ArrayList<>();
        guruList.add(new GurugyanModel(R.drawable.xmen,"Testgo"));
        guruList.add(new GurugyanModel(R.drawable.punisher,"AgainTest"));
        guruList.add(new GurugyanModel(R.drawable.punisher,"yetAgain"));

        //creating adapter
        adapter=new GurugyanPagerAdapter(this,guruList);
        GurugyanPager.setAdapter(adapter);
        indicator.setViewPager(GurugyanPager);

        //setting page transform animation
        GurugyanPager.setPageTransformer(false,new IntroPageTransform());
        guruName.setText(guruList.get(0).getName());
        expandView();
        //expanding and contracting the bottom card
        OnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expandableView.getVisibility()==View.GONE) {
                    expandableView.setVisibility(View.VISIBLE);
                }
                else if(expandableView.getVisibility()==View.VISIBLE)
                    expandableView.setVisibility(View.GONE);

            }
        });


        //applying Page change Listner
        GurugyanPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           int positionpre;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                expandableView.setVisibility(View.GONE);

                //changing the text of each slide with animation
                GurugyanModel current=guruList.get(position);
                Animation slideInLeft=AnimationUtils.loadAnimation(GurugyanActivity.this, R.anim.slide_in_left);
                Animation slideInRight=AnimationUtils.loadAnimation(GurugyanActivity.this, R.anim.slide_in_right);
                guruName.setText(current.getName());
                if(position>positionpre)
                {
                    guruName.setAnimation(slideInRight);

                }
                else
                {
                    guruName.setAnimation(slideInLeft);

                }

                //setting the previous position
                positionpre=position;

                expandView();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    }

    public void expandView()
    {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                expandableView.setVisibility(View.VISIBLE);
            }
        }, 2*1000);

    }
}
