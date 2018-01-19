package ojass.in.ojass_18.Infrastructure;

import android.support.v4.view.ViewPager;
import android.view.View;

import ojass.in.ojass_18.R;

/**
 * Created by dellpc on 1/19/2018.
 */

public class IntroPageTransform2 implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        int pageWidth = page.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0);

        } else if (position <= 1) { // [-1,1]



            page.findViewById(R.id.slide_view).setTranslationX((position) * (pageWidth / 100));

            page.findViewById(R.id.mycardview).setTranslationX((position) * (pageWidth / 2));

            page.findViewById(R.id.gurugyan_name).setTranslationX((position) * (pageWidth / 1));
            // This is another way to do it


        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }
    }
}
