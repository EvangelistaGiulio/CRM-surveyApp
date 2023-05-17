package com.example.questionario;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorkerSel extends AsyncTask <TextView,Void,String[]> {
    Context context;
    AlertDialog alertDialog;
    TextView tv_stip,tv_eta;

    public BackgroundWorkerSel (Context ctx){
        context=ctx;
    }
    @Override
    protected String[] doInBackground(TextView... voids) {
        tv_stip=voids[0];
        tv_eta=voids[1];
        //url locale script php
        String select_url = "http://10.0.2.2/app/select.php";
            try {
                URL url = new URL(select_url);
                //apertura connessione http
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //settaggio delle impostazioni di connessione
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                //creazione buffer di lettura
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                //lettura dell'output fornito dal server
                while ((line = bufferedReader.readLine()) != null) {
                    result+= line;
                }
                String[] array=result.split(",");
                //chiusura dei canali di comunicazione di input
                bufferedReader.close();
                inputStream.close();
                //chiusura della connessione http
                httpURLConnection.disconnect();
                return array;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Select status");
    }

    @Override
    protected void onPostExecute(String[] result) {
        if (result[0].equals("Nessun dipendente trovato")){
            alertDialog.setMessage(result[0]);
            alertDialog.show();
        }else{
            tv_stip.setText(result[0]);
            tv_eta.setText(result[1]);
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
