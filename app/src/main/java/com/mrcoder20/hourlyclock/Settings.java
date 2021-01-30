package com.mrcoder20.hourlyclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Spinner element
        Spinner spinner = findViewById(R.id.settingspinner);

       /* ArrayList categories = new ArrayList<String>();
        categories.add("CSE 6th Semester Sec-B");
        categories.add("CIVIL 6th Semester Sec-B");
        categories.add("MECH 6th Semester Sec-C");

        */
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.deptname,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String txt=parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),txt +" Selected",Toast.LENGTH_SHORT).show();
        Log.d("spinnersettings",txt);
        String database_name_converter=null;
        switch (txt){
            case "CSE 6th Semester Sec-B":database_name_converter="cse_s6_b";
                                           break;
            case "CIVIL 6th Semester Sec-B":database_name_converter="civil_s6_b";
                break;
            case "MECH 6th Semester Sec-C":database_name_converter="mech_s6_c";
                break;
        }
        Log.d("spinnersettings",database_name_converter);
        //SharedPreferences
        SharedPreferences preferences=getSharedPreferences("something",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("department",database_name_converter);
        editor.commit();
        //SharedPreferences

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
