    package com.example.yujie.Legend


    import com.google.gson.annotations.SerializedName



    data class TheMovieLegend (

        @SerializedName("dates") var dates : MovieDates,
        @SerializedName("page") var page : Int,
        @SerializedName("results") var results : List<MovieResults>,
        @SerializedName("total_pages") var totalPages : Int,
        @SerializedName("total_results") var totalResults : Int

    )
    data class MovieDates (

        @SerializedName("maximum") var maximum : String,
        @SerializedName("minimum") var minimum : String,

    )

    data class MovieResults (

        @SerializedName("adult") var adult : Boolean,
        @SerializedName("backdrop_path") var backdropPath : String,
        @SerializedName("genre_ids") var genreIds : List<Int>,
        @SerializedName("id") var id : Int,
        @SerializedName("original_language") var originalLanguage : String,
        @SerializedName("original_title") var originalTitle : String,
        @SerializedName("overview") var overview : String,
        @SerializedName("popularity") var popularity : Double,
        @SerializedName("poster_path") var posterPath : String?,
        @SerializedName("release_date") var releaseDate : String,
        @SerializedName("title") var title : String,
        @SerializedName("video") var video : Boolean,
        @SerializedName("vote_average") var voteAverage : Double,
        @SerializedName("vote_count") var voteCount : Int

    )
    {
        fun fullPosterPath():String{
            if(posterPath==null){
                return "https://image.tmdb.org/t/p/w500/$backdropPath"
            }else{
                return "https://image.tmdb.org/t/p/w500/$posterPath"
            }
        }
    }