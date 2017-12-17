package com.example.intern.toolbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button compasBut, levelerBut, magBut, vbrBut, flashBut, uConBut, currBut, countBut, stpwatchBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compasBut = findViewById(R.id.compassButton);
        levelerBut = findViewById(R.id.levelerButton);
        magBut = findViewById(R.id.magnetButton);
        vbrBut = findViewById(R.id.vibrButton);
        flashBut = findViewById(R.id.flashButton);
        uConBut = findViewById(R.id.uConvButton);
        currBut = findViewById(R.id.currButton);
        countBut = findViewById(R.id.counterButton);
        stpwatchBut = findViewById(R.id.stpWatchButton);

        compasBut.setOnClickListener(this);
        levelerBut.setOnClickListener(this);
        magBut.setOnClickListener(this);
        vbrBut.setOnClickListener(this);
        flashBut.setOnClickListener(this);
        uConBut.setOnClickListener(this);
        currBut.setOnClickListener(this);
        countBut.setOnClickListener(this);
        stpwatchBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        switch (v.getId()){
            case R.id.compassButton:
                i = new Intent(MainActivity.this, CompassActivity.class);
                compasBut.setText("Clicked");
                break;
            case R.id.levelerButton:
                //levelerBut.setText("Under Contruction");
                i = new Intent(MainActivity.this, LevelActivity.class);
                break;
            case R.id.magnetButton:
                magBut.setText("Under Contruction");
                break;
            case R.id.vibrButton:
                vbrBut.setText("Under Contruction");
                break;
            case R.id.flashButton:
                flashBut.setText("Under Contruction");
                break;
            case R.id.uConvButton:
                uConBut.setText("Under Contruction");
                break;
            case R.id.currButton:
                currBut.setText("Under Contruction");
                break;
            case R.id.counterButton:
                countBut.setText("Under Contruction");
                break;
            case R.id.stpWatchButton:
                stpwatchBut.setText("Under Contruction");
                break;
        }

        if (i!=null){
            startActivity(i);

        }else {

            Log.d("MainPage", "No intent");
            //Toast.makeText(MainActivity.this, "No intent", Toast.LENGTH_LONG);
        }



    }
}
