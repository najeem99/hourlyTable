package com.mrcoder20.hourlyclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class FullTimeTable extends AppCompatActivity {
    DatabaseOpenHelper da;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_time_table);
        da = new DatabaseOpenHelper(getApplicationContext());
        String period = null;
        TableLayout tableview = findViewById(R.id.tableview);
        tableview.setPadding(15, 3, 15, 60);
        ///
        int h = 0;
        String tablename="cse_s6_b";
        SharedPreferences getdata=getSharedPreferences("something", MODE_PRIVATE);
        String k=getdata.getString("department",tablename);
        Log.d("sharedpref", k);
        for (int i = 0; i < 9; i++) {
            String[] a = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
            TableRow row = new TableRow(this);

            TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            row.setPadding(15, 25, 15, 40);



            if(i==0){

                TextView Header = new TextView(this);

                Header.setGravity(Gravity.CENTER);

                Header.setText(a[h]);
                h = h + 1;
                Header.setTextSize(35.0f);
                Header.setPadding(15, 0, 15, 0);
                Header.setTextColor(getResources().getColor(R.color.days_color_in_table_txt));
                Header.setTypeface(null, Typeface.BOLD);

                row.addView(Header);




                for (int j = 1; j < 5; j++) {
                    TextView Values = new TextView(this);
                    Values.setPadding(15, 0, 15, 0);
                    Values.setGravity(Gravity.CENTER);
                    Values.setTextSize(35.0f);
                    Values.setTextColor(getResources().getColor(R.color.days_color_in_table_txt));
                    Values.setTypeface(null, Typeface.BOLD);



                    Values.setText(a[j]);
                    row.addView(Values);

                }
                tableview.addView(row);
                //if ingathan mudithu
            }

            else{

                //sql data getting
                String[] datafromsql = new String[5];

                Cursor cursor =da.getColumndata(k,i);
                if(cursor.getCount()==0){
                    Log.d("Main Activity cursor","Database not found");
                    Toast.makeText(FullTimeTable.this, "Database  not found",Toast.LENGTH_LONG).show();
                }
                else {
                    int f=0;
                    while (cursor.moveToNext()){
                        datafromsql[f] =cursor.getString(0);
                        f=f+1;


                    }}
                //sql data getting

                //else setting data bro
            TextView Header = new TextView(this);

            Header.setGravity(Gravity.CENTER);

            Header.setText(datafromsql[0]);

            Header.setTextSize(30.0f);
            Header.setPadding(15, 0, 15, 0);
            Header.setTextColor(getResources().getColor(R.color.periods_color_in_table_bg));
            Header.setTypeface(null, Typeface.BOLD);


            row.addView(Header);


            for (int j =1 ; j <5 ; j++) {
                TextView Values = new TextView(this);
                Values.setPadding(15, 0, 15, 0);
                Values.setGravity(Gravity.CENTER);
                Values.setTextSize(30.0f);
                Values.setTextColor(getResources().getColor(R.color.periods_color_in_table_bg));
                Values.setTypeface(null, Typeface.BOLD);

                //get data from sql



                //get data from sql


                Values.setText(datafromsql[j]);
                row.addView(Values);
            }
            tableview.addView(row);
            //else ingathaan mudithu
        }}
    }
}