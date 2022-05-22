package proyekAkhir.JSN.mygadget.activities.HP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import proyekAkhir.JSN.mygadget.Intent_Key;
import proyekAkhir.JSN.mygadget.R;
import proyekAkhir.JSN.mygadget.models.Hp.Detail.DetailRespon;
import proyekAkhir.JSN.mygadget.models.Hp.Detail.Specs;
import proyekAkhir.JSN.mygadget.models.Laptop.SpecsModel;
import proyekAkhir.JSN.mygadget.retrofit.ApiServiceHP;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailHPActivity extends AppCompatActivity {

    private final String TAG = "DetailHPActivity";
    private ProgressBar progressBar;
    private TextView namaHP, hargaHP, specHP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hpactivity);
        progressBar = findViewById(R.id.progressBar2);
        namaHP = findViewById(R.id.tvNamaHP);
        hargaHP = findViewById(R.id.tvDetailHargaHP);
        specHP = findViewById(R.id.tvSpecsHP);

        getDataFromApi();
    }

    private void getDataFromApi() {
        String phone_slug = getIntent().getStringExtra(Intent_Key.EXTRA_HP_SLUG);
        progressBar.setVisibility(View.VISIBLE);
        ApiServiceHP.endpoint().getPhonesDetail(phone_slug)
                .enqueue(new Callback<DetailRespon>() {
                    @Override
                    public void onResponse(Call<DetailRespon> call, Response<DetailRespon> response) {
                        progressBar.setVisibility(View.GONE);
                        if(response.isSuccessful()) {
                            namaHP.setText(response.body().getData().getPhone_name());
                            String gambar_hp = response.body().getData().getThumbnail();
//                            String hargadenganKoma = formatRupiah(Double.parseDouble(response.body().getData().getSpecifications().get(12).getTitle()));
                            String hargedenganKoma = response.body().getData().getSpecifications().get(12).getSpecs().get(2).getVal().get(0);

//                            String harga = TextUtils.substring(hargadenganKoma, 0, hargadenganKoma.length()-3);
//                            hargaLaptop.setText(harga);
                            Glide.with(getApplicationContext())
                                    .load(gambar_hp)
                                    .placeholder(R.drawable.img_placeholder)
                                    .fitCenter()
                                    .into((ImageView) findViewById(R.id.ivDetailHP));
                            hargaHP.setText(hargedenganKoma);
//                            String storage = response.body().getStorage();
//                            S`tring cpu = response.body().getCpu();
//                            String gpu = response.body().getGpu();
//                            String dimension = response.body().getDimension();
//                            specHP.setText("\nStorage : "+storage+"\n\nCPU : "+cpu+"" +
//                                    "\n\nGraphic : "+gpu+"\n\nDimension : "+dimension+"\n\nHarga : "+harga+"\n");
                        }
                    }

                    @Override
                    public void onFailure(Call<DetailRespon> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(DetailHPActivity.this, "Error, Please check logcat for detail", Toast.LENGTH_SHORT).show();
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