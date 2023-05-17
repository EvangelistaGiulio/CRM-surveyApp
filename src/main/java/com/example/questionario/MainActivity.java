package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatEditText et_nome, et_cognome, et_indirizzo, et_citta, et_cod_fisc;
    RadioButton rad_m, rad_f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nome= (AppCompatEditText) findViewById(R.id.et_nome);
        et_cognome= (AppCompatEditText) findViewById(R.id.et_cognome);
        et_indirizzo= (AppCompatEditText) findViewById(R.id.et_indirizzo);
        et_citta= (AppCompatEditText) findViewById(R.id.et_citta);
        et_cod_fisc= (AppCompatEditText) findViewById(R.id.et_cod_fisc);
        rad_m= (RadioButton) findViewById(R.id.rad_m);
        rad_f=(RadioButton) findViewById(R.id.rad_f);
    }

    public void toQuestAct(View v){
        if(et_nome.getText().toString().isEmpty() || et_cognome.getText().toString().isEmpty() || et_indirizzo.getText().toString().isEmpty()
                || et_citta.getText().toString().isEmpty() || et_cod_fisc.getText().toString().isEmpty() || !rad_m.isChecked() && !rad_f.isChecked()){
            Toast.makeText(this,"Riempire gli spazi obbligatori", Toast.LENGTH_SHORT).show();
        }else{
            String nome=et_nome.getText().toString();
            String cognome=et_cognome.getText().toString();
            String indirizzo=et_indirizzo.getText().toString();
            String citta=et_citta.getText().toString();
            String cod_fisc=et_cod_fisc.getText().toString();
            String sesso="";
            if(rad_m.isChecked()){
                sesso="M";
            }else{
                sesso="F";
            }
            BackgroundWorkerReg backgroundWorkerReg=new BackgroundWorkerReg(this);
            backgroundWorkerReg.execute(nome,cognome,indirizzo,citta,cod_fisc,sesso);
        }
    }

    public void toLoginAct(View v){
        Intent intent=new Intent(this, login.class);
        startActivity(intent);

    }
}