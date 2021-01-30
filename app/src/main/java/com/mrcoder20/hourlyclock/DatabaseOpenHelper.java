package com.mrcoder20.hourlyclock;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "najeem.db";
    //private static final String tablename = "cse_s6_b";
    //String tablename = "cse_s6_b";

    private static final int DATABASE_VERSION = 1;
    DatabaseAccess da;


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);





    }


    public Cursor readData(String tablename,String day_id) {



        Log.d("readdata", "get data function called");
        Log.d("dd",this.getDatabaseName());
        SQLiteDatabase db = this.getWritableDatabase();
        //da.open();


        String query = "SELECT * FROM "+tablename +" WHERE id = " +day_id;
        Cursor data = db.rawQuery(query, null);

        return data;

    }
    public Cursor getColumndata(String tablename,int i){
        String k=null;
        if(i==1)
            k="p1";
        else if (i==2)
            k="p2";
        else if (i==3)
            k="p3";
        else if (i==4)
            k="p4";
        else if (i==5)
            k="p5";
        else if (i==6)
            k="p6";
        else if (i==7)
            k="p7";
        else if (i==8)
            k="p8";

        Log.d("tablename", tablename);
        Log.d("readdata", "get data function called");
        Log.d("dd",this.getDatabaseName());
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT "+k +" FROM "+tablename ;
        Cursor data = db.rawQuery(query, null);
        return data;
    }




}
