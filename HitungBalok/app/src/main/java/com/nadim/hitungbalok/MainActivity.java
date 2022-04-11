package com.nadim.hitungbalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etPanjang, etLebar, etTinggi;
    private RadioGroup rgBalok;
    private Button btnHitung, btnReset;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        etTinggi = findViewById(R.id.etTinggi);
        rgBalok = findViewById(R.id.rgBalok);
        btnHitung = findViewById(R.id.btnHitung);
        btnReset = findViewById(R.id.btnReset);
        tvHasil = findViewById(R.id.tvHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPanjang = etPanjang.getText().toString();
                String strLebar = etLebar.getText().toString();
                String strTinggi = etTinggi.getText().toString();

                if(TextUtils.isEmpty(strPanjang)) {
                    etPanjang.setError("Panjang balok belum diisi");
                    return;
                }
                if(TextUtils.isEmpty(strLebar)) {
                    etPanjang.setError("Lebar balok belum diisi");
                    return;
                }
                if(TextUtils.isEmpty(strTinggi)) {
                    etPanjang.setError("Tinggi balok belum diisi");
                    return;
                }

                float panjang = Float.parseFloat(strPanjang);
                float lebar = Float.parseFloat(strLebar);
                float tinggi = Float.parseFloat(strTinggi);

                float formulaBalok;


                RadioButton radioButton = findViewById(rgBalok.getCheckedRadioButtonId());
                if (radioButton.getText().toString().equalsIgnoreCase( "Luas")){
                    formulaBalok = 2*(panjang*lebar + lebar*tinggi + panjang*tinggi);
                    tvHasil.setText(String.format("Luas Balok : %.2f", formulaBalok));

                }
                else {
                    formulaBalok = panjang * lebar * tinggi;
                    tvHasil.setText(String.format("Luas Balok : %.2f", formulaBalok));
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPanjang.setText("");
                etLebar.setText("");
                etTinggi.setText("");
                tvHasil.setText("");
            }
        });

    }
}