package dtui.fit.com.weatherapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import dtui.fit.com.weatherapp.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class NavigationFragment extends Fragment {
    private NavigationDrawerCallbacks mCallbacks;
    LinearLayout itemSetting;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListener();
    }

    private void setListener() {
        itemSetting = (LinearLayout) getView().findViewById(R.id.navigation_item_setting);

        itemSetting.setOnClickListener(navClickItem);

    }

    View.OnClickListener navClickItem = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.equals(itemSetting)) {
                selectItem(0);
            }
        }
    };

    private void selectItem(int position) {
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    "Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    public static interface NavigationDrawerCallbacks {
        void onNavigationDrawerItemSelected(int position);
    }
}
