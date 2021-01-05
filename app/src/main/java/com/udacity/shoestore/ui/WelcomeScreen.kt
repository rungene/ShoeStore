package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding



class WelcomeScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_welcome_screen, container, false)

        val binding = DataBindingUtil.inflate<FragmentWelcomeScreenBinding>(
                inflater,R.layout.fragment_welcome_screen,container,false
        )

        binding.instructionsButton.setOnClickListener { view:View ->
            // view.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())

            view.findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructionsFragment())

        }



        return binding.root
    }


}