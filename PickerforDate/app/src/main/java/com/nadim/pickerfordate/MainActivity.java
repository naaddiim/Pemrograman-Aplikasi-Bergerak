package com.nadim.pickerfordate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datePicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String monthString = Integer.toString(month+1);
        //The month integer returned by the date picker starts counting at 0 for January, so you need to add 1 to it to show months starting at 1.
        String dayString = Integer.toString(day);
        String yearString = Integer.toString(year);
        String dateMessage = (dayString + "/" + monthString + "/"  + yearString);

        Toast.makeText(this, getString(R.string.txtDate)+dateMessage ,Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}