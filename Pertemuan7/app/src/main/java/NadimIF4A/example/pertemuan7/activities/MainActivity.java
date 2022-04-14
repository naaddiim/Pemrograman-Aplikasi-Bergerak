package NadimIF4A.example.pertemuan7.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

import NadimIF4A.example.pertemuan7.R;
import NadimIF4A.example.pertemuan7.adapters.foodViewAdapter;
import NadimIF4A.example.pertemuan7.models.food;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFood;
    private foodViewAdapter foodViewAdapter;
    private List<food> foodList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFood = findViewById(R.id.rvFood);

        foodList = getDummyData();
        foodViewAdapter = new foodViewAdapter(foodList);
        rvFood.setLayoutManager(new LinearLayoutManager(this));
        rvFood.setAdapter(foodViewAdapter);



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

    private List<food> getDummyData() {
        List<food> data = new ArrayList<>();
        //masukan data pertama
        food food = new food();
        food.setId(0);
        food.setNama("Indomie Goreng");
        food.setThumbnail(R.drawable.indomie);
        data.add(food);

        //masukan data kedua
        food = new food();
        food.setId(1);
        food.setNama("Kari Ayam");
        food.setThumbnail(R.drawable.indomie2);
        data.add(food);

        //dan seterusnya

        return data;
    }


}