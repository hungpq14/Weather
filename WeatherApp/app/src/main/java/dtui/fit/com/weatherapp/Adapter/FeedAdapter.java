package dtui.fit.com.weatherapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import dtui.fit.com.weatherapp.Object.NewsFeed;
import dtui.fit.com.weatherapp.R;

/**
 * Created by phamh_000 on 04/12/2016.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private List<NewsFeed> newsFeeds;
    private Context context;

    public FeedAdapter(List<NewsFeed> newsFeeds, Context context) {
        this.context = context;
        this.newsFeeds = newsFeeds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_feed, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsFeed newsFeed = newsFeeds.get(position);
        holder.bind(newsFeed);
    }

    @Override
    public int getItemCount() {
        return newsFeeds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgProfile;
        ImageView imgFeed;
        TextView txtName, txtLikeCount, txtFeedTenor;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProfile = (CircleImageView) itemView.findViewById(R.id.profile_image);
            imgFeed = (ImageView) itemView.findViewById(R.id.img_feed);
            txtName = (TextView) itemView.findViewById(R.id.profile_name);
            txtLikeCount = (TextView) itemView.findViewById(R.id.txt_like_count);
            txtFeedTenor = (TextView) itemView.findViewById(R.id.txt_feed_tenor);

        }

        public void bind(NewsFeed newsFeed) {
//            imgProfile.setImageResource(newsFeed.getRes_img_profile());
            Picasso.with(context)
                    .load(newsFeed.getRes_img_profile())
                    .into(imgProfile);

            if (newsFeed.getRes_img_feed() != 0) {
                imgFeed.setVisibility(View.VISIBLE);
//                imgFeed.setImageResource(newsFeed.getRes_img_feed());

                Picasso.with(context)
                        .load(newsFeed.getRes_img_feed())
                        .into(imgFeed);

            } else imgFeed.setVisibility(View.GONE);

            txtName.setText(newsFeed.getProfileName());
            txtLikeCount.setText(newsFeed.getLike_count());

            String textContent = "<font color=#000000>" + newsFeed.getProfileName() + "  </font>" + newsFeed.getFeed_new();
            txtFeedTenor.setText(Html.fromHtml(textContent));

        }
    }
}
