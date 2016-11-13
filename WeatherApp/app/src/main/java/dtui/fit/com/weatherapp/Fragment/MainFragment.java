package dtui.fit.com.weatherapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import dtui.fit.com.weatherapp.Adapter.ViewPagerAdapter;
import dtui.fit.com.weatherapp.R;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class MainFragment extends Fragment{
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        SmartTabLayout viewPagerTab = (SmartTabLayout) view.findViewById(R.id.view_pager_tab);
        viewPagerTab.setViewPager(viewPager);

        return view;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        DetailFragment detailFragment = new DetailFragment();
        ForecastFragment forecastFragment = new ForecastFragment();
        adapter.addFragment(detailFragment, "Now");
        adapter.addFragment(forecastFragment, "10 Days");
        viewPager.setAdapter(adapter);
    }
}
