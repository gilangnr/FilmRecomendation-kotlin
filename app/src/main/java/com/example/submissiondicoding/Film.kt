package com.example.submissiondicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val title: String,
    val rate: String,
    val poster: Int,
    val sinopsis: String
) : Parcelable
