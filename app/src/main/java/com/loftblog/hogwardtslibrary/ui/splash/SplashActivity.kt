package com.loftblog.hogwardtslibrary.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loftblog.hogwardtslibrary.R
import com.loftblog.hogwardtslibrary.domain.helpers.Keys
import com.loftblog.hogwardtslibrary.ui.hat.HatActivity
import com.loftblog.hogwardtslibrary.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val username = getSharedPreferences(getString(R.string.app_name), 0)
            .getString(Keys.Username.value, "") ?: ""

        if (username.isEmpty()){
            startActivity(Intent(applicationContext, HatActivity::class.java))
        } else {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}