package com.example.quickcoding2;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Toast toast;
    int a=60;
    int s=0;
    int b=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }public void onClick(View view){

        if (view.getId()==R.id.but1)
        {
            toast.setText("50인가??");
            toast.show();
        }

        else if (view.getId()==R.id.sbt1)
        {
            b=a;
            a=(b-s)/2+a;
            toast.setText(a+" 보다 크다!");
            toast.show();
        }
        else if(view.getId()==R.id.sbt2)
        {
            a=a-(a-s)/2;
            toast.setText(a+" 보다 작다!");
            toast.show();
        }
        else{
            toast.setText(a+" 가 맞구만 빙고!!!!");
            toast.show();
        }
    }
}
