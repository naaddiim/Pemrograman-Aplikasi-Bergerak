package proyekAkhir.JSN.mygadget.activities.Laptop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Locale;

import proyekAkhir.JSN.mygadget.Intent_Key;
import proyekAkhir.JSN.mygadget.R;
import proyekAkhir.JSN.mygadget.models.Laptop.SpecsModel;
import proyekAkhir.JSN.mygadget.retrofit.ApiServiceLaptop;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailLaptopActivity extends AppCompatActivity {
    private final String TAG = "DetailLaptopActivity";
    private ProgressBar progressBar;
    private TextView namaLaptop, hargaLaptop, specLaptop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laptop);
        progressBar = findViewById(R.id.progressBar2);
        namaLaptop = findViewById(R.id.tvDetail1);
        hargaLaptop = findViewById(R.id.tvDetail3);
        specLaptop = findViewById(R.id.tvSpecsLaptop);

        getDataFromApi();
    }

    private void getDataFromApi() {
        String laptop_id = getIntent().getStringExtra(Intent_Key.EXTRA_LAPTOP_ID);
        String gambar_laptop = getIntent().getStringExtra(Intent_Key.EXTRA_LAPTOP_THUMBNAIL);
        progressBar.setVisibility(View.VISIBLE);
        ApiServiceLaptop.endpoint().getSpecs(laptop_id)
                .enqueue(new Callback<SpecsModel>() {
                    @Override
                    public void onResponse(Call<SpecsModel> call, Response<SpecsModel> response) {
                        progressBar.setVisibility(View.GONE);
                        if(response.isSuccessful()) {
                            namaLaptop.setText(response.body().getLaptop_name());
                            String hargadenganKoma = formatRupiah(Double.parseDouble(response.body().getPrice()));
                            String harga = TextUtils.substring(hargadenganKoma, 0, hargadenganKoma.length()-3);
                            hargaLaptop.setText(harga);
                            Glide.with(getApplicationContext())
                                    .load(gambar_laptop)
                                    .placeholder(R.drawable.img_placeholder)
                                    .fitCenter()
                                    .into((ImageView) findViewById(R.id.ivDetail1));
                            String storage = response.body().getStorage();
                            String cpu = response.body().getCpu();
                            String gpu = response.body().getGpu();
                            String dimension = response.body().getDimension();
                            specLaptop.setText("\nStorage : "+storage+"\n\nCPU : "+cpu+"" +
                                    "\n\nGraphic : "+gpu+"\n\nDimension : "+dimension+"\n\nHarga : "+harga+"\n");
                        }
                    }

                    @Override
                    public void onFailure(Call<SpecsModel> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(DetailLaptopActivity.this, "Error, Please check logcat for detail", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, t.toString());
                    }
                });

    }

    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }
}