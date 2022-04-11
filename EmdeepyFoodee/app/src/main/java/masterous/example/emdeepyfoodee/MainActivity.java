package masterous.example.emdeepyfoodee;

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

    private TextView tvLikeTeriyaki, tvLikeNoodle;
    private Button btnLikeTeriyaki, btnDislikeTeriyaki;
    private Button btnLikeNoodle, btnDislikeNoodle;
    private Button btnMapTeriyaki;
    private Button btnShareNoodle;
    private ImageView ivTeriyaki, ivNoodle;
    private int likeTeriyaki = 0;
    private int likeNoodle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLikeTeriyaki = findViewById(R.id.tv_vote_teriyaki);
        tvLikeNoodle = findViewById(R.id.tv_vote_noodle);
        btnLikeTeriyaki = findViewById(R.id.btn_like_teriyaki);
        btnLikeNoodle = findViewById(R.id.btn_like_noodle);
        btnDislikeTeriyaki = findViewById(R.id.btn_dislike_teriyaki);
        btnDislikeNoodle = findViewById(R.id.btn_dislike_noodle);
        btnMapTeriyaki = findViewById(R.id.btn_map_teriyaki);
        btnShareNoodle = findViewById(R.id.btn_share_noodle);
        ivTeriyaki = findViewById(R.id.iv_teriyaki);
        ivNoodle = findViewById(R.id.iv_noodle);

        ivTeriyaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("FOOD_NAME", "Teriyaki Chicken Casserole");
                intent.putExtra("THUMBNAIL", R.drawable.teriyaki_chicken_casserole);
                intent.putExtra("RATE", "9.8");
                intent.putExtra("VOTE", "125");
                intent.putExtra("RELEASE_DATE", "31 Maret 2022");
                intent.putExtra("OVERVIEW", "Easy Teriyaki Chicken Casserole is a simple casserole made with the best homemade teriyaki sauce filled with vegetable stir fry, rice and baked to perfection. A savory dish everyone loves! Teriyaki sauce is one of our favorite sauces on chicken. If you love teriyaki chicken try this Sheet Pan Teriyaki Chicken with Vegetables, Sweet Island Teriyaki Chicken or Slow Cooker Teriyaki Chicken. Easy Teriyaki Chicken Casserole is a simple casserole made with the best homemade teriyaki sauce filled with vegetable stir fry, rice and baked to perfection. A savory dish everyone loves! Teriyaki sauce is one of our favorite sauces on chicken. If you love teriyaki chicken try this Sheet Pan Teriyaki Chicken with Vegetables, Sweet Island Teriyaki Chicken or Slow Cooker Teriyaki Chicken. Easy Teriyaki Chicken Casserole is a simple casserole made with the best homemade teriyaki sauce filled with vegetable stir fry, rice and baked to perfection. A savory dish everyone loves! Teriyaki sauce is one of our favorite sauces on chicken. If you love teriyaki chicken try this Sheet Pan Teriyaki Chicken with Vegetables, Sweet Island Teriyaki Chicken or Slow Cooker Teriyaki Chicken.");
                startActivity(intent);
            }
        });

        ivNoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("FOOD_NAME", "Noodle");
                intent.putExtra("THUMBNAIL", R.drawable.noodle);
                intent.putExtra("RATE", "7.2");
                intent.putExtra("VOTE", "96");
                intent.putExtra("RELEASE_DATE", "30 Januari 2022");
                intent.putExtra("OVERVIEW", "Noodles are a type of food made from unleavened dough which is rolled flat and cut, stretched or extruded, into long strips or strings. Noodles can be refrigerated for short-term storage or dried and stored for future use. Noodles are usually cooked in boiling water, sometimes with cooking oil or salt added. They are also often pan-fried or deep-fried. Noodle dishes can include a sauce or noodles can be put into soup. The material composition and geocultural origin is specific to each type of a wide variety of noodles. Noodles are a staple food in many cultures (see Chinese noodles, Japanese noodles, Korean noodles, Filipino noodles, Vietnamese noodles, and Italian pasta).");
                startActivity(intent);
            }
        });

        if (savedInstanceState != null) {
            likeTeriyaki = savedInstanceState.getInt("TOTAL_LIKES_TERIYAKI");
            tvLikeTeriyaki.setText(String.valueOf(likeTeriyaki) + " likes");

            likeNoodle = savedInstanceState.getInt("TOTAL_LIKES_NOODLE");
            tvLikeNoodle.setText(String.valueOf(likeNoodle) + " likes");
        }

        btnLikeTeriyaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeTeriyaki += 1;
                tvLikeTeriyaki.setText(String.valueOf(likeTeriyaki) + " likes");
            }
        });

        btnDislikeTeriyaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeTeriyaki -= 1;
                tvLikeTeriyaki.setText(String.valueOf(likeTeriyaki) + " likes");
            }
        });

        btnMapTeriyaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uriMap = Uri.parse("google.navigation:q=Universitas Multi Data Palembang");
                try {
                    Uri uriMap = Uri.parse("geo:0,0?q=33.880966,-118.141629");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uriMap);
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    Uri uriMap = Uri.parse("https://www.google.com/maps/search/33.880966,-118.141629");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uriMap);
                    startActivity(intent);
                }
            }
        });

        btnLikeNoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeNoodle++;
                tvLikeNoodle.setText(String.valueOf(likeNoodle) + " likes");
            }
        });

        btnDislikeNoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeNoodle--;
                tvLikeNoodle.setText(String.valueOf(likeNoodle) + " likes");
            }
        });

        btnShareNoodle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uriData = Uri.parse("whatsapp://send?text=Noodle&phone=+6282175229832");
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setPackage("com.whatsapp");
                    sendIntent.setData(uriData);
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException ex) {
                    Uri uriData = Uri.parse("https://api.whatsapp.com/send?phone=+6282175229832&text=Noodle");
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(uriData);
                    startActivity(sendIntent);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TOTAL_LIKES_TERIYAKI", likeTeriyaki);
        outState.putInt("TOTAL_LIKES_NOODLE", likeNoodle);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}