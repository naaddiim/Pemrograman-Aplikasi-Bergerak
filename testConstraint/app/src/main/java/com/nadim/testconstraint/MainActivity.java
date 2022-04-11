package com.nadim.testconstraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvAngka;
    private Button btnPlus10, btnMinus5, btnMinus10, btnMinus15, btnMinus20, btnPlus20, btnPlus40;
    private int angka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAngka = findViewById(R.id.tvAngka);
        btnPlus10 = findViewById(R.id.btnPlus10);
        btnMinus5 = findViewById(R.id.btnMinus5);
        btnMinus10 = findViewById(R.id.btnMinus10);
        btnMinus15 = findViewById(R.id.btnMinus15);
        btnMinus20 = findViewById(R.id.btnMinus20);
        btnPlus20 = findViewById(R.id.btnPlus20);
        btnPlus40 = findViewById(R.id.btnPlus40);

        if(savedInstanceState != null) {
            angka = savedInstanceState.getInt("totalAngka");
            tvAngka.setText(String.valueOf(angka));
        }

        btnPlus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka += 10;
                tvAngka.setText(String.valueOf(angka));
            }
        });
        btnMinus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka -= 5;
                tvAngka.setText(String.valueOf(angka));
            }
        });
        btnMinus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka -= 10;
                tvAngka.setText(String.valueOf(angka));
            }
        });
        btnMinus15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka -= 15;
                tvAngka.setText(String.valueOf(angka));
            }
        });
        btnMinus20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka -= 10;
                tvAngka.setText(String.valueOf(angka));
            }
        });
        btnPlus20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka += 20;
                tvAngka.setText(String.valueOf(angka));
            }
        });
        btnPlus40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka += 40;
                tvAngka.setText(String.valueOf(angka));
            }
        });


    }
    //untuk save state information sebelum shutdown activity
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("totalAngka", angka); //key tidak boleh ada spasi
    }

}