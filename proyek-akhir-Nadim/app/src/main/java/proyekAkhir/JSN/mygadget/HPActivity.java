package proyekAkhir.JSN.mygadget;

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

import proyekAkhir.JSN.mygadget.retrofit.ApiService;
import proyekAkhir.JSN.mygadget.retrofit.ApiService2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HPActivity extends AppCompatActivity {

    private final String TAG = "HPActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HPAdapter hpAdapter;
    private List<HpModel.Result> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);
        getSupportActionBar().setTitle("HP Activity");
        setupView();
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        hpAdapter = new HPAdapter(data, new HPAdapter.OnAdapterListener() {
            @Override
            public void onClick(HpModel.Result phone) {
//                Intent intent = new Intent(HPActivity.this, DetailHPActivity.class);
//                intent.putExtra("BRAND_NAME", result.getBrand_name());
//                intent.putExtra("LAPTOP_NAME", result.getLaptop_name());
//                intent.putExtra("IMAGE", result.getImage());
//                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(hpAdapter);
    }



    private void setupView() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
    }


}