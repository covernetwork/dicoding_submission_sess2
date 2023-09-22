package com.example.mydicodingsubmissionsession2

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mydicodingsubmissionsession2.databinding.ActivityDetailAnimalBinding


class DetailAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val animal = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Animal>(MainActivity.EXTRA_ANIMAL, Animal::class.java)
        } else {
            @Suppress("DEPRECATION") intent.getParcelableExtra<Animal>(MainActivity.EXTRA_ANIMAL)
        }

        if (animal != null) {
            Glide.with(this).load(animal.photo).into(binding.detailImage)
            binding.detailTitle.text = animal.name
            binding.detailDescription.text = animal.description
        }
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