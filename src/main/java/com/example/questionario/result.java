package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class result extends AppCompatActivity {
    Button btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btn_home=findViewById(R.id.btn_home);
    }

    public void toHomee(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}