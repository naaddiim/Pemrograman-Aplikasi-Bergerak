package NadimIF4A.example.pertemuan7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivIndomie;
    private TextView tvLike;
    private Button btnLike, btnDislike, btnMap, btnShare;
    private int likeIndomie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //shift+f6 untuk mengganti semua kata yang sama
        //ctrl+d diujung line untuk menduplikat 1 line tanpat harus di blok
        ivIndomie = findViewById(R.id.ivIndomie);
        tvLike = findViewById(R.id.tvLike);
        btnLike = findViewById(R.id.btnLike);
        btnDislike = findViewById(R.id.btnDislike);
        btnMap = findViewById(R.id.btnMap);
        btnShare = findViewById(R.id.btnShare);

        //memanggil hasil saved state information
        if(savedInstanceState  != null) {
            likeIndomie = savedInstanceState.getInt("totalLikesIndomie");
            tvLike.setText(String.valueOf(likeIndomie) + " Likes");
        }

        ivIndomie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , DetailActivity.class);
                intent.putExtra("FOOD_NAME", "Teriyaki Chicken Casserole");
                intent.putExtra("THUMBNAIL", R.drawable.indomie);
                intent.putExtra("RATE", "9.8");
                intent.putExtra("VOTE", likeIndomie);
                intent.putExtra("RELEASE_DATE", "31 Maret 2022");
                intent.putExtra("OVERVIEW", "Indomie Goreng 2x Sehari");
                startActivity(intent);
            }
        });



        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeIndomie += 1;
                tvLike.setText(String.valueOf(likeIndomie) + " Likes");
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeIndomie -= 1;
                tvLike.setText(String.valueOf(likeIndomie) + " Likes");
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uriMap = Uri.parse("geo:0,0:q=-2.949654, 104.770237");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uriMap);
                    intent.setPackage("com.google.android.apps.maps"); // cek di device file explorer data/data
                    startActivity(intent);
                }
                catch (ActivityNotFoundException ex) {
                    Uri uriMap = Uri.parse("geo:0,0:q=-2.949654, 104.770237");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uriMap);
                    startActivity(intent);
                }

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uriData = Uri.parse("whatsapp://send?text=Indomie Kari Ayam");
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    //kalau pakai Intent.ACTION_SEND
                    //sendIntent.setType("text/plain"); // maka akan terkirim dalam bentuk text
                    //sendIntent.putExtra(Intent.EXTRA_TEXT, "Indomie Kari Ayam");
                    sendIntent.setPackage("com.whatsapp");
                    sendIntent.setData(uriData);
                    startActivity(sendIntent);

                }
                catch (ActivityNotFoundException ex) {
                    Uri uriData = Uri.parse("https://api.whatsapp.com/send?phone=+62895605364055&text=Indomie Kari Ayam");
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(uriData);
                    startActivity(sendIntent);
                }
            }
        });
    }

    //untuk save state information sebelum shutdown activity
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("totalLikesIndomie", likeIndomie); //key tidak boleh ada spasi
    }
}