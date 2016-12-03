package dtui.fit.com.weatherapp.Constant;

import java.util.ArrayList;
import java.util.List;

import dtui.fit.com.weatherapp.Object.HourlyForecast;
import dtui.fit.com.weatherapp.Object.SettingDetail;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SampleSettingDetail {
    public static List<SettingDetail> smartAlertListSetting = new ArrayList<>();

    public static List<SettingDetail> getSmartAlertListSetting() {
        smartAlertListSetting.clear();
        smartAlertListSetting.add(new SettingDetail("None", false));
        smartAlertListSetting.add(new SettingDetail("Noti when there is special weather tomorrow", true));
        smartAlertListSetting.add(new SettingDetail("Noti every day in the morning", false));
        smartAlertListSetting.add(new SettingDetail("Noti every day in the afternoon", false));
        smartAlertListSetting.add(new SettingDetail("Noti every day in the evening", false));

        return smartAlertListSetting;
    }
}
