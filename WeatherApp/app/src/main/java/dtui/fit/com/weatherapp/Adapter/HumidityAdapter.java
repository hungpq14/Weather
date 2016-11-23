package dtui.fit.com.weatherapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dtui.fit.com.weatherapp.Object.DonutProgress;
import dtui.fit.com.weatherapp.Object.HourlyForecast;
import dtui.fit.com.weatherapp.R;
import dtui.fit.com.weatherapp.Utils.Utils;

/**
 * Created by phamh_000 on 23/11/2016.
 */
public class HumidityAdapter extends RecyclerView.Adapter<HumidityAdapter.MyViewHolder> {
    private List<HourlyForecast> hourlyForecastList;
    private Activity activity;

    public HumidityAdapter(List<HourlyForecast> hourlyForecastList, Activity activity) {
        this.hourlyForecastList = hourlyForecastList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_humidity, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HourlyForecast hourlyForecast = hourlyForecastList.get(position);
        holder.bind(hourlyForecast);
    }

    @Override
    public int getItemCount() {
        return hourlyForecastList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private DonutProgress donutProgress;
        private TextView txtTime, txtHumidity;
        private Timer timer;

        public MyViewHolder(View itemView) {
            super(itemView);
            donutProgress = (DonutProgress) itemView.findViewById(R.id.progress_humidity);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
            txtHumidity = (TextView) itemView.findViewById(R.id.txt_percent_humidity);
        }

        public void bind(final HourlyForecast hourlyForecast) {
            txtTime.setText(hourlyForecast.getTime());
            txtHumidity.setText(hourlyForecast.getPrecipitationPercent() + "%");

            timer = null;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (donutProgress.getProgress() >= hourlyForecast.getPrecipitationPercent())
                                    timer.cancel();
                                else donutProgress.setProgress(donutProgress.getProgress() + 1);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        donutProgress.setProgress(hourlyForecast.getPrecipitationPercent());
                    }
                }
            }, 50, 20);

        }
    }
}
