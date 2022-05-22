package NadimIF4A.example.pertemuan7.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import NadimIF4A.example.pertemuan7.R;
import NadimIF4A.example.pertemuan7.models.ResponseData;
import NadimIF4A.example.pertemuan7.models.ResponseMeal;
import NadimIF4A.example.pertemuan7.models.food;
import NadimIF4A.example.pertemuan7.services.APIService;
import NadimIF4A.example.pertemuan7.utils.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    //import class food
    private ResponseMeal food;
    private List<ResponseMeal> responseMeals;
    private ChipGroup cgTag;
    private FloatingActionButton fabShare;

    private ImageView ivThumbnail;
    private TextView tvFoodName, tvRating, tvVoting, tvReleaseDate, tvOverview;
    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //ambil parameter ID dari main activity
        String idMeal = getIntent().getExtras().getString(Constant.EXTRA_MEALS_ID);

        ivThumbnail = findViewById(R.id.ivDetail);
        tvFoodName = findViewById(R.id.tvTitle);
        tvRating = findViewById(R.id.tvRating);
        tvVoting = findViewById(R.id.tvVoteCOunt);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvOverview = findViewById(R.id.tvDescription);
        cgTag = findViewById(R.id.cgTag);
        fabShare = findViewById(R.id.fabShare);
        youTubePlayerView = findViewById(R.id.youtubeView);
        getLifecycle().addObserver(youTubePlayerView);

        //panggil fungsi dengan parameter id yang didapat
        getMealsDetail(idMeal);

    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    //buat fungsi dengan parameter id (untuk query search)
    private void getMealsDetail(String idMeal) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                //convert JSON ke model java
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        apiService.getMealDetail(idMeal).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if(response.code() == 200) {
                    responseMeals = response.body().getMeals();

                    Glide.with(getApplicationContext())
                            .load(responseMeals.get(0).getStrMealThumb())
                            .placeholder(R.drawable.ic_broken_image_24)
                            .into(ivThumbnail);

                    tvFoodName.setText(responseMeals.get(0).getStrMeal());
                    tvOverview.setText(responseMeals.get(0).getStrInstruction());

                    tvRating.setText(responseMeals.get(0).getStrCategory());
                    tvVoting.setText(responseMeals.get(0).getStrArea());
                    tvReleaseDate.setText(idMeal);

                    String tags = responseMeals.get(0).getStrTags();
                    if(tags == null) {
                        return;
                    }
                    else {
                        String [] tag = tags.split(",");
                        for(int i = 0; i < tag.length; i++) {
                            Chip chip = new Chip(DetailActivity.this);
                            chip.setText(tag[i]);
                            chip.setChipBackgroundColorResource(R.color.purple_500);
                            chip.setTextColor(getResources().getColor(R.color.white));
                            cgTag.addView(chip);
                        }
                    }

                    youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                        @Override
                        public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                            super.onReady(youTubePlayer);
                            String videoURL = responseMeals.get(0).getStrYoutube();
                            String [] strVideo = videoURL.split("v=");
                            String videoId = strVideo[1];
                            youTubePlayer.cueVideo(videoId, 0);
                        }
                    });

                    fabShare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_SEND);
                            intent.putExtra(Intent.EXTRA_TEXT, Constant.THEMEAL_SITE_URL+ responseMeals.get(0).getIdMeal());
                            intent.setType("text/plain");
                            Intent shareIntent = Intent.createChooser(intent, "Share text this with");
                            startActivity(shareIntent);

                        }
                    });

                    Toast.makeText(DetailActivity.this, "Response Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DetailActivity.this, "Response code : "+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(DetailActivity.this, "Rerofit Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
            });
    }
}