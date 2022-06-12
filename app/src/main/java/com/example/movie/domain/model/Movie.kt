package com.example.movie.domain.model
//CARLOS JAIME LOPEZ MARTINEZ

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.movie.data.room.Genre_igsConverter



data class Movie(
    var adult:Boolean = false,
    var backdrop_path: String,

    var genre_ids: List<String>,
    //var genre_ids:String,
    var id:Int = 0,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity:Double = 0.0,
    var poster_path: String,
    var release_date: String,
    var title: String,
    var video:Boolean = false,
    var vote_average:Double = 0.0,
    var vote_count:Int = 0
)

data class MovieList (
    var page:Int = 0,
    var results: List<Movie>,
    var total_pages:Int = 0,
    var total_results:Int = 0
)