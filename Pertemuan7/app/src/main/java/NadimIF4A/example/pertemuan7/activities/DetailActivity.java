package NadimIF4A.example.pertemuan7.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import NadimIF4A.example.pertemuan7.R;
import NadimIF4A.example.pertemuan7.models.food;
import NadimIF4A.example.pertemuan7.utils.Constant;

public class DetailActivity extends AppCompatActivity {

    //import class food
    private food food;

    private ImageView ivThumbnail;
    private TextView tvFoodName, tvRating, tvVoting, tvReleaseDate, tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        food = getIntent().getParcelableExtra(Constant.EXTRA_FOOD_DATA);

        ivThumbnail = findViewById(R.id.ivDetail);
        tvFoodName = findViewById(R.id.tvTitle);
        tvRating = findViewById(R.id.tvRating);
        tvVoting = findViewById(R.id.tvVoteCOunt);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvOverview = findViewById(R.id.tvDescription);


        //ivThumbnail.setImageResource(food.getThumbnail());
        Glide.with(getApplicationContext())
                .load(food.getThumbnail())
                .placeholder(R.drawable.ic_broken_image_24)
                .into(ivThumbnail);

        tvFoodName.setText(food.getNama());
        tvRating.setText(String.valueOf(food.getRate()));
        tvVoting.setText(String.valueOf(food.getVote()));
        tvReleaseDate.setText(food.getTanggalRilis());
        tvOverview.setText(food.getDeskripsi());
    }

    //tujuan ????
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
}