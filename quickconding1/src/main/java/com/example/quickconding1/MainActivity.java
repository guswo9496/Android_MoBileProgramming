package com.example.quickconding1;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    public int[] a={1,2,3,4,5,6,7,8,9,10};
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.re1);
    } public class GetAverage {
        int av = 0;
        public int Average(int[] a) {
            for (int i = 0; i < a.length; i++)
                av += a[i];
            return av / a.length;
        }
    }
    public class GetMinimum{
        public int Minimum(int[] a) {
            Arrays.sort(a);
            return a[0];
        }
    }

    public void onClick(View view){
        if (view.getId()==R.id.button1){
            textview.setText(String.valueOf(new GetAverage().Average(a)));

        }else {
            textview.setText(String.valueOf(new GetMinimum().Minimum(a)));
        }

    }
}
