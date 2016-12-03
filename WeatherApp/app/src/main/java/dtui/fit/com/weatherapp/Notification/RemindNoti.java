package dtui.fit.com.weatherapp.Notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import dtui.fit.com.weatherapp.Activity.MainActivity;
import dtui.fit.com.weatherapp.R;
import dtui.fit.com.weatherapp.Utils.Utils;

/**
 * Created by Hungpq on 12/3/16.
 */

public class RemindNoti extends NotificationCompat.Builder {
    private Context context;

    /**
     * Constructor.
     * <p/>
     * Automatically sets the when field to {@link System#currentTimeMillis()
     * System.currentTimeMillis()} and the audio stream to the
     * {@link Notification#STREAM_DEFAULT}.
     *
     * @param context A {@link Context} that will be used to construct the
     *                RemoteViews. The Context will not be held past the lifetime of this
     *                Builder object.
     */
    public RemindNoti(Context context, int type) {
        super(context);
        this.context = context;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_remind);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        this.setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setLights(Color.parseColor("#2979FF"), 600, 4000);

        remoteViews.setImageViewResource(R.id.img_icon_launcher, R.mipmap.ic_launcher);
        remoteViews.setImageViewBitmap(R.id.txt_notification, buildTextNotiRemind(type));
        if (type == 1)
            remoteViews.setImageViewResource(R.id.img_advice, R.mipmap.umbrella);
        else
            remoteViews.setImageViewResource(R.id.img_advice, R.mipmap.sweater);

    }

    /**
     * draw text percent information in noti by bitmap
     *
     * @param type
     * @return
     */
    public Bitmap buildTextNotiRemind(int type) {
        int height = (int) Utils.convertDpToPixel(45, context);
        int width = (int) Utils.convertDpToPixel(220, context);
        int textSize = (int) Utils.convertSpToPixel(14, context);
        int marginTextLine = (int) Utils.convertSpToPixel(1, context);

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        Typeface clock = Typeface.createFromAsset(context.getAssets(), "fonts/UTM Avo.ttf");
        paint.setTypeface(clock);
        paint.setAntiAlias(true);
        paint.setSubpixelText(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(context.getResources().getColor(R.color.black));

        paint.setTextSize(textSize);
        /**
         * the rectangle of the text paint
         */
        Rect rectangle = new Rect();
        String text1, text2;
        if (type == 1) {
            text1 = "Start dry today in Hanoi";
            text2 = "Rain is forecast";
        } else {
            text1 = "Will be cold this morning";
            text2 = "Remember to take your sweater";
        }
        paint.getTextBounds(text1, 0, text1.length(), rectangle);

        int centerHeight = height / 2;
        canvas.drawText(text2, 0, centerHeight + marginTextLine + rectangle.height(), paint);
        canvas.drawText(text1, 0, centerHeight - marginTextLine, paint);

        return bitmap;
    }
}
