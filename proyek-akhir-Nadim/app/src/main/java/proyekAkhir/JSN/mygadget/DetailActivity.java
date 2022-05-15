package proyekAkhir.JSN.mygadget;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Locale;

import proyekAkhir.JSN.mygadget.intent.Intent_Key;
import proyekAkhir.JSN.mygadget.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailActivity extends AppCompatActivity {
    private final String TAG = "DetailActivity";
    private ProgressBar progressBar;
    private ImageView gambarDetail;
    private TextView namaLaptop, hargaLaptop;
    private SpecsModel specsModel;

    //ambil parameter ID dan gambar dari main activity

//    String idLaptop = getIntent().getExtras().getString(Intent_Key.EXTRA_LAPTOP_ID);
//    String gambarLaptop = getIntent().getStringExtra(Intent_Key.EXTRA_LAPTOP_THUMBNAIL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.progressBar2);
//        gambarDetail = findViewById(R.id.ivDetail1);
        namaLaptop = findViewById(R.id.tvDetail1);
        hargaLaptop = findViewById(R.id.tvDetail3);
        getDataFromApi();

    }


    private void getDataFromApi () {
        String laptop_id = getIntent().getStringExtra(Intent_Key.EXTRA_LAPTOP_ID);
        String image = getIntent().getStringExtra(Intent_Key.EXTRA_LAPTOP_THUMBNAIL);
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endpoint().getSpecs(laptop_id)
                .enqueue(new Callback<SpecsModel>() {
                    @Override
                    public void onResponse(Call<SpecsModel> call, Response<SpecsModel> response) {
                        progressBar.setVisibility(View.GONE);
                        Log.d( TAG, response.toString());
                        if(response.isSuccessful()) {
//                            namaLaptop.setText(response.body().getLaptop_name());
//                            String hargadenganKoma = formatRupiah(Double.parseDouble(response.body().getPrice()));
//                            String harga = TextUtils.substring(hargadenganKoma, 0, hargadenganKoma.length()-3);
//                            hargaLaptop.setText(harga);
//
//                            Glide.with(getApplicationContext())
//                                    .load(gambarLaptop)
////                                    .placeholder(R.drawable.ic_broken_image_24)
//                                    .into(gambarDetail);


                            getSupportActionBar().setTitle(laptop_id);
                            namaLaptop.setText(response.body().getLaptop_name());
                            String hargadenganKoma = formatRupiah(Double.parseDouble(response.body().getPrice()));
                            String harga = TextUtils.substring(hargadenganKoma, 0, hargadenganKoma.length()-3);
                            hargaLaptop.setText(harga);
                            Glide.with(getApplicationContext())
                                    .load(image)
                                    .placeholder(R.drawable.img_placeholder)
                                    .fitCenter()
                                    .into((ImageView) findViewById(R.id.ivDetail1));

                            }
                        }

                    @Override
                    public void onFailure(Call<SpecsModel> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
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