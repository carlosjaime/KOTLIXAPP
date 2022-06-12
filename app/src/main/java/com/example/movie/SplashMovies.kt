package com.example.movie
//CARLOS JAIME LOPEZ MARTINEZ

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.presentation.MainActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashMovies : AppCompatActivity() {

    private val scope = MainScope()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)


        val linearIndicator: ProgressBar = findViewById(R.id.progressBar_p)

        // Indicar determinado
        scope.launch {
            while (true)
                progress(linearIndicator)
        }



        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)


    }

    private suspend fun progress(progressBar: ProgressBar) {
        while (progressBar.progress < progressBar.max) {
            delay(300)
            progressBar.incrementProgressBy(PROGRESS_INCREMENT)

        }
        progressBar.progress = 0
    }


    override fun onDestroy() {
        super.onDestroy()
        scope.cancel() // Destruimos el alcance de la corrutina
    }

    companion object {
        const val PROGRESS_INCREMENT = 5
    }

}