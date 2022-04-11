package com.nadim.plusminus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumber;
    private Button btnUp, btnDown, btnReset;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = findViewById(R.id.tvNumber);
        btnUp = findViewById(R.id.btnUp);
        btnReset = findViewById(R.id.btnReset);
        btnDown = findViewById(R.id.btnDown);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number += 1;

                tvNumber.setText(String.valueOf(number));

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = 0;
                tvNumber.setText(String.valueOf(number));
            }
        });

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number -= 1;
                tvNumber.setText(String.valueOf(number));
            }
        });
    }
}