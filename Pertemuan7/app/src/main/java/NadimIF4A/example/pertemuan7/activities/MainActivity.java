package NadimIF4A.example.pertemuan7.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import NadimIF4A.example.pertemuan7.R;
import NadimIF4A.example.pertemuan7.adapters.foodViewAdapter;
import NadimIF4A.example.pertemuan7.models.ResponseData;
import NadimIF4A.example.pertemuan7.models.ResponseMeal;
import NadimIF4A.example.pertemuan7.models.food;
import NadimIF4A.example.pertemuan7.services.APIService;
import NadimIF4A.example.pertemuan7.utils.Constant;
import NadimIF4A.example.pertemuan7.utils.ItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFood;
    private foodViewAdapter foodViewAdapter;
    private List<ResponseMeal> foodList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFood = findViewById(R.id.rvFood);

//        foodList = getDummyData();
        //methode onFoodItemClick buat sendiri
        foodViewAdapter = new foodViewAdapter((ItemClickListener<ResponseMeal>) this::onFoodItemClick);
//        rvFood.setLayoutManager(new LinearLayoutManager(this));
        //hanya bisa set jumlah kolom
        rvFood.setLayoutManager(new GridLayoutManager(this, 2));
        rvFood.setAdapter(foodViewAdapter);
        foodViewAdapter.setData(foodList);

        getChickenFood();

        //shift+f6 untuk mengganti semua kata yang sama
        //ctrl+d diujung line untuk menduplikat 1 line tanpat harus di blok


        //memanggil hasil saved state information
//        if(savedInstanceState  != null) {
//            likeIndomie = savedInstanceState.getInt("totalLikesIndomie");
//            tvLike.setText(String.valueOf(likeIndomie) + " Likes");
//        }
        //untuk save state information sebelum shutdown activity
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("totalLikesIndomie", likeIndomie); //key tidak boleh ada spasi
//    }

    }

    //intent pindah ke method ini
    private void onFoodItemClick(ResponseMeal responseMeal, int i) {
        Intent intent = new Intent(this, DetailActivity.class);
//      memanggil intent dari kelas Constant dan mengirim kelas Food
        intent.putExtra(Constant.EXTRA_MEALS_ID, responseMeal.getIdMeal());
        startActivity(intent);
    }

    //Serializable vs Parcelable

    private List<food> getDummyData() {
        List<food> data = new ArrayList<>();
        //masukan data pertama
        food food = new food();
        food.setId(0);
        food.setNama("Indomie Goreng");
        food.setThumbnail(R.drawable.indomie);
        food.setDeskripsi("Indomie terenak");
        food.setVote(250);
        food.setRate(4.1f);
        food.setTanggalRilis("25-04-2022");
        data.add(food);

        //masukan data kedua
        food = new food();
        food.setId(1);
        food.setNama("Kari Ayam");
        food.setThumbnail(R.drawable.indomie2);
        food.setDeskripsi("Indomie kuah terenak");
        food.setVote(150);
        food.setRate(3.9f);
        food.setTanggalRilis("21-04-2022");
        data.add(food);

        //dan seterusnya

        return data;
    }

    private void getChickenFood() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                //convert JSON ke model java
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        apiService.getMeals("Chicken").enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if(response.code() == 200) {
                    foodList = response.body().getMeals();
                    foodViewAdapter.setData(foodList);
                    Toast.makeText(MainActivity.this, "Response Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Response code : "+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                System.out.println("Retrofit Error: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Rerofit Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}