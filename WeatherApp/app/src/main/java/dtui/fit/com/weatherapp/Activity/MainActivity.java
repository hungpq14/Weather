package dtui.fit.com.weatherapp.Activity;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.reginald.swiperefresh.CustomSwipeRefreshLayout;

import java.util.BitSet;
import java.util.Locale;

import dtui.fit.com.weatherapp.Base.BaseFontActivity;
import dtui.fit.com.weatherapp.Fragment.MainFragment;
import dtui.fit.com.weatherapp.Fragment.NavigationFragment;
import dtui.fit.com.weatherapp.R;
import dtui.fit.com.weatherapp.Utils.Utils;

public class MainActivity extends BaseFontActivity implements NavigationFragment.NavigationDrawerCallbacks {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        initDrawer();

        /**
         * get the main fragment
         */
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        if (mMainFragment == null) {
            mMainFragment = new MainFragment();
            transaction.add(R.id.container, mMainFragment);
        } else {
            transaction.show(mMainFragment);
        }
        transaction.commit();

    }


    private void hideFragments(FragmentTransaction transaction) {
        if (mMainFragment != null) {
            transaction.hide(mMainFragment);
        }
    }

    public void initDrawer() {
        if (toolbar != null) {
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_menu));
        }

        //set action cho show up negative layout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opendrawer, R.string.closedrawer) {
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                if (item != null && item.getItemId() == android.R.id.home) {
                    int drawerLockMode = drawerLayout.getDrawerLockMode(GravityCompat.START);
                    if (drawerLayout.isDrawerVisible(GravityCompat.START)
                            && (drawerLockMode != DrawerLayout.LOCK_MODE_LOCKED_OPEN)) {

                    } else if (drawerLockMode != DrawerLayout.LOCK_MODE_LOCKED_CLOSED) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                    return true;
                }
                return false;
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("Main", "statusBarHeight: " + statusBarHeight);
        RelativeLayout.LayoutParams lp;
//        lp = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
//        lp.setMargins(0, statusBarHeight, 0, 0);
//        toolbar.setLayoutParams(lp);

        int navigationBarHeight = 0;
        resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("Main", "Navigation bar height: " + navigationBarHeight);
//        lp = (RelativeLayout.LayoutParams) findViewById(R.id.container).getLayoutParams();
//        lp.setMargins(0, 0, 0, navigationBarHeight);
//        findViewById(R.id.container).setLayoutParams(lp);

        lp = (RelativeLayout.LayoutParams) findViewById(R.id.swipe_layout).getLayoutParams();
        lp.setMargins(0, statusBarHeight, 0, navigationBarHeight);
        findViewById(R.id.swipe_layout).setLayoutParams(lp);

        final KenBurnsView kenBurnsView = (KenBurnsView) findViewById(R.id.kbv_img_bg);
        RandomTransitionGenerator generator = new RandomTransitionGenerator(24000, new LinearInterpolator());
        kenBurnsView.setTransitionGenerator(generator);

        Bitmap bitmap = ((BitmapDrawable) kenBurnsView.getDrawable()).getBitmap();
        Bitmap bluredBitmap = Utils.blur(getApplicationContext(), bitmap);
        kenBurnsView.setImageBitmap(bluredBitmap);
        kenBurnsView.setFitsSystemWindows(true);

        final CustomSwipeRefreshLayout customSwipeRefreshLayout = (CustomSwipeRefreshLayout) findViewById(R.id.swipe_layout);
        customSwipeRefreshLayout.setOnRefreshListener(new CustomSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ha_noi_3);
                        Bitmap bluredBitmap = Utils.blur(getApplicationContext(), bitmap);
                        kenBurnsView.setImageBitmap(bluredBitmap);
                        customSwipeRefreshLayout.refreshComplete();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case (0): {
                startActivity(new Intent(this, SignInActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case (3): {
                startActivity(new Intent(this, SettingActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case (2): {
                startActivity(new Intent(this, MapActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case (4): {
                startActivity(new Intent(this, WeatherNewsActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
        }
    }


    /**
     * get the language default in phone and change it if the language in app has changed
     */
    public void changLanguageIfNeed(String languageCurrent) {
        Log.d("main", "current language " + getResources().getConfiguration().locale.toString());
        Log.d("main", "change language to " + languageCurrent);
        String languageToLoad; // your language

        switch (languageCurrent) {
            case "en": {
                languageToLoad = "en";
                break;
            }
            case "vi": {
                languageToLoad = "vi";
                break;
            }
            default: {
                languageToLoad = Locale.getDefault().getLanguage();
                break;
            }
        }

        Locale locale = new Locale(languageToLoad);
        Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

}

