package com.example.mydicodingsubmissionsession2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(
    val name: String,
    val description: String,
    val photo: String,
) : Parcelable