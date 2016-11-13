package dtui.fit.com.weatherapp.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import dtui.fit.com.weatherapp.R;

/**
 * Created by phamh_000 on 13/11/2016.
 */
public class BaseToolbarActivity extends BaseFontActivity {
    private int layoutId;
    private String toolbarText = "Booster";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        setupToolbar();
    }

    public void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_back));

        ((TextView) findViewById(R.id.txt_toolbar)).setText(getToolbarText());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public int getLayoutId() {
        return layoutId;
    }

    public String getToolbarText() {
        return toolbarText;
    }
}
