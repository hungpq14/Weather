package dtui.fit.com.weatherapp.Object;

/**
 * Created by phamh_000 on 04/12/2016.
 */
public class NewsFeed {
    int res_img_profile, res_img_feed;
    String profileName, feed_new, like_count;

    public NewsFeed(int res_img_profile, int res_img_feed, String profileName, String feed_new, String like_count) {
        this.res_img_profile = res_img_profile;
        this.res_img_feed = res_img_feed;
        this.profileName = profileName;
        this.feed_new = feed_new;
        this.like_count = like_count;
    }

    public int getRes_img_profile() {
        return res_img_profile;
    }

    public void setRes_img_profile(int res_img_profile) {
        this.res_img_profile = res_img_profile;
    }

    public int getRes_img_feed() {
        return res_img_feed;
    }

    public void setRes_img_feed(int res_img_feed) {
        this.res_img_feed = res_img_feed;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFeed_new() {
        return feed_new;
    }

    public void setFeed_new(String feed_new) {
        this.feed_new = feed_new;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }
}
