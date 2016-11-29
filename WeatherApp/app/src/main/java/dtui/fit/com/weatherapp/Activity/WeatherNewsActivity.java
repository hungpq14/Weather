package dtui.fit.com.weatherapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.R;

public class WeatherNewsActivity extends BaseToolbarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_weather_news;
    }

    @Override
    public String getToolbarText() {
        return "Weather ic_news";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_news);
    }
}
