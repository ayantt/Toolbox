package com.example.intern.toolbox;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CompassActivity extends AppCompatActivity implements SensorEventListener{

    ImageView arrow;
    TextView dgr;
    float currentDegree;

    private static SensorManager sensorService;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        arrow = findViewById(R.id.arrow);
        dgr = findViewById(R.id.dgr);

        sensorService = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorService.getDefaultSensor(Sensor.TYPE_ORIENTATION);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensor!=null){
            sensorService.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
        }else {
            Toast.makeText(CompassActivity.this, "Not Supported", Toast.LENGTH_LONG);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorService.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float degree = Float.parseFloat(new DecimalFormat("#0.0").format(sensorEvent.values[0]));

        if (degree==0.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " N");
        }else if(degree>10.0&&degree<=80.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " EN");
        }else if (degree>80.0&&degree<=100.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " E");
        }else if(degree>100.0&&degree<=170.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " SE");
        }else if(degree>170.0&&degree<=190.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " S");
        }else if (degree>190.0&&degree<=260.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " WS");
        }else if (degree>260.0&&degree<=280.0){
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " W");
        }else if (degree>280.0&&degree<360.0)
            dgr.setText(Float.toString(degree) + (char) 0x00B0 + " NW");

//        dgr.setText(Float.toString(degree) + (char) 0x00B0);

        RotateAnimation roAni = new RotateAnimation(currentDegree, degree,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);

        roAni.setDuration(1000);
        roAni.setFillAfter(true);

        arrow.setAnimation(roAni);
        currentDegree = degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
