package com.nadim.userinteractionwithdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText etNama, etAlamat, etTelepon, etEmail, etPassword;
    public RadioGroup rgJenisKelamin;
    public Spinner spinJurusan;
    public Button btnDaftar, btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etTelepon = findViewById(R.id.etTelepon);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        rgJenisKelamin = findViewById(R.id.rgJenisKelamin);
        spinJurusan = findViewById(R.id.spinJurusan);

        btnDaftar = findViewById(R.id.btnDaftar);
        btnDialog = findViewById(R.id.btnDialog);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Ini Pesan Toast", Toast.LENGTH_SHORT).show();
                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();
                String telepon = etTelepon.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                RadioButton selectedRadioButton = findViewById(rgJenisKelamin.getCheckedRadioButtonId());
                String jenisKelamin = selectedRadioButton.getText().toString();

                String jurusan = spinJurusan.getSelectedItem().toString();

                boolean daftar = true;

                if(TextUtils.isEmpty(nama)) {
                    etNama.setError("Nama Tidak boleh kosong");
                    daftar = false;
                }
                if(TextUtils.isEmpty(alamat)) {
                    etAlamat.setError("Alamat Tidak boleh kosong");
                    daftar = false;
                }
                if(TextUtils.isEmpty(telepon)) {
                    etTelepon.setError("Telepon Tidak boleh kosong");
                    daftar = false;
                }
                if(TextUtils.isEmpty(email)) {
                    etEmail.setError("Email Tidak boleh kosong");
                    daftar = false;
                }
                if(TextUtils.isEmpty(password)) {
                    etPassword.setError("Password Tidak boleh kosong");
                    daftar = false;
                }

                if(daftar) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("jenisKelamin", jenisKelamin);
                    intent.putExtra("alamat", alamat);
                    intent.putExtra("telepon", telepon);
                    intent.putExtra("email", email);
                    intent.putExtra("jurusan", jurusan);
                    startActivity(intent);

                }



            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Contoh Dialog");
                builder.setMessage("Ini adalah contoh dialog");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Anda Menekan tombol Ya!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}