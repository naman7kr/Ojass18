package ojass.in.ojass_18.Activities;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.eftimoff.viewpagertransformers.ParallaxPageTransformer;

import java.util.ArrayList;
import java.util.List;

import ojass.in.ojass_18.Adapters.GurugyanPagerAdapter;
import ojass.in.ojass_18.Infrastructure.ForegroundToBackgroundTransformer;
import ojass.in.ojass_18.Infrastructure.GurugyanModel;
import ojass.in.ojass_18.Infrastructure.ZoomOutSlideTransformer;
import ojass.in.ojass_18.R;

public class GurugyanActivity extends AppCompatActivity {

    ViewPager GurugyanPager;
    List<GurugyanModel> guruList;
    GurugyanPagerAdapter adapter;
    CardView myCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurugyan);
        guruList=new ArrayList<>();
        guruList.add(new GurugyanModel(R.drawable.xmen,"Testgo"));
        guruList.add(new GurugyanModel(R.drawable.punisher,"AgainTest"));
        guruList.add(new GurugyanModel(R.drawable.punisher,"yetAgain"));
        adapter=new GurugyanPagerAdapter(this,guruList);
        myCardView=findViewById(R.id.mycardview);

        GurugyanPager =findViewById(R.id.guru_viewpager);
        GurugyanPager.setAdapter(adapter);
        GurugyanPager.setPageTransformer(true,new ojass.in.ojass_18.Infrastructure.ParallaxPageTransformer(R.id.slide_view));






    }
}
