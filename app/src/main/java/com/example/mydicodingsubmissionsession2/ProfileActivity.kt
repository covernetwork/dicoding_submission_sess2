package com.example.mydicodingsubmissionsession2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mydicodingsubmissionsession2.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
            .load("https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:a4e7d96164d816a863ab295ef21b616020230920123326.png")
            .into(binding.profileImage)
        binding.profileName.text = getString(R.string.catur_wicaksono)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}