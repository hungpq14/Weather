package dtui.fit.com.weatherapp.Object.Event;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SettingClickEvent {
    int position;
    boolean shouldNoti = false;

    public SettingClickEvent(int position, boolean shouldNoti) {
        this.position = position;
        this.shouldNoti = shouldNoti;
    }

    public boolean isShouldNoti() {
        return shouldNoti;
    }

    public void setShouldNoti(boolean shouldNoti) {
        this.shouldNoti = shouldNoti;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
