package dtui.fit.com.weatherapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import dtui.fit.com.weatherapp.Base.BaseFontActivity;
import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.R;

public class AboutActivity extends BaseToolbarActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public String getToolbarText() {
        return "About Us";
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

    }
}
