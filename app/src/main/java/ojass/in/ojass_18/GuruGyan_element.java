package ojass.in.ojass_18;

import android.widget.ImageView;

/**
 * Created by dellpc on 1/14/2018.
 */

public class GuruGyan_element {

    private int image;
    private String title;

    public GuruGyan_element(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
