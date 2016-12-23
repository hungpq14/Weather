package dtui.fit.com.weatherapp.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dtui.fit.com.weatherapp.Object.HourlyForecast;
import dtui.fit.com.weatherapp.Object.SettingDetail;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SettingDetailSeeder {
    public static List<SettingDetail> smartAlertListSetting = new ArrayList<>();
    public static List<SettingDetail> dataSourceListSetting = new ArrayList<>();
    public static List<SettingDetail> updateIntervalListSetting = new ArrayList<>();
    public static List<SettingDetail> locationListSetting = new ArrayList<>();
    public static List<SettingDetail> priorityListSetting = new ArrayList<>();
    public static List<SettingDetail> screenModeListSetting = new ArrayList<>();
    public static List<SettingDetail> languageListSetting = new ArrayList<>();

    public static List<SettingDetail> getSmartAlertListSetting() {
        smartAlertListSetting.clear();
        smartAlertListSetting.add(new SettingDetail("None", false, true));
        smartAlertListSetting.add(new SettingDetail("Noti when there is special weather tomorrow", true, true));
        smartAlertListSetting.add(new SettingDetail("Noti every day in the morning", false, true));
        smartAlertListSetting.add(new SettingDetail("Noti every day in the afternoon", false, true));
        smartAlertListSetting.add(new SettingDetail("Noti every day in the evening", false, true));

        return smartAlertListSetting;
    }

    public static List<SettingDetail> getDataSourceListSetting() {
        dataSourceListSetting.clear();
        dataSourceListSetting.add(new SettingDetail("Foreca", true));
        dataSourceListSetting.add(new SettingDetail("Forecast", false));
        dataSourceListSetting.add(new SettingDetail("Open Weather Map", false));

        return dataSourceListSetting;
    }

    public static List<SettingDetail> getUpdateIntervalListSetting() {
        updateIntervalListSetting.clear();
        updateIntervalListSetting.add(new SettingDetail("15 Minutes", false));
        updateIntervalListSetting.add(new SettingDetail("30 Minutes", false));
        updateIntervalListSetting.add(new SettingDetail("1 Hour", false));
        updateIntervalListSetting.add(new SettingDetail("3 Hours", true));
        updateIntervalListSetting.add(new SettingDetail("6 Hours", false));
        updateIntervalListSetting.add(new SettingDetail("12 Hours", false));
        updateIntervalListSetting.add(new SettingDetail("1 Day", false));
        updateIntervalListSetting.add(new SettingDetail("Never", false));

        return updateIntervalListSetting;
    }

    public static List<SettingDetail> getLocationListSetting() {
        locationListSetting.clear();
        locationListSetting.add(new SettingDetail("Hanoi", true));
        locationListSetting.add(new SettingDetail("Arab", false));

        return locationListSetting;
    }

    public static List<SettingDetail> getPriorityListSetting() {
        priorityListSetting.clear();
        priorityListSetting.add(new SettingDetail("Max (Shown at the top of the list)", true));
        priorityListSetting.add(new SettingDetail("Default", false));
        priorityListSetting.add(new SettingDetail("Min (Don't show on lock screen)", false));

        return priorityListSetting;
    }

    public static List<SettingDetail> getScreenModeListSetting(){
        screenModeListSetting.clear();
        screenModeListSetting.add(new SettingDetail("Disable", false));
        screenModeListSetting.add(new SettingDetail("Only Hide Notification Bar", true));
        screenModeListSetting.add(new SettingDetail("Enable", false));

        return screenModeListSetting;
    }

    public static List<SettingDetail> getLanguageListSetting(){
        languageListSetting.clear();
        languageListSetting.add(new SettingDetail("Automatic", true));
        languageListSetting.add(new SettingDetail("Vietnam", false));
        languageListSetting.add(new SettingDetail("English", false));

        return languageListSetting;
    }
}

