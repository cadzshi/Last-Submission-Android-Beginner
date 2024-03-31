package com.dicoding.lastsubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Keyboard (
    val name: String,
    val description: String,
    val price: String,
    val photo: Int
): Parcelable

