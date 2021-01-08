package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel:ViewModel() {

    // The shoe Name
    val shoeName = MutableLiveData<String>()
    //company name
    val companyName = MutableLiveData<String>()
    //Shoe Size
    val shoeSize = MutableLiveData<Int>()
    //description
    val description = MutableLiveData<String>()


    init {
        //saveData()

    }

 fun saveData(shoename:String,companyname:String,shoesize:Int,descriptions:String) {

        shoeName.value = shoename
        companyName.value = companyname
        shoeSize.value = shoesize
        description.value =descriptions


    }

    private fun loadData(){

    }

}