package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.SharedViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*


class ShoeListFragment : Fragment() {

    private  val viewModel: SharedViewModel by activityViewModels()


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

        binding.lifecycleOwner = this

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it){
                DataBindingUtil.inflate<ShoeListItemBinding>(
                    layoutInflater,R.layout.shoe_list_item,
                    binding.shoeListLayout,
                    true
                ).apply {
                    this.shoe = shoe
                }

            }

        })


        binding.floatingActionButton.setOnClickListener { view:View->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())



        }


        return  binding.root


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==R.id.logout)
            logout()
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)

    }


}