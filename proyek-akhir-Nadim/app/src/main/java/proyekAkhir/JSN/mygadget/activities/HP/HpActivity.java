package proyekAkhir.JSN.mygadget.activities.HP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import proyekAkhir.JSN.mygadget.Intent_Key;
import proyekAkhir.JSN.mygadget.R;
import proyekAkhir.JSN.mygadget.activities.Laptop.DetailLaptopActivity;
import proyekAkhir.JSN.mygadget.activities.Laptop.LaptopActivity;
import proyekAkhir.JSN.mygadget.adapter.HPAdapter;
import proyekAkhir.JSN.mygadget.models.Hp.Phones;
import proyekAkhir.JSN.mygadget.models.Hp.Respon;
import proyekAkhir.JSN.mygadget.retrofit.ApiServiceHP;
import proyekAkhir.JSN.mygadget.retrofit.ApiServiceLaptop;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HpActivity extends AppCompatActivity {

    private final String TAG = "HpActivity";
    private List<Phones> phones = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HPAdapter hpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);
        recyclerView =findViewById(R.id.rvHP);
        progressBar = findViewById(R.id.pbHP);
        setupRecyclerView();
        getDataFromApi();
    }

    private void setupRecyclerView() {
        hpAdapter = new HPAdapter(phones, new HPAdapter.OnAdapterListener() {
            @Override
            public void onClick(Phones result) {
                Intent intent = new Intent(HpActivity.this, DetailHPActivity.class);
                intent.putExtra(Intent_Key.EXTRA_HP_SLUG, result.getSlug());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(hpAdapter);
    }

    private void getDataFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        ApiServiceHP.endpoint().getPhones()
                .enqueue(new Callback<Respon>() {
                    @Override
                    public void onResponse(Call<Respon> call, Response<Respon> response) {
                        progressBar.setVisibility(View.GONE);
                        if(response.isSuccessful()) {
                            phones = response.body().getData().getPhones();
                            hpAdapter.setData(phones);
                        }
                    }

                    @Override
                    public void onFailure(Call<Respon> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Log.d("HPActivity", t.getMessage());
                    }
                });
    }
}