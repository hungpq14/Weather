package dtui.fit.com.weatherapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dtui.fit.com.weatherapp.Object.HourlyForecast;
import dtui.fit.com.weatherapp.R;
import me.itangqi.waveloadingview.WaveLoadingView;

/**
 * Created by phamh_000 on 19/11/2016.
 */
public class PrecipitationAdapter extends RecyclerView.Adapter<PrecipitationAdapter.MyViewHolder> {
    private List<HourlyForecast> hourlyForecastList;

    public PrecipitationAdapter(List<HourlyForecast> hourlyForecastList) {
        this.hourlyForecastList = hourlyForecastList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_precipitation, parent, false);
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
        private TextView txtTime, txtPercent;
        private WaveLoadingView waveLoadingView;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtPercent = (TextView) itemView.findViewById(R.id.txt_percent_precipitation);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
            waveLoadingView = (WaveLoadingView) itemView.findViewById(R.id.wave_loading_view);
        }

        public void bind(HourlyForecast hourlyForecast) {
            txtPercent.setText(hourlyForecast.getPrecipitationPercent() + "%");
            txtTime.setText(hourlyForecast.getTime());
            waveLoadingView.setProgressValue(hourlyForecast.getPrecipitationPercent());
            if (hourlyForecast.getPrecipitationPercent() > 20)
                waveLoadingView.setAmplitudeRatio(30);
            else if (hourlyForecast.getPrecipitationPercent() > 40)
                waveLoadingView.setAmplitudeRatio(40);
            else waveLoadingView.setAmplitudeRatio(10);
        }
    }
}
