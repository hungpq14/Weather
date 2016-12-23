package dtui.fit.com.weatherapp.Object;

import java.io.Serializable;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SettingDetail implements Serializable {
    private String text;
    private boolean isChecked;
    private boolean isShowNoti = false;

    public SettingDetail(String text, boolean isChecked, boolean isShowNoti) {
        this.text = text;
        this.isChecked = isChecked;
        this.isShowNoti = isShowNoti;
    }

    public SettingDetail(String text, boolean isChecked) {
        this.text = text;
        this.isChecked = isChecked;
    }

    public boolean isShowNoti() {
        return isShowNoti;
    }

    public void setIsShowNoti(boolean isShowNoti) {
        this.isShowNoti = isShowNoti;
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
