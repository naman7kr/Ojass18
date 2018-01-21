package ojass.in.ojass_18.Modals;

/**
 * Created by Sanay on 1/19/2018.
 */

public class teamPageInformation {
    int iconId;
    String name;
    String description;
    String phone;

    public teamPageInformation(int iconId, String name, String description,String phone) {
        this.iconId = iconId;
        this.name = name;
        this.description = description;
        this.phone = phone;
    }

    public int getIconId() {
        return iconId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
