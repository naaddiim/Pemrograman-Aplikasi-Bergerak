package NadimIF4A.example.pertemuan7.services;

import NadimIF4A.example.pertemuan7.models.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("filter.php?c=Chicken")
    Call<ResponseData> getMeals(@Query("c") String category);

    //Tambahkan semua end point disini

    @GET("lookup.php")
    Call<ResponseData> getMealDetail(@Query("i") String idMeal);
}
