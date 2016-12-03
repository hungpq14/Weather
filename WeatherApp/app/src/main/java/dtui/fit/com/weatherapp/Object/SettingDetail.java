package dtui.fit.com.weatherapp.Object;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SettingDetail {
    private String text;
    private boolean isChecked;

    public SettingDetail(String text, boolean isChecked) {
        this.text = text;
        this.isChecked = isChecked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
