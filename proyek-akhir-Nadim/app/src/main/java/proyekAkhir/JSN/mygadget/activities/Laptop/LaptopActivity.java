package proyekAkhir.JSN.mygadget.activities.Laptop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import proyekAkhir.JSN.mygadget.Intent_Key;
import proyekAkhir.JSN.mygadget.adapter.LaptopAdapter;
import proyekAkhir.JSN.mygadget.models.Laptop.LaptopModel;
import proyekAkhir.JSN.mygadget.R;
import proyekAkhir.JSN.mygadget.retrofit.ApiServiceLaptop;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaptopActivity extends AppCompatActivity {

    private final String TAG = "LaptopActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LaptopAdapter laptopAdapter;
    private List<LaptopModel.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);
//        getSupportActionBar().setTitle("Laptop Activity");
        setupView();
        setupRecyclerView();
        getDataFromApi();
    }

    private void setupRecyclerView() {
        laptopAdapter = new LaptopAdapter(results, new LaptopAdapter.OnAdapterListener() {
            @Override
            public void onClick(LaptopModel.Result result) {
                Intent intent = new Intent(LaptopActivity.this, DetailLaptopActivity.class);
                intent.putExtra(Intent_Key.EXTRA_LAPTOP_ID, result.getLaptop_id());
                intent.putExtra(Intent_Key.EXTRA_LAPTOP_THUMBNAIL, result.getImage());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(laptopAdapter);
    }

    private void setupView() {
        recyclerView = findViewById(R.id.rvLaptop);
        progressBar = findViewById(R.id.pbLaptop);
    }

    private void getDataFromApi () {
        progressBar.setVisibility(View.VISIBLE);
        ApiServiceLaptop.endpoint().getLaptop()
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