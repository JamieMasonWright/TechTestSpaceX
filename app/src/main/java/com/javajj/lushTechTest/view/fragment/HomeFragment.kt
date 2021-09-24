package com.javajj.lushTechTest.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.javajj.lushTechTest.R
import com.javajj.lushTechTest.util.LoadingState
import com.javajj.lushTechTest.view.adapter.RocketAdapter
import com.javajj.lushTechTest.viewmodel.RocketViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Used to display data to the user in the form of a scrollable list
 */
class HomeFragment : Fragment(){

    private val rocketViewModel: RocketViewModel by viewModel()
    private lateinit var rocketAdapter: RocketAdapter

    /**
     * When the class is initialised, inflate the fragment_home.xml layout
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * Initialise the RecyclerView and ViewModel observers
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseRecyclerView(view)
        setupObservers()
    }

    /**
     * Intialise the RecyclerView and adapter
     *
     */
    private fun initialiseRecyclerView(view: View){
        rocketAdapter = RocketAdapter()
        view.findViewById<RecyclerView>(R.id.rocket_recyclerview).apply {
            adapter = rocketAdapter
        }
    }


    private fun setupObservers(){

        rocketViewModel.rocketData.observe(viewLifecycleOwner, {
            rocketAdapter.rocketDataList = it.rocketResponse
        })

        rocketViewModel.loadingState.observe(viewLifecycleOwner, {
            when(it.status){
                LoadingState.Status.RUNNING -> showSnackBar("Loading Rocket Data")
                LoadingState.Status.SUCCESS -> showSnackBar("Loaded Rockets Successfully")
                LoadingState.Status.FAILED -> showSnackBar("Cannot Load Data")
            }
        })
    }


    /**
     * Gives user general feeback on state of data that is or is not being loaded
     */
    private fun showSnackBar(text: String){
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).show()
    }

}