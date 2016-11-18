package com.example.quickcoding_sensor;

import android.hardware.SensorEventCallback;
import android.hardware.SensorEventListener2;
import android.hardware.SensorListener;
import android.support.v7.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity /*implements SensorListener*/ {

    SensorManager sn;
    Sensor sensor_gravity;
    Sensor sensor_accelerometer;
    Sensor sensor_Linear_accelration;
    Sensor sensor_gyroscope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sn = (SensorManager)getSystemService(SENSOR_SERVICE);

        sensor_gravity = sn.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sn.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_Linear_accelration = sn.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_gyroscope = sn.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }
    @Override
    protected void onResume(){
        super.onResume();
        /*sn.registerListener(this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sn.registerListener(this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sn.registerListener(this, sensor_Linear_accelration, SensorManager.SENSOR_DELAY_NORMAL);
        sn.registerListener(this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);*/

    }
   /* @Override
    protected void onPause() {
        super.onPause();

        sn.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(int sensor, float[] values) {

    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event){

    }*/
}
