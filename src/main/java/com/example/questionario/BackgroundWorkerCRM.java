package com.example.questionario;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroundWorkerCRM extends AsyncTask<Void,Void,String[]> {
    Activity activity;
    Context context;
    AlertDialog alertDialog;

    public BackgroundWorkerCRM (Activity act, Context ctx){
        context=ctx;
        activity=act;
    }
    @Override
    protected String[] doInBackground(Void... voids) {
        //url locale script php
        String select_url = "http://10.0.2.2/app/crm.php";
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
    }

    @Override
    protected void onPostExecute(String[] result) {
        if (result[0].equals("Nessun dipendente trovato")){
            alertDialog.setMessage(result[0]);
            alertDialog.show();
        }else{
            LinearLayout linearLayout= activity.findViewById(R.id.crmlayout);
            if(result[0].equals("1")){
                TextView textView1= new TextView(context);
                textView1.setText(context.getString(R.string.r1));
                textView1.setTextColor(Color.WHITE);
                textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView1.setLayoutParams(params);
                linearLayout.addView(textView1);
            }
            if(result[1].equals("1")){
                TextView textView2= new TextView(context);
                textView2.setText(context.getString(R.string.r2));
                textView2.setTextColor(Color.WHITE);
                textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView2.setLayoutParams(params);
                linearLayout.addView(textView2);
            }
            if(result[2].equals("1")){
                TextView textView3= new TextView(context);
                textView3.setText(context.getString(R.string.r3));
                textView3.setTextColor(Color.WHITE);
                textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView3.setLayoutParams(params);
                linearLayout.addView(textView3);
            }
            if(result[3].equals("1")){
                TextView textView4= new TextView(context);
                textView4.setText(context.getString(R.string.r4));
                textView4.setTextColor(Color.WHITE);
                textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView4.setLayoutParams(params);
                linearLayout.addView(textView4);
            }
            if(result[4].equals("1")){
                TextView textView5= new TextView(context);
                textView5.setText(context.getString(R.string.r5));
                textView5.setTextColor(Color.WHITE);
                textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView5.setLayoutParams(params);
                linearLayout.addView(textView5);
            }
            if(result[5].equals("1")){
                TextView textView6= new TextView(context);
                textView6.setText(context.getString(R.string.r6));
                textView6.setTextColor(Color.WHITE);
                textView6.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView6.setLayoutParams(params);
                linearLayout.addView(textView6);
            }
            if(result[6].equals("1")){
                TextView textView7= new TextView(context);
                textView7.setText(context.getString(R.string.r7));
                textView7.setTextColor(Color.WHITE);
                textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView7.setLayoutParams(params);
                linearLayout.addView(textView7);
            }
            if(result[7].equals("1")){
                TextView textView8= new TextView(context);
                textView8.setText(context.getString(R.string.r8));
                textView8.setTextColor(Color.WHITE);
                textView8.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView8.setLayoutParams(params);
                linearLayout.addView(textView8);
            }
            if(result[8].equals("1")){
                TextView textView9= new TextView(context);
                textView9.setText(context.getString(R.string.r9));
                textView9.setTextColor(Color.WHITE);
                textView9.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView9.setLayoutParams(params);
                linearLayout.addView(textView9);
            }
            if(result[9].equals("1")){
                TextView textView10= new TextView(context);
                textView10.setText(context.getString(R.string.r10));
                textView10.setTextColor(Color.WHITE);
                textView10.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                textView10.setLayoutParams(params);
                linearLayout.addView(textView10);
            }
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
