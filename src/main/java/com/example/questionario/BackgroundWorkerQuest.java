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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorkerQuest extends AsyncTask <Integer,Void,String> {
    Context context;
    AlertDialog alertDialog;

    public BackgroundWorkerQuest (Context ctx){
        context=ctx;
    }
    @Override
    protected String doInBackground(Integer... voids) {
        //url locale script php
        String register_url = "http://10.0.2.2/app/quest.php";
        try {
            //estrazione dati cliente dall'array
            Integer d1 = voids[0];
            Integer d2 = voids[1];
            Integer d3 = voids[2];
            Integer d4 = voids[3];
            Integer d5 = voids[4];
            Integer d6 = voids[5];
            Integer d7 = voids[6];
            Integer d8 = voids[7];
            Integer d9 = voids[8];
            Integer d10 = voids[9];
            URL url = new URL(register_url);
            //apertura connessione http
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //settaggio delle impostazioni di connessione
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            //creazione della richiesta salvata nella varibaile "data"
            String data = URLEncoder.encode("d1", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d1), "UTF-8") + "&"
                    + URLEncoder.encode("d2", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d2), "UTF-8") + "&"
                    + URLEncoder.encode("d3", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d3), "UTF-8") + "&"
                    + URLEncoder.encode("d4", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d4), "UTF-8") + "&"
                    + URLEncoder.encode("d5", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d5), "UTF-8") + "&"
                    + URLEncoder.encode("d6", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d6), "UTF-8")+ "&"
                    + URLEncoder.encode("d7", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d7), "UTF-8")+ "&"
                    + URLEncoder.encode("d8", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d8), "UTF-8")+ "&"
                    + URLEncoder.encode("d9", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d9), "UTF-8")+ "&"
                    + URLEncoder.encode("d10", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(d10), "UTF-8");
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
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
        alertDialog.setTitle("Registration status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Registrazione riuscita")){
            alertDialog.setMessage(result);
            alertDialog.show();
            Intent intent = new Intent(context, result.class);
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
