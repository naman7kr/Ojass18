package ojass.in.ojass_18.Infrastructure;

import android.support.v4.view.ViewPager;
import android.view.View;

import ojass.in.ojass_18.R;

/**
 * Created by dellpc on 1/19/2018.
 */

public class IntroPageTransform implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]

           //view.findViewById(R.id.slide_view).setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }


    }
}
