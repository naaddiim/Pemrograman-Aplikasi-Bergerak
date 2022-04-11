package AhmadZakyNadimsyah.if4a.uts.mcode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    protected Button btnDate, btnRegister, btnGC;
    protected EditText etNama;
    protected TextView tvDate, tvTampilan;
    protected int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        btnDate = findViewById(R.id.btnDate);
        btnGC = findViewById(R.id.btnGC);
        btnRegister = findViewById(R.id.btnRegister);
        tvTampilan = findViewById(R.id.tvTampilan);
        tvDate = findViewById(R.id.tvDate);


        etNama = findViewById(R.id.etNama);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
                        tvDate.setText(String.format("%02d-%02d-%04d", dayofMonth, month+1, year));
                        mYear = year;
                        mMonth = month;
                        mDay = dayofMonth;
                    }
                    //default
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                btnDate.setPressed(true);
            }
        });

        btnGC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String tanggalLahir = tvDate.getText().toString();
                //Ahmad Zaky Nadimsyah
                String namaInisial1 = TextUtils.substring(nama, 0, 1);
                String namaInisial2 = TextUtils.substring(nama, 6, 7);
                String namaInisial3 = TextUtils.substring(nama, 11, 12);
                //09-11-2001

                String tanggalLahir1 = TextUtils.substring(tanggalLahir, 0, 1);
                String tanggalLahir2 = TextUtils.substring(tanggalLahir, 3, 4);
                String tanggalLahir3 = TextUtils.substring(tanggalLahir, 6, 7);
                String tanggalLahir4 = TextUtils.substring(tanggalLahir, 8, 9);

                int tl1 = Integer.parseInt(tanggalLahir1);
                int tl2 = Integer.parseInt(tanggalLahir2);
                int tl3 = Integer.parseInt(tanggalLahir3);
                int tl4 = Integer.parseInt(tanggalLahir4);

                int tl = tl1+tl2+tl3+tl4;

                String jumlahTanggalLahir = String.valueOf(tl);

                String kode = namaInisial1+namaInisial2+namaInisial3+jumlahTanggalLahir;

                tvTampilan.setText(kode);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String tanggalLahir = tvDate.getText().toString();
                String kode = tvTampilan.getText().toString();

                boolean register = true;


                if(TextUtils.isEmpty(nama)) {
                    etNama.setError("Nama Tidak boleh kosong");
                    register = false;

                }
                if(TextUtils.isEmpty(tanggalLahir)) {
                    Toast.makeText(MainActivity.this, "Silahkan Pilih Tanggal", Toast.LENGTH_SHORT).show();
                    register = false;

                }
                if(TextUtils.isEmpty(kode)) {
                    Toast.makeText(MainActivity.this, "Silahkan Generate Code", Toast.LENGTH_SHORT).show();
                    register = false;

                }

                if(register) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("tanggalLahir", tanggalLahir);
                    intent.putExtra("kode", kode);
                    startActivity(intent);

                }



            }
        });

    }
}