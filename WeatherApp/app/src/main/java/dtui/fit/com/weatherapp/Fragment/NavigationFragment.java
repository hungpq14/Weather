package dtui.fit.com.weatherapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import dtui.fit.com.weatherapp.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class NavigationFragment extends Fragment {
    private NavigationDrawerCallbacks mCallbacks;
    LinearLayout itemSetting, itemMap, itemLocation;


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
        itemMap = (LinearLayout) getView().findViewById(R.id.navigation_item_map);
        itemLocation = (LinearLayout) getView().findViewById(R.id.navigation_item_location);

        itemSetting.setOnClickListener(navClickItem);
        itemMap.setOnClickListener(navClickItem);
        itemLocation.setOnClickListener(navClickItem);

    }

    View.OnClickListener navClickItem = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.equals(itemSetting)) {
                selectItem(0);
            } else if (v.equals(itemMap)) {
                selectItem(1);
            } else if (v.equals(itemLocation)){
                View view = getView().findViewById(R.id.navigation_item_position);
                ImageView img = (ImageView) getView().findViewById(R.id.img_expand);
                if (view.getVisibility() == View.GONE){
                    view.setVisibility(View.VISIBLE);
                    img.setImageResource(R.drawable.ic_expand);
                } else {
                    view.setVisibility(View.GONE);
                    img.setImageResource(R.drawable.ic_collapse);
                }
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
