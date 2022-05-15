package proyekAkhir.JSN.mygadget.retrofit;

import java.util.List;

import proyekAkhir.JSN.mygadget.HpModel;
import proyekAkhir.JSN.mygadget.LaptopModel;
import proyekAkhir.JSN.mygadget.SpecsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {
    //End Point Laptop
    @GET("laptop.php")
    Call<LaptopModel> getLaptop();

    @GET("specs.php")
    Call<SpecsModel> getSpecs(@Query("laptop_id") String idLaptop);


}
