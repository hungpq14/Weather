package dtui.fit.com.weatherapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dtui.fit.com.weatherapp.Object.SpinnerModel;
import dtui.fit.com.weatherapp.R;

/**
 * Created by Win 81 on 11/28/2016.
 */
public class SpinnerAdapter extends ArrayAdapter<SpinnerModel> {
    int groupid;
    Activity context;
    ArrayList<SpinnerModel> list;
    LayoutInflater inflater;

    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<SpinnerModel> list) {
        super(context, id,list);
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(int possition, View convertView, ViewGroup parent){
        View itemView=inflater.inflate(groupid,parent,false);
        ImageView imageView =(ImageView) itemView.findViewById(R.id.imgIcon);
        imageView.setImageResource(list.get(possition).getImage());
        TextView textView=(TextView)itemView.findViewById(R.id.txtTitle);
        textView.setText(list.get(possition).getType());
        return itemView;
    }

    public View getDropDownView(int possition, View convertView,ViewGroup parent){
        return getView(possition,convertView,parent);
    }
}

