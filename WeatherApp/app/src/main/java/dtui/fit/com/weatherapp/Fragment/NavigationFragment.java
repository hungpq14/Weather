package dtui.fit.com.weatherapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import dtui.fit.com.weatherapp.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class NavigationFragment extends Fragment {
    private NavigationDrawerCallbacks mCallbacks;
    LinearLayout itemSetting, itemMap, itemLocation, itemSignIn, itemNews;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        int navigationBarHeight = 0;
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("Main", "Navigation bar height: " + navigationBarHeight);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.findViewById(R.id.layout_version).getLayoutParams();
        lp.setMargins(0, 0, 0, navigationBarHeight);
        view.findViewById(R.id.layout_version).setLayoutParams(lp);


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
        itemSignIn = (LinearLayout) getView().findViewById(R.id.navigation_item_sign_in);
        itemNews = (LinearLayout) getView().findViewById(R.id.navigation_item_news);

        itemSetting.setOnClickListener(navClickItem);
        itemMap.setOnClickListener(navClickItem);
        itemLocation.setOnClickListener(navClickItem);
        itemNews.setOnClickListener(navClickItem);
        itemSignIn.setOnClickListener(navClickItem);

    }

    View.OnClickListener navClickItem = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.equals(itemMap)) {
                selectItem(2);
            } else if (v.equals(itemSetting)) {
                selectItem(3);
            } else if (v.equals(itemLocation)) {
                View view = getView().findViewById(R.id.navigation_item_position);
                View view2 = getView().findViewById(R.id.navigation_item_position_2);
                ImageView img = (ImageView) getView().findViewById(R.id.img_expand);
                if (view.getVisibility() == View.GONE) {
                    view2.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
                    img.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    view2.setVisibility(View.GONE);
                    view.setVisibility(View.GONE);
                    img.setImageResource(R.drawable.ic_arrow_up);
                }
            } else if (v.equals(itemSignIn)) {
                selectItem(0);
            } else if (v.equals(itemNews)) {
                selectItem(4);
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
