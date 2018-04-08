package br.com.sistemas.jd.mylibrary.mylibrary;

import java.io.IOException;
import java.util.List;

import br.com.sistemas.jd.mylibrary.mylibrary.interfaces.ApiInterface;
import br.com.sistemas.jd.mylibrary.mylibrary.model.Movie;
import br.com.sistemas.jd.mylibrary.mylibrary.model.MoviesResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    private List<Movie> movies;


    public static Retrofit getClient() {


        /**
         * Interceptor to http authorization by header. token.
         */
        OkHttpClient c = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String token = "546465465465asad4a56d4adasd4a6d46";
                Request authorization = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token).build();
                return chain.proceed(authorization);
            }
        }).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(c)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
