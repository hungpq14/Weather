package dtui.fit.com.weatherapp.Fragment;

import android.os.Bundle;
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
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import dtui.fit.com.weatherapp.Adapter.TemperatureAdapter;
import dtui.fit.com.weatherapp.Constant.ExampleHourlyTemperature;
import dtui.fit.com.weatherapp.R;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class DetailFragment extends Fragment {
    private View view;
    private int currentAngle = 0;

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

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        TemperatureAdapter adapter = new TemperatureAdapter(ExampleHourlyTemperature.getSampleListTemperature());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
                Log.d("Main", "Temperature");
                rotateImgCurrentState(0);
            } else if (v == view.findViewById(R.id.layout_click_humidity)) {
                Log.d("Main", "Humidity");
                rotateImgCurrentState(270);
            } else if (v == view.findViewById(R.id.layout_click_precipitation)) {
                Log.d("Main", "Precipitation");
                rotateImgCurrentState(90);
            } else if (v == view.findViewById(R.id.layout_bottom_main)) {
                Log.d("Main", "Wind speed");
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
