package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.SharedViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_shoe_list, container, false)
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,R.layout.fragment_shoe_list,container,false
        )

        viewModel =ViewModelProvider(this).get(SharedViewModel::class.java)

        binding.floatingActionButton.setOnClickListener { view:View->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())


            viewModel.loadData()

        }



        return  binding.root


    }


}