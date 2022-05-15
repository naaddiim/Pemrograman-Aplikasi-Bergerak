package NadimIF4A.example.pertemuan7.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

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
    private food food;
    private List<ResponseMeal> responseMeals;

    private ImageView ivThumbnail;
    private TextView tvFoodName, tvRating, tvVoting, tvReleaseDate, tvOverview;

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