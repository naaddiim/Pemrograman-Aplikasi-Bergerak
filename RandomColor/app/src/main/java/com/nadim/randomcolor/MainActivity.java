package com.nadim.randomcolor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] colorNameArray = {"Red", "Pink", "Purple", "Deep Purple", "Indigo", "Blue", "Light_Blue",
            "Cyan", "Teal", "Green", "Light_Green", "Lime", "Yellow", "Amber", "Orange", "Deep_Orange", "Brown", "Grey", "Blue_Grey", "black"};

    private String[] textNameArray = {"master", "super", "grandmaster", "overpower", "champion", "Sholeh", "badut"};

    private TextView tvRandomText;
    private Button btnChangeColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRandomText = findViewById(R.id.tvRandomText);
        btnChangeColor = findViewById(R.id.btnChangeColor);

        if(savedInstanceState != null) {
            tvRandomText.setText(savedInstanceState.getString("text"));
            tvRandomText.setTextColor(savedInstanceState.getInt("color"));
        }

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                String colorName = colorNameArray[random.nextInt(20)];
                String textName = textNameArray[random.nextInt(7)];

                int colorResourceName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
                int colorResource = ContextCompat.getColor(MainActivity.this, colorResourceName);

                tvRandomText.setTextColor(colorResource);
                tvRandomText.setText(textName);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color", tvRandomText.getCurrentTextColor());
        outState.putString("text", tvRandomText.getText().toString());
    }


}