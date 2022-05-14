package com.nadim.asynctaskexample;

public interface MyAsyncTaskCallBack {
    void onPreExecute ();
    void onUpdateProgress (long value);
    void onPostExecute (String text);

}
