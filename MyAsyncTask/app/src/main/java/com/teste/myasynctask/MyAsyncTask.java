package com.teste.myasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Void, Integer, Integer> {

    private TextView textViewST;
    private ProgressBar progressBar;

    public MyAsyncTask(TextView textView, ProgressBar progressBar){
        textViewST = textView;
        this.progressBar = progressBar;
    }

    private int sleepingTime = 50;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textViewST.setText("Loading");
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        for (int i = 0; i <= sleepingTime ; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int progress = i * 2;
            publishProgress(progress);
        }
        return sleepingTime;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        textViewST.setText("Thread dormiu por "+sleepingTime/10+" segundos.");
    }
}