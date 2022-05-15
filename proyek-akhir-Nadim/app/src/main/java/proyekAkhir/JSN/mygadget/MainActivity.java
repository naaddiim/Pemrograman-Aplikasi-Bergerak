package proyekAkhir.JSN.mygadget;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import proyekAkhir.JSN.mygadget.intent.Intent_Key;
import proyekAkhir.JSN.mygadget.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LaptopAdapter laptopAdapter;

    private List<LaptopModel.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Laptop Activity");
        setupView();
        setupRecyclerView();
        getDataFromApi();
    }

    private void setupRecyclerView() {
        laptopAdapter = new LaptopAdapter(results, new LaptopAdapter.OnAdapterListener() {
            @Override
            public void onClick(LaptopModel.Result result) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(Intent_Key.EXTRA_LAPTOP_ID, result.getLaptop_id());
                intent.putExtra("LAPTOP_NAME", result.getLaptop_name());
                intent.putExtra(Intent_Key.EXTRA_LAPTOP_THUMBNAIL, result.getImage());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(laptopAdapter);
    }

    private void setupView() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void getDataFromApi () {
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getLaptop()
                .enqueue(new Callback<LaptopModel>() {
                    @Override
                    public void onResponse(Call<LaptopModel> call, Response<LaptopModel> response) {
                        progressBar.setVisibility(View.GONE);
                        Log.d( TAG, response.toString());
                        if(response.isSuccessful()) {
                            List<LaptopModel.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            laptopAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<LaptopModel> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Log.d(TAG, t.toString());
                    }
                });
    }
}