package dtui.fit.com.weatherapp.Activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dtui.fit.com.weatherapp.Base.BaseFontActivity;
import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.Object.SpinnerModel;
import dtui.fit.com.weatherapp.Adapter.SpinnerAdapter;
import dtui.fit.com.weatherapp.Object.View.FloatingActionMenu;
import dtui.fit.com.weatherapp.R;

public class MapActivity extends BaseToolbarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    public String getToolbarText() {
        return "Map";
    }

    //private BottomBar mBottomBar;
    WebView mapview;
    // Title navigation Spinner data
    private ArrayList<SpinnerModel> SpinnerListview = new ArrayList<SpinnerModel>();

    private String[] imageNameDatabase = {"R.drawable.temp", "R.drawable.wind", "R.drawable.rain"};
    String urlTemp = "https://earth.nullschool.net/#current/wind/isobaric/850hPa/overlay=temp/orthographic=-246.86,15.18,1024/loc=107.886,21.092",
            urlWind = "https://earth.nullschool.net/#current/wind/isobaric/850hPa/orthographic=-246.86,15.18,1024/loc=107.886,21.092",
            urlRain = "https://earth.nullschool.net/#current/wind/isobaric/850hPa/overlay=total_cloud_water/orthographic=-246.86,15.18,1024/loc=107.886,21.092";
    SpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //CustomSpinner
        ArrayList<SpinnerModel> list = new ArrayList<SpinnerModel>();
        list.add(new SpinnerModel(R.drawable.temp, "Temp"));
        list.add(new SpinnerModel(R.drawable.wind, "Wind"));
        list.add(new SpinnerModel(R.drawable.rain, "Rain"));
//        Spinner spin = (Spinner) findViewById(R.id.spinner);
//        adapter = new SpinnerAdapter(this, R.layout.list_item_title_navigation, R.id.txtTitle, list);
//        spin.setAdapter(adapter);

        mapview = (WebView) findViewById(R.id.mapview);
        //mapview.setWebViewClient(new MyWebViewClient(addressBar));
        goUrl(urlTemp);


        /*
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        imageNameDatabase
                );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adapter);
        */
//        spin.setOnItemSelectedListener(new ChangeMap());

        initDraw();
    }

    private void initDraw() {

        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_main_circle);
        FloatingActionMenu menu = (FloatingActionMenu) findViewById(R.id.fab_menu_circle);
        menu.setMultipleOfFB(2.4f);
        menu.setIsCircle(true);

        menu.setOnMenuItemClickListener(new FloatingActionMenu.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(FloatingActionMenu fam, int index, FloatingActionButton item) {
                switch (index) {
                    case 0:
                        Log.d("Map","temp clicked");
                        goUrl(urlTemp);
                        floatingActionButton.setImageResource(R.drawable.temp);
                        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.bg_temp)));
                        break;
                    case 1:
                        Log.d("Map","wind clicked");
                        goUrl(urlWind);
                        floatingActionButton.setImageResource(R.drawable.wind);
                        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.bg_wind)));
                        break;
                    case 2:
                        Log.d("Map","rain clicked");
                        goUrl(urlRain);
                        floatingActionButton.setImageResource(R.drawable.rain);
                        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.bg_rain)));
                        break;
                }
            }
        });

    }

    private class ChangeMap implements
            AdapterView.OnItemSelectedListener {
        //Khi c� ch?n l?a th� v�o h�m n�y
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 l� ph?n t? ???c ch?n trong data source
            if (arg2 == 0) goUrl(urlTemp);
            else if (arg2 == 1) goUrl(urlWind);
            else if (arg2 == 2) goUrl(urlRain);

        }


        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void goUrl(String url) {

        mapview.getSettings().setLoadsImagesAutomatically(true);
        mapview.getSettings().setJavaScriptEnabled(true);
        mapview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mapview.loadUrl(url);
    }

}
