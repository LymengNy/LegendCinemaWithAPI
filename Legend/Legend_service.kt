package com.example.yujie.Legend


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
//https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1&api_key=636f8f0adff0238c91ac5b2d7e0a8e94
const val BASE_URL = "https://api.themoviedb.org"

interface LegendService{

    @GET("3/movie/now_playing")
    suspend fun getMovies(
        @Query("language") language:String="en-Us",
        @Query("page") page:Int=1,
        @Query("api_key") apiKey:String="636f8f0adff0238c91ac5b2d7e0a8e94",
    ): TheMovieLegend




    companion object {
        var service : LegendService? = null
        fun getInstance() : LegendService {
            if(service == null){
                service = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(LegendService::class.java)
            }
            return service!!
        }
    }

}
