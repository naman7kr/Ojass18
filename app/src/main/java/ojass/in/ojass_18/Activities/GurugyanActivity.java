package ojass.in.ojass_18.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
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

public class GurugyanActivity extends AppCompatActivity {

    ViewPager GurugyanPager;
    List<GurugyanModel> guruList;
    GurugyanPagerAdapter adapter;
    CardView myCardView;
    ImageView goLeft;
    ImageView goRight;
    TextView guruName;
    LinearLayout OnTap;
    LinearLayout expandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurugyan);
        goLeft=findViewById(R.id.gurugyan_goleft);
        goRight=findViewById(R.id.gurugyan_goright);
        guruName=findViewById(R.id.gurugyan_name);
        guruList=new ArrayList<>();
        goRight.setVisibility(View.GONE);
        goLeft.setVisibility(View.GONE);
        guruList.add(new GurugyanModel(R.drawable.xmen,"Testgo"));
        guruList.add(new GurugyanModel(R.drawable.punisher,"AgainTest"));
        guruList.add(new GurugyanModel(R.drawable.punisher,"yetAgain"));
        adapter=new GurugyanPagerAdapter(this,guruList);
        myCardView=findViewById(R.id.mycardview);
        CircleIndicator indicator=findViewById(R.id.gurugyan_dots);
        OnTap=findViewById(R.id.expand_ontap);
        expandableView=findViewById(R.id.expandable_layout);

        guruName.setText(guruList.get(0).getName());
        goLeft.setColorFilter(Color.GRAY);
        GurugyanPager =findViewById(R.id.guru_viewpager);
        GurugyanPager.setAdapter(adapter);
        GurugyanPager.setPageTransformer(false,new IntroPageTransform());
        indicator.setViewPager(GurugyanPager);

        GurugyanPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           float sumPositionandOffset;
           int positionpre;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(final int position) {

                Log.e("gurugyanActivity",""+position);
                if(position==0)
                    goLeft.setColorFilter(Color.GRAY);
                else
                    goLeft.setColorFilter(Color.WHITE);
                if(position==(guruList.size()-1))
                    goRight.setColorFilter(Color.GRAY);
                else
                    goRight.setColorFilter(Color.WHITE);



                goLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(position!=0)
                            GurugyanPager.setCurrentItem(position-1,true);
                    }
                });

                goRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(position!=(guruList.size()-1))
                            GurugyanPager.setCurrentItem(position+1,true);
                    }
                });

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
                positionpre=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






    }
}
