package proyekAkhir.JSN.mygadget.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import proyekAkhir.JSN.mygadget.R;

public class LainActivity extends AppCompatActivity {

    private final String TAG = "LainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lain);
//        getDataFromApi();
    }

//    private void getDataFromApi()
//    {
//        ApiService.endpointlain().getLain()
//                .enqueue(new Callback<LainModel>() {
//                    @Override
//                    public void onResponse(Call<LainModel> call, Response<LainModel> response) {
//                        Log.d( TAG, response.toString());
//                        if(response.isSuccessful())
//                        {
//                            List<LainModel.Data> data = response.body().getData();
//                            Toast.makeText(LainActivity.this, "Response Success!", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, data.toString());
//                        }
//                        else
//                        {
//                            Toast.makeText(LainActivity.this, "Response Code " + response.code(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<LainModel> call, Throwable t) {
//                        Toast.makeText(LainActivity.this, "Retrofit Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, t.toString());
//                    }
//                });
//    }
}