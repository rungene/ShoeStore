package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeDetailViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel:ShoeDetailViewModel


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

        //getting the viewmodel

        viewModel =ViewModelProvider(this).get(ShoeDetailViewModel::class.java)


        binding.shoeDetailsSave.setOnClickListener {view:View->

            val nameText =view.name_text.toString()
            val companyText =view.company_text.toString()
            val shoeSizeText =view.shoe_size_text.toString().toInt()
            val shoeDescription = view.description_text.toString()

            viewModel.saveData(nameText,companyText,shoeSizeText,shoeDescription)


        }

        return binding.root




    }


}