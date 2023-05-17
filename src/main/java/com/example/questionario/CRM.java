package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class CRM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crm);
        BackgroundWorkerCRM backgroundWorkerCRM=new BackgroundWorkerCRM(this,this);
        backgroundWorkerCRM.execute();
    }
}