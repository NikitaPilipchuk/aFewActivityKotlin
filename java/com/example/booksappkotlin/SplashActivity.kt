package com.example.booksappkotlin

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var inte: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imageView = findViewById(R.id.imgSplash)
        inte = Intent(this@SplashActivity, MainActivity::class.java)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                startActivity(inte)
                finish()
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })
        imageView.startAnimation(animation)

    }
}