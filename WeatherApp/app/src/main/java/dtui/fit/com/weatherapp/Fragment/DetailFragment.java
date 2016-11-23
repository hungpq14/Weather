package dtui.fit.com.weatherapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import dtui.fit.com.weatherapp.Adapter.HumidityAdapter;
import dtui.fit.com.weatherapp.Adapter.PrecipitationAdapter;
import dtui.fit.com.weatherapp.Adapter.TemperatureAdapter;
import dtui.fit.com.weatherapp.Adapter.WindSpeedAdapter;
import dtui.fit.com.weatherapp.Constant.ExampleHourlyForecast;
import dtui.fit.com.weatherapp.Object.HourlyForecast;
import dtui.fit.com.weatherapp.R;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class DetailFragment extends Fragment {
    private View view;
    private int currentAngle = 0;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);

        calculateCircleLayout();
        initDraw();

        return view;
    }

    private void initDraw() {
        view.findViewById(R.id.layout_temperature).setOnClickListener(detailAdapterListener);
        view.findViewById(R.id.layout_click_humidity).setOnClickListener(detailAdapterListener);
        view.findViewById(R.id.layout_click_precipitation).setOnClickListener(detailAdapterListener);
        view.findViewById(R.id.layout_bottom_main).setOnClickListener(detailAdapterListener);

        ((ImageView) view.findViewById(R.id.img_wind_pointer)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rotate_circle));

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        TemperatureAdapter adapter = new TemperatureAdapter(ExampleHourlyForecast.getSampleListTemperature());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        ExampleHourlyForecast.initListTemperature(adapter);
    }

    private void calculateCircleLayout() {
        final View layoutCircle = view.findViewById(R.id.layout_circle_detail);
        ViewTreeObserver viewTreeObserver = layoutCircle.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layoutCircle.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width = layoutCircle.getMeasuredWidth();
                int height = layoutCircle.getMeasuredHeight();

                fixSizeOfCircleLayout(width, height);
            }
        });
    }

    public void fixSizeOfCircleLayout(int width, int height) {
        Log.d("Main", width + " " + height);
        int sizeCircleLayout = (int) (height * 0.96);

        view.findViewById(R.id.layout_humidity).setTranslationX((float) (sizeCircleLayout * 0.112));
        view.findViewById(R.id.layout_UV).setTranslationX((float) (sizeCircleLayout * 0.1112));
        view.findViewById(R.id.view_line_horizontal_left).setTranslationX((float) (sizeCircleLayout * 0.112));
        view.findViewById(R.id.layout_visibility).setTranslationX((float) -(sizeCircleLayout * 0.112));
        view.findViewById(R.id.layout_precipitation).setTranslationX((float) -(sizeCircleLayout * 0.112));
        view.findViewById(R.id.view_line_horizontal_right).setTranslationX((float) -(sizeCircleLayout * 0.112));
        view.findViewById(R.id.txt_compass_east).setTranslationX((float) -(sizeCircleLayout * 0.04));
        view.findViewById(R.id.txt_compass_west).setTranslationX((float) (sizeCircleLayout * 0.03));

    }

    View.OnClickListener detailAdapterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == view.findViewById(R.id.layout_temperature)) {
                final TemperatureAdapter adapter = new TemperatureAdapter(ExampleHourlyForecast.getSampleListTemperature());
                recyclerView.setAdapter(adapter);
                recyclerView.setItemAnimator(new FadeInUpAnimator());
                recyclerView.getItemAnimator().setAddDuration(100);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ExampleHourlyForecast.initListTemperature(adapter);
                    }
                }, 80);

                rotateImgCurrentState(0);
            } else if (v == view.findViewById(R.id.layout_click_humidity)) {

                HumidityAdapter adapter = new HumidityAdapter(ExampleHourlyForecast.getHumidityList(), getActivity());
                recyclerView.setAdapter(adapter);
                rotateImgCurrentState(270);
            } else if (v == view.findViewById(R.id.layout_click_precipitation)) {

                PrecipitationAdapter adapter = new PrecipitationAdapter(ExampleHourlyForecast.getPrecipitationList());
                recyclerView.setAdapter(adapter);
                rotateImgCurrentState(90);
            } else if (v == view.findViewById(R.id.layout_bottom_main)) {

                final WindSpeedAdapter adapter = new WindSpeedAdapter(ExampleHourlyForecast.getWindSpeedList());
                recyclerView.setAdapter(adapter);
                recyclerView.setItemAnimator(new LandingAnimator());
                recyclerView.getItemAnimator().setAddDuration(150);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ExampleHourlyForecast.initListWindSpeed(adapter);
                    }
                },80);

                rotateImgCurrentState(180);
            }
        }
    };

    public void rotateImgCurrentState(int toDegree) {
        RotateAnimation rotate = new RotateAnimation(currentAngle, toDegree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(400);
        rotate.setInterpolator(new AccelerateDecelerateInterpolator());
        rotate.setFillAfter(true);
        rotate.setFillEnabled(true);

        ImageView image = (ImageView) view.findViewById(R.id.img_compass);
        image.startAnimation(rotate);

        currentAngle = toDegree;
    }

}
