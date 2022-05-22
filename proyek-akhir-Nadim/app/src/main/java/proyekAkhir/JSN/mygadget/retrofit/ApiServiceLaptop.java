package proyekAkhir.JSN.mygadget.retrofit;

import proyekAkhir.JSN.mygadget.retrofit.ApiEndpoint;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceLaptop {

    private static String BASE_URL_LAPTOP = "https://apipcpart.000webhostapp.com/";
    private static Retrofit retrofit;

    public static ApiEndpoint endpoint() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_LAPTOP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiEndpoint.class);
    }


}
