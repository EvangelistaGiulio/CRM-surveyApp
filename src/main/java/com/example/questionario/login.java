package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_pass);
    }

    public void dologin(View v){
        String username=et_username.getText().toString();
        String password=et_password.getText().toString();
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(username,password);
    }
}