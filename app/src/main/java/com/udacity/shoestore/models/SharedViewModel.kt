package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class SharedViewModel:ViewModel() {

    //Create Live Data Object
    private var _shoeList =MutableLiveData<ArrayList<Shoe>>()
    val shoeList:LiveData<ArrayList<Shoe>>
    get() =_shoeList


    fun dataSave(v:View, shoe: Shoe) {
        _shoeList.value?.add(shoe)
        navigateUp(v)

    }

    init {
     _shoeList.value=ArrayList()

    }

    fun navigateUp(v:View){
        v.findNavController().navigateUp()


    }


}