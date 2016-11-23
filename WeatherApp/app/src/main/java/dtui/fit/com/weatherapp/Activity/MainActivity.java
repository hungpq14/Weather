package dtui.fit.com.weatherapp.Activity;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

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

        KenBurnsView kenBurnsView = (KenBurnsView) findViewById(R.id.kbv_img_bg);
        RandomTransitionGenerator generator = new RandomTransitionGenerator(20000, new LinearInterpolator());
        kenBurnsView.setTransitionGenerator(generator);

        Bitmap bitmap = ((BitmapDrawable)kenBurnsView.getDrawable()).getBitmap();
        Bitmap bluredBitmap = Utils.blur(getApplicationContext(), bitmap);
        kenBurnsView.setImageBitmap(bluredBitmap);
        kenBurnsView.setFitsSystemWindows(true);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case (0): {
                startActivity(new Intent(this, MapActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case (1): {
                startActivity(new Intent(this, SettingActivity.class));
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

