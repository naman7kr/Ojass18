package ojass.in.ojass_18.Modals;


public class EventsModel {
    private String eventName;
    private int Image;
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getEventName() {
        return eventName;
    }

    public int getImage() {
        return Image;
    }
}
