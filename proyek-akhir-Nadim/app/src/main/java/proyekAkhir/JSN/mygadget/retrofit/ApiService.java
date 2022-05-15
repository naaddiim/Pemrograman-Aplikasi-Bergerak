package proyekAkhir.JSN.mygadget.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String BASE_URL = "https://apipcpart.000webhostapp.com/";
    private static Retrofit retrofit;
    public static ApiEndpoint endpoint () {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiEndpoint.class);
    }

}
