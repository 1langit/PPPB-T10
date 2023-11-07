package com.example.pppb_t10

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pppb_t10.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        with(binding) {
            txtName.text = intent.getStringExtra("nama")
            txtNim.text = intent.getStringExtra("nim")
            val ipk = intent.getDoubleExtra("ipk", 0.0)
            txtIpk.text = ipk.toString()

            btnBack.setOnClickListener {
                finish()
            }

            Glide.with(this@DetailActivity)
                .load(intent.getStringExtra("img"))
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(imgProfile)

            if (ipk >= 3.5) {
                txtIpk.setTextColor(Color.WHITE)
                txtIpk.background.setTint(Color.parseColor("#525BFF"))
            } else if (ipk >= 3.0) {
                txtIpk.setTextColor(Color.BLACK)
                txtIpk.background.setTint(Color.GREEN)
            } else if (ipk >= 2.5) {
                txtIpk.setTextColor(Color.BLACK)
                txtIpk.background.setTint(Color.YELLOW)
            } else if (ipk >= 2.0) {
                txtIpk.setTextColor(Color.WHITE)
                txtIpk.background.setTint(Color.RED)
            } else {
                txtIpk.setTextColor(Color.WHITE)
                txtIpk.background.setTint(Color.GRAY)
            }
        }
    }
}