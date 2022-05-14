package com.nadim.asynctaskexample;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements MyAsyncTaskCallBack {

    public static final String TAG = "MyAsyncTask";
    private TextView tvStatus;
    private Button btnStart;
    private ProgressBar progressBar;
    private MyAsyncTask myAsyncTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myAsyncTask != null) {
                    AsyncTask.Status status = myAsyncTask.getStatus();

                    switch (status) {
                        case PENDING:
                            myAsyncTask.execute();
                            break;
                        case RUNNING:
                            Toast.makeText(MainActivity.this, "Async Task masih berjalan", Toast.LENGTH_SHORT).show();
                            break;
                        case FINISHED:
                            myAsyncTask = new MyAsyncTask(MainActivity.this);
                            myAsyncTask.execute();
                            break;
                    }
                }
                else {
                    myAsyncTask = new MyAsyncTask(MainActivity.this);
                    myAsyncTask.execute();
                }
            }
        });
    }

    @Override
    public void onPreExecute() {
        progressBar.setProgress(0);
        tvStatus.setText("Progress : "+ 0 + "%");
    }

    @Override
    public void onUpdateProgress(long value) {
        final Double MAX_PROGRESS = 10000.0;

        double progress = 100 * (value/ MAX_PROGRESS);

        tvStatus.setText("Progress : "+ String.valueOf((int) progress)+ "%");

        progressBar.setProgress((int) progress);

    }

    @Override
    public void onPostExecute(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private static class MyAsyncTask extends AsyncTask<Void, Long, Void> {

        WeakReference<MyAsyncTaskCallBack> myAsyncTaskCallBackWeakReference;

        public MyAsyncTask(MyAsyncTaskCallBack myAsyncTaskCallBack) {
            this.myAsyncTaskCallBackWeakReference = new WeakReference<>(myAsyncTaskCallBack);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.myAsyncTaskCallBackWeakReference.get().onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            long delayTime = 2000;
            long startTime = 0;

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(delayTime);

                    publishProgress(startTime += delayTime);
                }
                catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            long value = values[0];
            this.myAsyncTaskCallBackWeakReference.get().onUpdateProgress(value);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            this.myAsyncTaskCallBackWeakReference.get().onPostExecute("Finish");
        }
    }
}