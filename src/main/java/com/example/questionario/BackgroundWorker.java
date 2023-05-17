package com.example.questionario;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



public class BackgroundWorker extends AsyncTask <String,Void,String> {
    Context context;
    AlertDialog alertDialog;

    public BackgroundWorker (Context ctx){
        context=ctx;
    }
    @Override
    protected String doInBackground(String... voids) {
        //url locale script php
        String login_url = "http://10.0.2.2/app/login.php";
            try {
                //estrazione altri dati dall'array
                String username = voids[0];
                String password = voids[1];
                URL url = new URL(login_url);
                //apertura connessione http
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //settaggio delle impostazioni di connessione
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                //creazione della richiesta salvata nella varibaile "data"
                String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                //invio dei dati allo script php salvato sul server
                bufferedWriter.write(data);
                //chiusura dei canali di comunicazione di output
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                //creazione buffer di lettura
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                //lettura dell'output fornito dal server
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                //chiusura dei canali di comunicazione di input
                bufferedReader.close();
                inputStream.close();
                //chiusura della connessione http
                httpURLConnection.disconnect();
                return result;
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
        alertDialog.setTitle("Login status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Login riuscito")){
            alertDialog.setMessage(result);
            alertDialog.show();
            Intent intent=new Intent(context,azienda.class);
            context.startActivity(intent);
        }else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
