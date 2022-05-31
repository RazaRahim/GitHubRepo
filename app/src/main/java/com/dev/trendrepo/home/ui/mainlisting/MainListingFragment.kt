package com.dev.trendrepo.home.ui.mainlisting

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.trendingrepo.data.model.Item
import com.dev.trendrepo.databinding.FragmentMainScreenBinding
import com.dev.trendrepo.home.adapter.MainScreenFragmentAdapter
import com.dev.trendrepo.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("unused")
class MainListingFragment : Fragment() {
    private lateinit var mBinding: FragmentMainScreenBinding
    private var mAdapter: MainScreenFragmentAdapter? = null
    private var getCategoryList:List<Item>? = null



    private val viewModel: MainListingViewModel by viewModels()
    var isLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        //For getting the arguments
        arguments?.let {

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentMainScreenBinding.inflate(inflater)
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.show()

        mBinding = view



        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getCategories()


    }

    private fun getCategories() {


        viewModel.getcategories.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Success -> {
                    isLoading = false
                    it.data?.let {
                        getCategoryList = it.items
                        setRecycler()
                    }
                }
                is Resource.Error -> {
                    isLoading = true
                    it.message?.let { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                        Log.e(TAG, "Error: $message")
                    }
                }
                is Resource.Loading -> {

                }
            }
        }
    }


    //set Category Recycler
    private fun setRecycler() {
        mBinding.dataRecycler.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        mAdapter = MainScreenFragmentAdapter(requireContext(), getCategoryList!!)
        mBinding.dataRecycler.adapter = mAdapter

    }


}