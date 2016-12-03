package dtui.fit.com.weatherapp.Object.Event;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SettingClickEvent {
    int position;

    public SettingClickEvent(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
