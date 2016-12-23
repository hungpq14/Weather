package dtui.fit.com.weatherapp.Constant;

import java.util.ArrayList;
import java.util.List;

import dtui.fit.com.weatherapp.Object.NewsFeed;
import dtui.fit.com.weatherapp.R;

/**
 * Created by phamh_000 on 04/12/2016.
 */
public class FeedSeeder {
    public static List<NewsFeed> newsFeeds = new ArrayList<>();

    public static List<NewsFeed> getNewsFeeds() {
        newsFeeds.clear();
        newsFeeds.add(new NewsFeed(R.drawable.mark_profile, R.mipmap.supermoon, "Mark Zuckerberg", "Super moon in Vietnam #2016 #supermoon", "30,000 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.beckham, 0, "David Beckham", "Join with us now to protect the environment and reduce greenhouse gases #unicef #greenhouse", "158,867 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.genk, R.mipmap.dong_tia, "Genk", "Dòng tia là một trong những hiện tượng thời tiết nguy hiểm nhất trên trái đất. Chúng là những cơn gió dữ dội thổi từ hướng Tây ở trên tầng không khí cao #dongtia #hientuonghtoitietthuvi", "69 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.vtv_weather, R.mipmap.storm, "VTV", "Hình ảnh từ vệ tinh vừa được chuyển về của cơn bão số 2 sắp đổ bộ vào nước ta", "212 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.huyme, R.mipmap.mua_da, "HuyMeProduction", "Lần đầu tiên nhìn thấy mưa đá ở sa mạc #hailstone #Australia #AliceSprings", "2,126 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.hang_nga, 0, "Hằng Nga", "Tối nay có ai đi ngắm siêu trăng với mình hem #Alone #Supermoon2016", "96 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.miss_vnu, R.mipmap.rainbow, "Bá Huệ", "Lần đầu nhìn thấy cầu vồng đẹp như này #firsttime #rainbow", "99,999 likes"));
        newsFeeds.add(new NewsFeed(R.drawable.mark_profile, R.mipmap.supermoon, "Mark Zuckerberg", "Super moon in Vietnam #2016 #supermoon", "69 likes"));

        return newsFeeds;
    }
}
