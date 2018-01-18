package ojass.in.ojass_18.Adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ojass.in.ojass_18.R;



public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutinflater;


    public SliderAdapter(Context context){
        this.context = context;
    }
    //store values
    public int[] slider_image =
            {
                    R.drawable.image ,R.drawable.imagetwo ,R.drawable.imagethree
            };

    @Override
    public int getCount() {
        return slider_image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view  ==  object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutinflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutinflater.inflate(R.layout.layout_viewpager, container, false);

        ImageView slideimageview = view.findViewById(R.id.layoutviewpager_imageview);

        slideimageview.setImageResource(slider_image[position]);

        container.addView(view);
        return view;
    };

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
