package com.udacity.shoestore.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.SharedViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel:SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_shoe_detail, container, false)

        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
                inflater,R.layout.fragment_shoe_detail,container,false
        )
       val textName = binding.shoeSizeText
        val textCompany = binding.companyText
        val textSizeShoe = binding.shoeSizeText
        val descriptionShoe = binding.descriptionText

        //getting the viewmodel

        viewModel =ViewModelProvider(this).get(SharedViewModel::class.java)


        binding.shoeDetailsSave.setOnClickListener {view:View->

            val nameText =textName.toString()
            val companyText =textCompany.toString()
            val shoeSizeText =textSizeShoe.text.toString().toInt()
            val shoeDescription = descriptionShoe.toString()

            viewModel.saveData(nameText,companyText,shoeSizeText,shoeDescription)

            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())


        }

        return binding.root






    }


}