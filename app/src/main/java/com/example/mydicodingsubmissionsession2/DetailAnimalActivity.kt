package com.example.mydicodingsubmissionsession2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mydicodingsubmissionsession2.databinding.ActivityDetailAnimalBinding

class DetailAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal = if (Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra<Animal>(MainActivity.EXTRA_ANIMAL,Animal::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Animal>(MainActivity.EXTRA_ANIMAL)
        }

        if (animal != null){
            Glide.with(this).load(animal.photo).into(binding.detailImage)
        }
    }
}