package com.firstapp.jayden.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView timesTable;

    public void generateTimesTable(int timesTableNumber){
        final ListView timesTable = findViewById(R.id.timesTable);//target Listview
        ArrayList<String> timesNumber = new ArrayList<String>();//create new ArrayList

        for(int j = 1 ; j <= 10 ; j++){
            timesNumber.add(Integer.toString(timesTableNumber * j));
        }
        ArrayAdapter<String> myAdapterArray = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesNumber);
        timesTable.setAdapter(myAdapterArray);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTable = findViewById(R.id.timesTable);//target Listview
        final SeekBar timeSeekBar = (SeekBar) findViewById(R.id.timeSeekBar);//target seekbar
        int max = 10;
        int startingPosition = 1;
        timeSeekBar.setMax(max);//we must set the max for seekBar
        timeSeekBar.setProgress(startingPosition);//initailly position for seekBar

        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //What do you want to do When SeekBar condition has changed.
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//increase the table by 1
                int min = 1;//set minimum
                int timesTableNumber;
                if(i < min){
                   timesTableNumber = min;
                    timeSeekBar.setProgress(min);//make sure seekBar won't go down below 1
                }else{
                    //if i is not lower min then it equals to whatever the i is.
                    timesTableNumber = i;
                }
                generateTimesTable(timesTableNumber);//bring in generateTimesTable function
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
