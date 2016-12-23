package dtui.fit.com.weatherapp.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import dtui.fit.com.weatherapp.Adapter.FeedAdapter;
import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.Constant.FeedSeeder;
import dtui.fit.com.weatherapp.R;

public class FeedActivity extends BaseToolbarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_feed;
    }

    @Override
    public String getToolbarText() {
        return "The Weather Social";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDraw();
    }

    private void initDraw() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        FeedAdapter adapter = new FeedAdapter(FeedSeeder.getNewsFeeds(), getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feed_menu, menu);

//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        ComponentName componentName = new ComponentName(getBaseContext(), FeedActivity.class);

//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        searchItem.setIcon(getDrawable(R.drawable.people_picker_search));
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
//
//        //Khi an vao nut search va bat dau nhap phim
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                ((TextView) findViewById(R.id.txt_toolbar)).setText(getToolbarText());
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                ((TextView) findViewById(R.id.txt_toolbar)).setText("");
//                return true;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }
}
