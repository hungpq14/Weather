package dtui.fit.com.weatherapp.Activity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;

import java.util.ArrayList;

import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.Constant.SettingDetailSeeder;
import dtui.fit.com.weatherapp.Notification.CurrentConditionNoti;
import dtui.fit.com.weatherapp.Object.SettingDetail;
import dtui.fit.com.weatherapp.R;

public class SettingActivity extends BaseToolbarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public String getToolbarText() {
        return "Setting";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDraw();
    }

    private void initDraw() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
        lp.setMargins(0, statusBarHeight, 0, 0);
        toolbar.setLayoutParams(lp);

        int navigationBarHeight = 0;
        resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        lp = (RelativeLayout.LayoutParams) findViewById(R.id.scroll_view).getLayoutParams();
        lp.setMargins(0, 0, 0, navigationBarHeight);
        findViewById(R.id.scroll_view).setLayoutParams(lp);

        findViewById(R.id.layout_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, AboutActivity.class));
            }
        });

        setEvent();
    }

    private void setEvent() {
        final Switch switchCurrent = (Switch) findViewById(R.id.switch_noti_current);
        switchCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCurrent.isChecked()) {
                    CurrentConditionNoti temp = new CurrentConditionNoti(getApplicationContext(), 2);

                    NotificationManager notificationmanager = (NotificationManager) getApplicationContext().getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                    notificationmanager.notify(2, temp.build());
                } else {
                    NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationmanager.cancel(2);
                }
            }
        });

        final Intent intent = new Intent(SettingActivity.this, SettingDetailActivity.class);

        findViewById(R.id.layout_setting_smart_noti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getSmartAlertListSetting();
                intent.putExtra("title", "Smart Alert");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

        findViewById(R.id.layout_setting_data_source).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getDataSourceListSetting();
                intent.putExtra("title", "Data Source");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

        findViewById(R.id.layout_setting_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getLocationListSetting();
                intent.putExtra("title", "Notification Location");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

        findViewById(R.id.layout_setting_priority).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getPriorityListSetting();
                intent.putExtra("title", "Notification Priority");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

        findViewById(R.id.layout_setting_update_interval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getUpdateIntervalListSetting();
                intent.putExtra("title", "Update Interval");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

        findViewById(R.id.layout_setting_language).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getLanguageListSetting();
                intent.putExtra("title", "Language");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

        findViewById(R.id.layout_setting_screen_mode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SettingDetail> dataList = (ArrayList<SettingDetail>) SettingDetailSeeder.getScreenModeListSetting();
                intent.putExtra("title", "Full Screen Mode");
                intent.putExtra("data", dataList);
                startActivity(intent);
            }
        });

    }


}
