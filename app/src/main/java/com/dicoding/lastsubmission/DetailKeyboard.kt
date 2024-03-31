package com.dicoding.lastsubmission

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailKeyboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_keyboard)

        val tvName: TextView = findViewById(R.id.tv_name_received)
        val tvPrice: TextView = findViewById(R.id.tv_price_received)
        val tvDesc: TextView = findViewById(R.id.tv_desc_received)
        val img: ImageView = findViewById(R.id.img_received)

        val keyboard = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Keyboard>(MainActivity.KEY_KEYBOARD, Keyboard::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Keyboard>(MainActivity.KEY_KEYBOARD)
        }

        if (keyboard != null) {
            tvName.text = keyboard.name
            tvPrice.text = keyboard.price
            tvDesc.text = keyboard.description
            img.setImageResource(keyboard.photo)
        }

        supportActionBar?.title = "Detail Keyboard"

    }
}