package com.nadim.userinteractionwithdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nama = getIntent().getExtras().getString("nama");
        String jenisKelamin = getIntent().getExtras().getString("jenisKelamin");
        String alamat = getIntent().getExtras().getString("alamat");
        String telepon = getIntent().getExtras().getString("telepon");
        String email = getIntent().getExtras().getString("email");
        String jurusan = getIntent().getExtras().getString("jurusan");

        tvPesan = findViewById(R.id.tvPesan);

        String kalimatPesan = "Selamat Datang, "+ nama +" Anda berjenis kelamin "+ jenisKelamin+" yang tinggal di "+alamat
                +" dengan nomor telepon "+telepon+" dengan email : "+email+" dan jurusan : "+jurusan;

        tvPesan.setText(kalimatPesan);
    }
}