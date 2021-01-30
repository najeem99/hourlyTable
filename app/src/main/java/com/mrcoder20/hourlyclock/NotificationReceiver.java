package com.mrcoder20.hourlyclock;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationReceiver extends BroadcastReceiver {
    public static String CHANNEL_ID="12";
    public static String name="HourlyClock";
    public NotificationManager manager;
    DatabaseOpenHelper databasehelp;
    String p1 = "no data";
    String p2 = "no data";
    String p3 = "no data";
    String p4 = "no data";
    String p5 = "no data";
    String p6 = "no data";
    String p7 = "no data";
    String p8 = "no data";
    String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("NR","Reached onReceive");
        SimpleDateFormat sdf = new SimpleDateFormat("u");
        SimpleDateFormat tit=new SimpleDateFormat("EEEE");
        Date d1 = new Date();
        String titlefornoti=tit.format(d1);
        Date d = new Date();
        Log.d("Day", String.valueOf(d));
       String day=sdf.format(d);
        int dayOfTheWeek = Integer.parseInt(sdf.format(d));
//sharedpref
        String tablename="cse_s6_b";
        SharedPreferences getdata=context.getSharedPreferences("something", Context.MODE_PRIVATE);
        String k=getdata.getString("department",tablename);
        Log.d("sharedpref", k);
        //sharedpref

        if(dayOfTheWeek<=5) {
            ///database data getter

            databasehelp = new DatabaseOpenHelper(context);
            Cursor cursor =databasehelp.readData(k,day);
            if(cursor.getCount()==0){
                Log.d("Main Activity cursor","Database not found");

            }
            else {
                while (cursor.moveToNext()){
                    p1 =cursor.getString(1);
                    p2 =cursor.getString(2);
                    p3 =cursor.getString(cursor.getColumnIndex("p3"));
                    p4 =cursor.getString(cursor.getColumnIndex("p4"));
                    p5 =cursor.getString(cursor.getColumnIndex("p5"));
                    p6 =cursor.getString(cursor.getColumnIndex("p6"));
                    p7 =cursor.getString(cursor.getColumnIndex("p7"));
                    p8 =cursor.getString(cursor.getColumnIndex("p8"));



                }}
             message="1st Period " +p1 +"\n 2nd Period " +p2 +"\n 3rd Period " +p3+"\n 4th Period " +p4+"\n 5th Period " +p6+"\n 6th Period " +p7+"\n 7th Period " +p8 ;

            SimpleDateFormat s=new SimpleDateFormat("H");
            Date d11=new Date();
            int t=Integer.parseInt(s.format(d11));

            SimpleDateFormat s1=new SimpleDateFormat("m");
            Date d111=new Date();
            int t1=Integer.parseInt(s1.format(d111));
            ///database data getter
            //////notification maker
            if(t==8 && t1<17) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setAutoCancel(true)
                        .setContentTitle(titlefornoti)
                        .setContentText("HourlyClock")
                        .setSmallIcon(R.drawable.logotrans)

                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(message))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
                Log.d("NR", "All setted");
                NotificationManagerCompat notificmanager = NotificationManagerCompat.from(context);
                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                builder.setSound(alarmSound);
                notificmanager.notify(null, 0, builder.build());
                ///notification maker
            }
        }
    }
}
