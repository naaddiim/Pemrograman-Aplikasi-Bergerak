package masterous.example.emdeepyfoodee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String foodName, rating, voting, overview, releaseDate;
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
        voting = getIntent().getExtras().getString("VOTE");
        releaseDate = getIntent().getExtras().getString("RELEASE_DATE");
        overview = getIntent().getExtras().getString("OVERVIEW");

        ivThumbnail = findViewById(R.id.iv_photo_detail);
        tvFoodName = findViewById(R.id.tv_title_detail);
        tvRating = findViewById(R.id.tv_rating_detail);
        tvVoting = findViewById(R.id.tv_vote_count_detail);
        tvReleaseDate = findViewById(R.id.tv_release_date_detail);
        tvOverview = findViewById(R.id.tv_description);

        ivThumbnail.setImageResource(thumbnail);
        tvFoodName.setText(foodName);
        tvRating.setText(rating);
        tvVoting.setText(voting);
        tvReleaseDate.setText(releaseDate);
        tvOverview.setText(overview);
//        System.out.println("Food Name : " + foodName);
//        System.out.println("Food Thumbnail : " + thumbnail);
//        System.out.println("Food Rating : " + rating);
//        System.out.println("Food Voting : " + voting);
//        System.out.println("Food Release Date : " + releaseDate);
//        System.out.println("Food Overview : " + overview);


    }
}