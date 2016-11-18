package com.example.quickcoding_pedometer;

import android.support.v7.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SensorManager sm;
    Sensor sensor_accelerometer;
    Sensor sensor_gyroscope;
    Sensor sensor_gravity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensor_gravity =sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }
}
