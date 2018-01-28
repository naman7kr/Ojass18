package ojass.in.ojass_18.Modals;

/**
 * Created by dellpc on 1/18/2018.
 */

public class GurugyanModel {

    private int imageRes;
    private String name;

    public GurugyanModel(int imageRes, String name) {
        this.imageRes = imageRes;
        this.name = name;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getName() {
        return name;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public void setName(String name) {
        this.name = name;
    }
}
