package proyekAkhir.JSN.mygadget.retrofit;

import java.util.ArrayList;

import proyekAkhir.JSN.mygadget.models.Hp.Detail.DetailRespon;
import proyekAkhir.JSN.mygadget.models.Hp.Respon;
import proyekAkhir.JSN.mygadget.models.LainModel;
import proyekAkhir.JSN.mygadget.models.Laptop.LaptopModel;
import proyekAkhir.JSN.mygadget.models.Laptop.SpecsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoint {

    //End Point Laptop
    @GET("laptop.php")
    Call<LaptopModel> getLaptop();

    @GET("specs.php")
    Call<SpecsModel> getSpecs(@Query("laptop_id") String idLaptop);

    @GET("v2/brands/apple-phones-48")
    Call<Respon> getPhones();

    @GET("v2/{phone_slug}")
    Call<DetailRespon> getPhonesDetail(@Path("phone_slug") String phone_slug);

    @GET("products")
    Call<ArrayList<LainModel>> getLain();

}
