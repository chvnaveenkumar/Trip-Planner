package com.example.s530742.chandaluri_assignment2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText distanceinMiles, speedinMilesPerHour,break_15_Minites;
    TextView result,breakTime;
    double distance, speed,breakChangeTime;
    int break_details;
    double hours;
    RadioGroup rg;
    RadioButton oneWay;
    int selectedValueId,h,min,sec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        distanceinMiles = (EditText) findViewById(R.id.distanceinMiles);
        speedinMilesPerHour = (EditText) findViewById(R.id.speedinMilesPerHour);
        break_15_Minites = (EditText) findViewById(R.id.break_15_Minites);
        breakTime = (TextView) findViewById(R.id.breakTime);
        result = (TextView) findViewById(R.id.result);
        rg  = (RadioGroup) findViewById(R.id.rgroup);
        oneWay = (RadioButton) findViewById(R.id.radioButton10);

    }

    public void calculateTime(View v) {
        try {
            distance =  Double.parseDouble(distanceinMiles.getText().toString());
            speed = Double.parseDouble(speedinMilesPerHour.getText().toString());
            break_details = Integer.parseInt(break_15_Minites.getText().toString());
            breakChangeTime = Integer.parseInt(breakTime.getText().toString());

            RadioGroup choiceWay;
            selectedValueId = rg.getCheckedRadioButtonId();
            //checking the id of the selected radio
            if(selectedValueId == oneWay.getId())
            {
                hours = (distance/speed)*60 + break_details*breakChangeTime;
            }else
            {
                hours = ((distance/speed)/60) + break_details*breakChangeTime;
            }
            h = (int) (hours/60);
            min = (int) (hours%60);
            result.setTextColor(Color.BLUE);
            result.setText(h+" Hours "+min+" Mins ");

        } catch(NumberFormatException nfe) {
            result.setText("Enter all the fields");
        }
    }

    public void reset(View v)
    {
        distanceinMiles.setText("");
        speedinMilesPerHour.setText("");
        break_15_Minites.setText("");
        result.setText("");
        breakTime.setText("");
    }

    public void feet(View v)
    {
        distanceinMiles.setText("");
        speedinMilesPerHour.setText("");
        break_15_Minites.setText("");
        result.setText("");
        breakTime.setText("");
        distanceinMiles.setHint("Enter distance in feet");
        speedinMilesPerHour.setHint("Enter speed in feet/second");
    }
    public void miles(View v)
    {
        distanceinMiles.setText("");
        speedinMilesPerHour.setText("");
        break_15_Minites.setText("");
        result.setText("");
        breakTime.setText("");
        distanceinMiles.setHint("Enter distance in miles");
        speedinMilesPerHour.setHint("Enter speed in miles/hour");
    }
}

