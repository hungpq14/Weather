package dtui.fit.com.weatherapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.R;

public class MapActivity extends BaseToolbarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
