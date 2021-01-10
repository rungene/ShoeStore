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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.SharedViewModel
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*


class ShoeDetailFragment : Fragment() {

    private  val viewModel:SharedViewModel by  activityViewModels()



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

        binding.sharedViewModel = viewModel
        binding.shoe = Shoe("",0.0,"","")

        binding.buttonCancel.setOnClickListener { view:View->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())

        }

        return binding.root



    }


}