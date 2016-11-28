package dtui.fit.com.weatherapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dtui.fit.com.weatherapp.Base.BaseToolbarActivity;
import dtui.fit.com.weatherapp.R;

public class SignInActivity extends BaseToolbarActivity {

    @Override
    public String getToolbarText() {
        return "Sign In";
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
