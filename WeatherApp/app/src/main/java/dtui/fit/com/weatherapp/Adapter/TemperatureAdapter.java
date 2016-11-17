package dtui.fit.com.weatherapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dtui.fit.com.weatherapp.Object.HourlyTemperature;
import dtui.fit.com.weatherapp.R;

/**
 * Created by phamh_000 on 17/11/2016.
 */
public class TemperatureAdapter extends RecyclerView.Adapter<TemperatureAdapter.MyViewHolder> {
    private List<HourlyTemperature> hourlyTemperatureList;

    public TemperatureAdapter(List<HourlyTemperature> hourlyTemperatureList) {
        this.hourlyTemperatureList = hourlyTemperatureList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_temperature, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HourlyTemperature hourlyTemperature = hourlyTemperatureList.get(position);
        holder.bind(hourlyTemperature);
    }

    @Override
    public int getItemCount() {
        return hourlyTemperatureList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgIcon;
        private TextView txtTime, txtTemperature;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.img_weather);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
            txtTemperature = (TextView) itemView.findViewById(R.id.txt_temperature);
        }

        public void bind(HourlyTemperature hourlyTemperature){
            imgIcon.setImageResource(R.mipmap.wsymbol_thundery_showers_ln);
            txtTime.setText(hourlyTemperature.getTime());
            txtTemperature.setText(hourlyTemperature.getTemperature());
        }
    }
}
