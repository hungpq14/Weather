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
import android.util.Log;
import android.widget.RemoteViews;

import dtui.fit.com.weatherapp.Activity.MainActivity;
import dtui.fit.com.weatherapp.R;
import dtui.fit.com.weatherapp.Utils.Utils;

/**
 * Created by Hungpq on 12/3/16.
 */

public class CurrentConditionNoti extends NotificationCompat.Builder {
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
    public CurrentConditionNoti(Context context, int type) {
        super(context);
        this.context = context;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_current_condition);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        this.setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setOngoing(true);

        remoteViews.setImageViewResource(R.id.img_icon_launcher, R.mipmap.ic_launcher);
        remoteViews.setImageViewBitmap(R.id.txt_current_temp, buildCurrentTemp());
        remoteViews.setImageViewBitmap(R.id.img_next_6_hour, buildNext6HourTemp());

    }

    public Bitmap buildCurrentTemp() {
        int height = (int) Utils.convertDpToPixel(45, context);
        int width = (int) Utils.convertDpToPixel(140, context);
        int textSize = (int) Utils.convertSpToPixel(16, context);
        int marginTextLine = (int) Utils.convertSpToPixel(2, context);

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
        text1 = "Hanoi, Viet Nam";
        text2 = "28°C";

        paint.getTextBounds(text1, 0, text1.length(), rectangle);

        int centerHeight = height / 2;


        canvas.drawText(text2, 0, centerHeight + marginTextLine + rectangle.height(), paint);

        paint.setTextSize((int) Utils.convertSpToPixel(14, context));
        canvas.drawText(text1, 0, centerHeight - marginTextLine, paint);

        return bitmap;
    }

    public Bitmap buildNext6HourTemp() {

        int textSize1 = (int) Utils.convertSpToPixel(14, context);
        int textSize2 = (int) Utils.convertSpToPixel(16, context);

        Paint paint = new Paint();
        Typeface clock = Typeface.createFromAsset(context.getAssets(), "fonts/UTM Avo.ttf");
        paint.setTypeface(clock);
        paint.setAntiAlias(true);
        paint.setSubpixelText(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(context.getResources().getColor(R.color.black));

        paint.setTextSize(textSize1);

        /**
         * the rectangle of the text paint
         */
        Rect rectangle1 = new Rect();
        String text1, text2;
        text1 = "Next 6 hours ";

        Rect rectangle2 = new Rect();
        text2 = "18°C";

        paint.getTextBounds(text1, 0, text1.length(), rectangle1);
        paint.setTextSize(textSize2);
        paint.getTextBounds(text2, 0, text2.length(), rectangle2);

        int height = (int) Utils.convertDpToPixel(45, context);
        int width = (int) rectangle1.width() + rectangle2.width();

        Bitmap bitmap = Bitmap.createBitmap(width + 10, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        paint.setTextSize(textSize1);
        canvas.drawText(text1, 0, height - rectangle1.height(), paint);

        paint.setTextSize(textSize2);
        canvas.drawText(text2, rectangle1.width() + 6, height - rectangle1.height(), paint);

        return bitmap;
    }

}
