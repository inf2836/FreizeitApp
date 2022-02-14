package de.tinacode.freizeitapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val backgroundImg: ImageView = findViewById(R.id.logo)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        backgroundImg.startAnimation(slideAnimation)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5000 )
    }
}