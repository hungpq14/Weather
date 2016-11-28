package dtui.fit.com.weatherapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;

import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
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

    }
}
