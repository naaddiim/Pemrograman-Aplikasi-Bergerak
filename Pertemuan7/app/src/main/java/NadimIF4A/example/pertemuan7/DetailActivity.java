package NadimIF4A.example.pertemuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String foodName, rating, overview, releaseDate;
    private Integer voting;
    private int thumbnail;

    private ImageView ivThumbnail;
    private TextView tvFoodName, tvRating, tvVoting, tvReleaseDate, tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        foodName = getIntent().getExtras().getString("FOOD_NAME");
        thumbnail = getIntent().getExtras().getInt("THUMBNAIL");
        rating = getIntent().getExtras().getString("RATE");
        voting = getIntent().getExtras().getInt("VOTE");
        releaseDate = getIntent().getExtras().getString("RELEASE_DATE");
        overview = getIntent().getExtras().getString("OVERVIEW");

        ivThumbnail = findViewById(R.id.ivDetail);
        tvFoodName = findViewById(R.id.tvTitle);
        tvRating = findViewById(R.id.tvRating);
        tvVoting = findViewById(R.id.tvVoteCOunt);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvOverview = findViewById(R.id.tvDescription);

        ivThumbnail.setImageResource(thumbnail);
        tvFoodName.setText(foodName);
        tvRating.setText(rating);
        tvVoting.setText(String.valueOf(voting));
        tvReleaseDate.setText(releaseDate);
        tvOverview.setText(overview);
    }
}