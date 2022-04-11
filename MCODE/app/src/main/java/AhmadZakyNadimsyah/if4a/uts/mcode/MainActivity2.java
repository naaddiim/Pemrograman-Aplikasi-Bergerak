package AhmadZakyNadimsyah.if4a.uts.mcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity {

    TextView tvNama2, tvDate2, tvKode2;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //buat navigation up ke parent
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String nama = getIntent().getExtras().getString("nama");
        String tanggalLahir = getIntent().getExtras().getString("tanggalLahir");
        String kode = getIntent().getExtras().getString("kode");


        tvNama2 = findViewById(R.id.tvNama2);
        tvDate2 = findViewById(R.id.tvDate2);
        tvKode2 = findViewById(R.id.tvKode2);
        btnShare = findViewById(R.id.btnShare);



        tvNama2.setText(nama);
        tvDate2.setText(tanggalLahir);
        tvKode2.setText(kode);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "MCode #"+kode+"from "+nama+tanggalLahir);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, "Share this text to ...");
                startActivity(shareIntent);
            }
        });






    }
}