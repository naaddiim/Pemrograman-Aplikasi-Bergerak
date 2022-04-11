package com.nadim.hitungluas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etPanjang, etLebar;
    private Button btnHitungLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        btnHitungLuas = findViewById(R.id.btnHitungLuas);

        btnHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strPanjang = etPanjang.getText().toString();
                String strLebar = etLebar.getText().toString();

                if(TextUtils.isEmpty(strPanjang) || TextUtils.isEmpty(strLebar)) {
                    Toast.makeText(MainActivity.this, "Panjang dan Lebar harus diisi!", Toast.LENGTH_SHORT).show();
                }
                else {
                    float panjang = Float.parseFloat(strPanjang);
                    float lebar = Float.parseFloat(strLebar);

                    float luas = panjang * lebar;

                    Toast.makeText(MainActivity.this, "Luas Persegi Panjang : "+ String.format("%.2f", luas), Toast.LENGTH_SHORT).show();

                }

                }
        });
    }
}