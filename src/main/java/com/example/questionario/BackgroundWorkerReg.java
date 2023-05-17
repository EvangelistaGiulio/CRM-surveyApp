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



public class BackgroundWorkerReg extends AsyncTask <String,Void,String> {
    Context context;
    AlertDialog alertDialog;

    public BackgroundWorkerReg (Context ctx){
        context=ctx;
    }
    @Override
    protected String doInBackground(String... voids) {
        //url locale script php
        String register_url = "http://10.0.2.2/app/register.php";
        try {
            //estrazione dati cliente dall'array
            String nome = voids[0];
            String cognome = voids[1];
            String indirizzo = voids[2];
            String citta = voids[3];
            String cod_fisc = voids[4];
            String sesso = voids[5];
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
            String data = URLEncoder.encode("nome", "UTF-8") + "=" + URLEncoder.encode(nome, "UTF-8") + "&"
                    + URLEncoder.encode("cognome", "UTF-8") + "=" + URLEncoder.encode(cognome, "UTF-8") + "&"
                    + URLEncoder.encode("indirizzo", "UTF-8") + "=" + URLEncoder.encode(indirizzo, "UTF-8") + "&"
                    + URLEncoder.encode("citta", "UTF-8") + "=" + URLEncoder.encode(citta, "UTF-8") + "&"
                    + URLEncoder.encode("cod_fisc", "UTF-8") + "=" + URLEncoder.encode(cod_fisc, "UTF-8") + "&"
                    + URLEncoder.encode("sesso", "UTF-8") + "=" + URLEncoder.encode(sesso, "UTF-8");
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
            Intent intent = new Intent(context, Domande.class);
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
