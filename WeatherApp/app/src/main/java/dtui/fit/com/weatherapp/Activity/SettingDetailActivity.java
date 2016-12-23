package dtui.fit.com.weatherapp.Activity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import dtui.fit.com.weatherapp.Adapter.SettingDetailAdapter;
import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.Notification.RemindNoti;
import dtui.fit.com.weatherapp.Object.Event.SettingClickEvent;
import dtui.fit.com.weatherapp.Object.SettingDetail;
import dtui.fit.com.weatherapp.R;

public class SettingDetailActivity extends BaseToolbarActivity {
    private SettingDetailAdapter adapter;
    private List<SettingDetail> detailListSetting = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting_detail;
    }

    @Override
    public String getToolbarText() {
        return getIntent().getStringExtra("title");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDraw();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
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


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        detailListSetting = (List<SettingDetail>) getIntent().getSerializableExtra("data");
        Log.d("Setting detail", detailListSetting.size() + "");
        adapter = new SettingDetailAdapter(detailListSetting);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSettingChange(SettingClickEvent event) {
        int position = event.getPosition();
        for (SettingDetail sampleSettingDetail : detailListSetting) {
            if (sampleSettingDetail.isChecked()) sampleSettingDetail.setChecked(false);
        }
        detailListSetting.get(position).setChecked(true);
        adapter.notifyDataSetChanged();

        if (event.isShouldNoti())
            if (event.getPosition() != 0) {
                RemindNoti temp = new RemindNoti(getApplicationContext(), 1);
                RemindNoti temp2 = new RemindNoti(getApplicationContext(), 0);

                NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationmanager.notify(0, temp.build());
                notificationmanager.notify(1, temp2.build());
            } else {
                NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationmanager.cancel(0);
                notificationmanager.cancel(1);
            }

    }


    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

}
