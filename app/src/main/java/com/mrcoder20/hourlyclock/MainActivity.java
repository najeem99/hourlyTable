package com.mrcoder20.hourlyclock;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    DatabaseOpenHelper databasehelp;
    DatabaseAccess da;
    Button refreshbtn;

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    public void onRestart() {
        super.onRestart();
        //When BACK BUTTON is pressed, the activity on the stack is restarted
        //Do what you want on the refresh procedure here
        assingning_data();
      //  Toast.makeText(getApplicationContext(),"back",Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.dot_menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_menu:
                Intent intentabout=new Intent(MainActivity.this,about.class);
                startActivity(intentabout);
                break;
            case R.id.full_timetable:
                Intent intentfull=new Intent(MainActivity.this,FullTimeTable.class);
                startActivity(intentfull);
                break;
            case R.id.settingsbutton:
                Intent intentset=new Intent(MainActivity.this,Settings.class);
                startActivity(intentset);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Normal declarations

//current=(TextView)findViewById(R.id.text_currentperiod);
//upcomming=(TextView)findViewById(R.id.text_nextperiod);
        assingning_data();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //your method
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        // Stuff that updates the UI
                        assingning_data();

                    }
                });

            }
        }, 0, 30000);//put here time 1000 milliseconds=1 second




        ////////////////////////////////
