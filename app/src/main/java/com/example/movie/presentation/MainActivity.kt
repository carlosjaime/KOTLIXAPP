package com.example.movie.presentation
//CARLOS JAIME LOPEZ MARTINEZ

import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movie.R
import com.example.movie.domain.usercase.GetMovieByList
import com.example.movie.domain.usercase.SearchGenresByList
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


}