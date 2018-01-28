package ojass.in.ojass_18.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gourav on 1/20/2018.
 */

public class IntroAdapter extends PagerAdapter  {

    private int[] layouts;
    private LayoutInflater layoutinflator;
    private Context context;


    public IntroAdapter(int[] layouts, Context context) {
        this.layouts = layouts;
        this.context=context;
        layoutinflator= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=layoutinflator.inflate(layouts[position],container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=(View)object;
        container.removeView(view);
    }
}
