package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable


data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : BaseObservable()