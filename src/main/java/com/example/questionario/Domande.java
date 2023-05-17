package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Domande extends AppCompatActivity {
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    Integer d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domande);
        r1= (RadioButton) findViewById(R.id.btn1_1);
        r2= (RadioButton) findViewById(R.id.btn2_1);
        r3= (RadioButton) findViewById(R.id.btn3_1);
        r4= (RadioButton) findViewById(R.id.btn4_1);
        r5= (RadioButton) findViewById(R.id.btn5_1);
        r6= (RadioButton) findViewById(R.id.btn6_1);
        r7= (RadioButton) findViewById(R.id.btn7_1);
        r8= (RadioButton) findViewById(R.id.btn8_1);
        r9= (RadioButton) findViewById(R.id.btn9_1);
        r10= (RadioButton) findViewById(R.id.btn10_1);
    }

    public void restart(View v){
        this.recreate();
    }

    public void result(View v){
            if(r1.isChecked()){
                d1=1;
            }else{
                d1=0;
            }
            if(r2.isChecked()){
                d2=1;
            }else {
                d2=0;
            }
            if(r3.isChecked()){
                d3=1;
            }else {
                d3=0;
            }
            if(r4.isChecked()){
                d4=1;
            }else {
                d4=0;
            }
            if(r5.isChecked()){
                d5=1;
            }else {
                d5=0;
            }
        if(r6.isChecked()){
            d6=1;
        }else {
            d6=0;
        }
        if(r7.isChecked()){
            d7=1;
        }else {
            d7=0;
        }
        if(r8.isChecked()){
            d8=1;
        }else {
            d8=0;
        }
        if(r9.isChecked()){
            d9=1;
        }else {
            d9=0;
        }
        if(r10.isChecked()){
            d10=1;
        }else {
            d10=0;
        }
        BackgroundWorkerQuest backgroundWorkerQuest= new BackgroundWorkerQuest(this);
        backgroundWorkerQuest.execute(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10);

    }
}