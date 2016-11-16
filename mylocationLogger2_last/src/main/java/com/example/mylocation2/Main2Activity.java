package com.example.mylocation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mylocation2.Location.MyLocation;

import static com.example.mylocation2.R.id.lat;

public class Main2Activity extends AppCompatActivity {
  TextView textView;
  EditText categroy;
  EditText title;
  EditText content;
  String categoryStr;
  String titleStr;
  String contentStr;
  Button opbtn;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    categroy = (EditText)findViewById(R.id.category);
    title = (EditText)findViewById(R.id.title);
    content = (EditText)findViewById(R.id.content);
    Intent intent = getIntent();
    Button savebutton = (Button)findViewById(R.id.save);
    MyLocation myLocation = (MyLocation)intent.getSerializableExtra("MyLocation");

    categoryStr = myLocation.category;
    titleStr = myLocation.title;
    contentStr = myLocation.content;
    categroy.setText(categoryStr);
    title.setText(titleStr);
    content.setText(contentStr);



   final Gen<String,Integer> generic = new Gen<>();

    savebutton.setOnClickListener(
            new View.OnClickListener(){
              public void onClick(View view){

                String Ca = categroy.getText().toString();
                String Ti = title.getText().toString();
                String Co = content.getText().toString();
                try{
                    int intvar =Integer.parseInt(Ca);
                    generic.ca.add(Ca);
                    generic.tm.add(intvar);
                }catch (Exception e){
                  generic.co.add(Co);
                  generic.ti.add(Ti);
                }
              }

            }
    );

    textView =(TextView)findViewById(lat);
    opbtn = (Button)findViewById(R.id.op);
    opbtn.setOnClickListener(
            new View.OnClickListener(){
              public void onClick(View v){
                lat.setText("입력된 분류 : "+generic.ca);
                lat.setText("입력된 숫자 : "+generic.tm);
                lat.setText("입력된 타이틀 : "+generic.ti);
                lat.setText("입력된 내용 : "+generic.co);
              }
            }
    );
  }
}
