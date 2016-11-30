package dtui.fit.com.weatherapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dtui.fit.com.weatherapp.Activity.WebViewActivity;
import dtui.fit.com.weatherapp.Models.Noti_data;
import dtui.fit.com.weatherapp.R;

/**
 * Created by Administrator on 28/11/2016.
 */

public class Adapter_RecycleView extends RecyclerView.Adapter {
    ArrayList<Noti_data> list;
    Context context;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    //    int previousposition;
    public Adapter_RecycleView(Context context, ArrayList<Noti_data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {

        return list.get(position).getTitle() == "" ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (viewType == VIEW_TYPE_ITEM) {
            View view = inflater.inflate(R.layout.webview_view_item, parent, false);
            ItemViewHolder holder = new ItemViewHolder(view);
            return holder;
        } else {
            View view = inflater.inflate(R.layout.footer_view, parent, false);
            LoadingViewHolder holder = new LoadingViewHolder(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.txt_title.setText(list.get(position).getTitle());
            itemViewHolder.txt_content.setText(list.get(position).getContent());


            Picasso.with(context).load(list.get(position).getImage()).into(itemViewHolder.imageView);
        } else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }


//        if(position>=previousposition){
//            AnimUlis.animate(holder,true);
//        }
//        else AnimUlis.animate(holder,false);
//
//        previousposition = position;

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressbar);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txt_title;
        TextView txt_content;
        ImageView imageView;
        String link;

        public ItemViewHolder(final View itemView) {
            super(itemView);

            txt_title = (TextView) itemView.findViewById(R.id.recycle_item_title);
            txt_content = (TextView) itemView.findViewById(R.id.recycle_item_content);
            imageView = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra("link", list.get(getAdapterPosition()).getLink());
                    context.startActivity(intent);
                }
            });
        }
    }
}