//


    }
    public void assingning_data(){
        t1= findViewById(R.id.t1);
        t2= findViewById(R.id.t2);
        t3= findViewById(R.id.t3);
        t4= findViewById(R.id.t4);
        t5= findViewById(R.id.t5);
        t6= findViewById(R.id.t6);
        t7= findViewById(R.id.t7);
        t8= findViewById(R.id.t8);
        t9= findViewById(R.id.t9);
        t10= findViewById(R.id.t10);


        String p1 = "no data";
        String p2 = "no data";
        String p3 = "no data";
        String p4 = "no data";
        String p5 = "no data";
        String p6 = "no data";
        String p7 = "no data";
        String p8 = "no data";
        notificationfunction();
        //Normal declarations

        //Database Declarations----
        databasehelp = new DatabaseOpenHelper(getApplicationContext());
        da=DatabaseAccess.getInstance(this);        //SQLiteDatabase db = databasehelp.getReadableDatabase();

        //        //Database Declarations----
//day of the week
        SimpleDateFormat dayformat=new SimpleDateFormat("EEEE");
        Date dayfott1 = new Date();
        String d11 = dayformat.format(dayfott1);
        t1.setText(d11);
        SimpleDateFormat sdf = new SimpleDateFormat("u");
        Date d = new Date();
        Log.d("Day", String.valueOf(d));

        String dayOfTheWeek = sdf.format(d);
        Log.d("Day",dayOfTheWeek);


//day of the week
        SimpleDateFormat h = new SimpleDateFormat("H");
        Date d1 = new Date();
        float hour =  Integer.parseInt(h.format(d1));
        Log.d("time ass", String.valueOf(hour));
        SimpleDateFormat m = new SimpleDateFormat("m");
        Date d2 = new Date();
        String min =  "0." +(m.format(d2));
        float minute=Float.parseFloat(min);
        float time=hour+minute;
        Log.d("time ass", String.valueOf((time)));

////////////////////////////
        String tablename="cse_s6_b";
        SharedPreferences getdata=getSharedPreferences("something", MODE_PRIVATE);
        String k=getdata.getString("department",tablename);
        Log.d("sharedpref", k);
        //
        if(time>16.30){
            int abc=Integer.parseInt(dayOfTheWeek)+1;
            dayOfTheWeek=String.valueOf(abc);
            Date TODAY = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(TODAY);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            TODAY=cal.getTime();
            SimpleDateFormat dayformat1=new SimpleDateFormat("EEEE");

            d11 = dayformat1.format(TODAY);
            if(d11=="8"){

                dayOfTheWeek="0";
            }
            t1.setText("Timetable-"+d11);


        }
        t1.setText("jhfh");
        //Database get data
        Cursor cursor =databasehelp.readData(k,dayOfTheWeek);
        if(cursor.getCount()==0){
            Log.d("Main Activity cursor","Database not found");
            //Toast.makeText(MainActivity.this, "Database  not found",Toast.LENGTH_LONG).show();
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
        if(Integer.parseInt(dayOfTheWeek)<6) {
            t2.setText("PERIOD 1-" + p1);
            t3.setText("PERIOD 2-" + p2);
            t4.setText("INTERVAL -" + " BREAK");
            t5.setText("PERIOD 3-" + p3);
            t6.setText("PERIOD 4-" + p4);
            t7.setText("BREAK - " + p5);
            t8.setText("PERIOD 5-" + p6);
            t9.setText("PERIOD 6-" + p7);
            t10.setText("PERIOD 7-" + p8);
        }
        else {
            t2.setText("No Period Available as per Today Schedule");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
            t10.setText("");

        }

        //time finder             time variable is time which is a float
        if(Integer.parseInt(dayOfTheWeek) <= 5){
            if(time>0 && time<9.50){
                t2.setBackgroundResource(R.color.current_color);
                t2.setTypeface(null, Typeface.BOLD);
                t3.setBackgroundResource(R.color.next_color);
                //current.setText("Current Period -" +p1);
                // upcomming.setText("Next Period -" +p2);
            }
            else if(time>=9.50  && time<10.40) {
                // current.setText("Current Period -" +p2 +"\n Interval time after period ends");
                // upcomming.setText("Next Period -" +p3);
                t2.setBackgroundResource(android.R.color.transparent);

                t3.setBackgroundResource(R.color.current_color);
                t3.setTypeface(null, Typeface.BOLD);
                t5.setBackgroundResource(R.color.next_color);
            }
            else if(time>=10.40  && time<11.0) {
                //current.setText("Current Period - Interval");
                //upcomming.setText("Next Period -" +p3);
                t3.setBackgroundResource(android.R.color.transparent);

                t4.setBackgroundResource(R.color.current_color);
                t4.setTypeface(null, Typeface.BOLD);
                t5.setBackgroundResource(R.color.next_color);
            }
            else if(time>=11.1  && time<11.50) {
                //  current.setText("Current Period -" +p3);
                // upcomming.setText("Next Period -" +p4 );
                t4.setBackgroundResource(android.R.color.transparent);

                t5.setBackgroundResource(R.color.current_color);
                t5.setTypeface(null, Typeface.BOLD);
                t6.setBackgroundResource(R.color.next_color);
            }
            else if(time>=11.51  && time<12.40) {
                //current.setText("Current Period -" +p4);
                // upcomming.setText("Next Period -" +p5);
                t5.setBackgroundResource(android.R.color.transparent);

                t6.setBackgroundResource(R.color.current_color);
                t6.setTypeface(null, Typeface.BOLD);
                t7.setBackgroundResource(R.color.next_color);
            }
            else if(time>=12.40  && time<13.40) {
                // current.setText("Current Period -" +p5);
                // upcomming.setText("Next Period -" +p6);
                // t7.setBackgroundColor(R.color.current_color);
                t6.setBackgroundResource(android.R.color.transparent);

                t7.setBackgroundResource(R.color.current_color);
                t7.setTypeface(null, Typeface.BOLD);
                t8.setBackgroundResource(R.color.next_color);
            }
            else if(time>=13.40  && time<14.30) {
                // current.setText("Current Period -" +p6);
                // upcomming.setText("Next Period -" +p7);
                t7.setBackgroundResource(android.R.color.transparent);

                t8.setBackgroundResource(R.color.current_color);
                t8.setTypeface(null, Typeface.BOLD);
                t9.setBackgroundResource(R.color.next_color);
            }
            else if(time>=14.30  && time<15.20) {
                // current.setText("Current Period -" +p7);
                //upcomming.setText("Next Period -" +p8);
                t8.setBackgroundResource(android.R.color.transparent);

                t9.setBackgroundResource(R.color.current_color);
                t9.setTypeface(null, Typeface.BOLD);
                t10.setBackgroundColor(R.color.next_color);


            }
            else if(time>=15.20  && time<16.10) {
                //  current.setText("Current Period -" +p8);
                //upcomming.setText("After this period College Ends");
                t9.setBackgroundResource(android.R.color.transparent);

                t10.setBackgroundColor(R.color.current_color);
                t10.setTypeface(null, Typeface.BOLD);

            }
        }
        else {
            //current.setText("No period available as per today's Schedule");
            //upcomming.setText("Have a good day ");
        }


    }
    public void notificationfunction(){
        Log.d("NR","entered notificationfunction()");
        createChannels();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,8);
        calendar.set(Calendar.MINUTE,0);
        Intent intent = new Intent(getApplicationContext(),NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
    }
    private void createChannels() {
        String CHANNEL_ID="12";
        String name="HourlyClock";
        Log.d("n", "createChannels()1 done");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("notifiction","channel id and name");
            Log.d("notifiction",CHANNEL_ID);
            Log.d("notifiction",name);

            String description = "This is just a not";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            //Context mContext => Context.NOTIFICATION_SERVICE
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            Log.d("notifiction"," notificationManager. ...");

            Log.d("notifiction",notificationManager.toString());
        }
    }
public void sharedpref(){

}



     //Database getdata

    }

