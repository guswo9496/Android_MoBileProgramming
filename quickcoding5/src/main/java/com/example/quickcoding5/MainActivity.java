package com.example.quickcoding5;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import org.w3c.dom.Text;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Array<Integer,String> array =new Array<>();

        final Button input = (Button) findViewById(R.id.input1);
        final Button output = (Button) findViewById(R.id.output1);
        final Button reset = (Button) findViewById(R.id.reset);

        final EditText editText = (EditText) findViewById(R.id.Ed1);

        final TextView inttext = (TextView) findViewById(R.id.re1);
        final TextView strtext = (TextView) findViewById(R.id.re2);

        input.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        String string = input.getText().toString();
                        try{
                            Integer intvar = Integer.parseInt(string);
                            array.arr_integer.add(intvar);
                        }catch (Exception e){
                            array.arr_string.add(string);
                        }
                        editText.setText("");
                    }
                }
        );
        output.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        inttext.setText(" "+array.arr_integer);
                        strtext.setText(" "+array.arr_string);

                    }
                }
        );
        reset.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        array.arr_integer.clear();
                        array.arr_string.clear();
                        strtext.setText(" "+array.arr_string);
                        inttext.setText(" "+array.arr_integer);
                    }
                }
        );
    }
}
