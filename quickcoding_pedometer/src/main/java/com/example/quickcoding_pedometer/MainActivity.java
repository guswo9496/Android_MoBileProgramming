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

    public static int count=0;
    TextView textView;
    Button button;
    View v;
     long lastTime;
     float speed;
     float lastX;
     float lastY;
     float lastZ;
     float x, y, z;
    
    SensorManager sm;
    Sensor sensor_accelerometer;
    Sensor sensor_gyroscope;
    Sensor sensor_gravity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor_gravity =sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        
        textView =(TextView)findViewById(R.id.text1);
        button =(Button)findViewById(R.id.start);
        textView.setText("worked step: "+count);
    }
    @Override
    public void onStart(){
        super.onStart();
        if (sensor_accelerometer != null)
            sm.registerListener((SensorEventListener) this,sensor_accelerometer,sm.SENSOR_DELAY_GAME);
    }@Override
    public void onStop() {
        super.onStop();
        if (sm != null)
            sm.unregisterListener((SensorEventListener) this);
    }@Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currentTime = System.currentTimeMillis();
            long gabOfTime = (currentTime - lastTime);
            if (gabOfTime > 100) {
                lastTime = currentTime;
                x = event.values[SensorManager.DATA_X];
                y = event.values[SensorManager.DATA_Y];
                z = event.values[SensorManager.DATA_Z];

                speed = Math.abs(x + y + z - lastX - lastY - lastZ) / gabOfTime * 10000;

                if (speed > 800) {
                    textView.setText("You Walked " + (++count) + " Steps!!!");
                }

                lastX = event.values[SensorManager.DATA_X];
                lastY = event.values[SensorManager.DATA_Y];
                lastZ = event.values[SensorManager.DATA_Z];
            }
        }
    }
     public void onClick_Reset (View v) {
        count = 0;
        textView.setText("You Walked " + count + " Steps!!!");
    }
}
