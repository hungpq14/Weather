package dtui.fit.com.weatherapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import dtui.fit.com.weatherapp.Constant.SampleSettingDetail;
import dtui.fit.com.weatherapp.Object.Event.SettingClickEvent;
import dtui.fit.com.weatherapp.Object.SettingDetail;
import dtui.fit.com.weatherapp.R;

/**
 * Created by Hungpq on 12/3/16.
 */

public class SettingDetailAdapter extends RecyclerView.Adapter<SettingDetailAdapter.ViewHolder> {
    private List<SettingDetail> settingDetails;

    public SettingDetailAdapter(List<SettingDetail> settingDetails) {
        this.settingDetails = settingDetails;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_detail_setting, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SettingDetail settingDetail = settingDetails.get(position);
        holder.bind(settingDetail, position);
    }

    @Override
    public int getItemCount() {
        return settingDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDetail;
        ImageView imgChosen;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);

            txtDetail = (TextView) itemView.findViewById(R.id.txt_detail_setting);
            imgChosen = (ImageView) itemView.findViewById(R.id.img_detail_chosen);
            this.itemView = itemView;
        }

        public void bind(final SettingDetail settingDetail, final int position) {
            txtDetail.setText(settingDetail.getText());
            if (settingDetail.isChecked()) {
                imgChosen.setVisibility(View.VISIBLE);
                imgChosen.setImageResource(R.drawable.check);
            } else imgChosen.setVisibility(View.INVISIBLE);


            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!settingDetail.isChecked()) {
                        EventBus.getDefault().post(new SettingClickEvent(position));
                    }

                }
            });
        }
    }

}
