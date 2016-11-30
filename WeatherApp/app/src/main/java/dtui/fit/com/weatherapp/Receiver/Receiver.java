package dtui.fit.com.weatherapp.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import dtui.fit.com.weatherapp.Service.MyService;

/**
 * Created by Administrator on 28/11/2016.
 */

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent toService= new Intent(context,MyService.class);
        context.startService(toService);
    }
}