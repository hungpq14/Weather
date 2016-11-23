package dtui.fit.com.weatherapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import dtui.fit.com.weatherapp.R;

/**
 * Created by Pham Minh Hoang Linh on 11/18/2016.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {

    private Context context;
    private static final String[] days = {"TODAY", "SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};


    public ExpandAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return 10;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            v = LayoutInflater.from(context).inflate(R.layout.layout_group_list, viewGroup, false);
        }
        TextView textView = (TextView) v.findViewById(R.id.day);

        textView.setText(days[i]);
        int ic_arrow = i%2==0? R.drawable.ic_rain:R.drawable.ic_sun;
        ImageView imgArrow = (ImageView) v.findViewById(R.id.weather);
        int bgColor  = b? Color.parseColor("#f7f7f7"):Color.WHITE;

//        v.setBackgroundColor(bgColor);
        imgArrow.setImageResource(ic_arrow);
        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            v = LayoutInflater.from(context).inflate(R.layout.layout_item_list, viewGroup, false);
        }

//        TextView textView = (TextView) v.findViewById(R.id.details_day);
//        textView.setText("ok");

        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
