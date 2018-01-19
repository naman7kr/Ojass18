package ojass.in.ojass_18.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ojass.in.ojass_18.Infrastructure.GurugyanModel;
import ojass.in.ojass_18.R;

/**
 * Created by dellpc on 1/18/2018.
 */

public class GurugyanPagerAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;
    List<GurugyanModel> list1= Collections.emptyList();

    public GurugyanPagerAdapter(Context context, List<GurugyanModel> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View itemView=layoutInflater.inflate(R.layout.gurugyan_slide,container,false);
        ImageView guruImage=itemView.findViewById(R.id.gurugyan_person);
       // TextView guruName=itemView.findViewById(R.id.gurugyan_name);
        //ImageView goLeft=itemView.findViewById(R.id.gurugyan_goleft);
        //ImageView goRight=itemView.findViewById(R.id.gurugyan_goright);

        //if(position==0)
         //   goLeft.setColorFilter(Color.GRAY);
       // else if(position==(list1.size()-1))
        //    goRight.setColorFilter(Color.GRAY);

        GurugyanModel current=list1.get(position);
        guruImage.setImageResource(current.getImageRes());
        //guruName.setText(current.getName());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
