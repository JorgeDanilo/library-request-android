package br.com.sistemas.jd.mylibrary.mylibrary;

import java.util.List;

import br.com.sistemas.jd.mylibrary.mylibrary.interfaces.ApiInterface;
import br.com.sistemas.jd.mylibrary.mylibrary.model.Movie;
import br.com.sistemas.jd.mylibrary.mylibrary.model.MoviesResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    private List<Movie> movies;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

//    public static List<MoviesResponse> teste(String apiKey) {
//
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        List<MoviesResponse> movies = apiInterface.getTopRatedMovies(apiKey);
//        return movies;
//
//    }



}
