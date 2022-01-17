package com.example.arty3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arty3.R
import com.example.arty3.adapter.ArtRecylerAdapter
import com.example.arty3.databinding.FragmentArtsBinding
import com.example.arty3.viewmodel.ArtViewModel
import javax.inject.Inject


class FragmentArts @Inject constructor(
    val artRecylerAdapter: ArtRecylerAdapter
) : Fragment() {

    private lateinit var binding: FragmentArtsBinding
    lateinit var viewModel: ArtViewModel

    private val swipeCallback = object :
        ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedArt = artRecylerAdapter.artList[layoutPosition]
            viewModel.deleteArt(selectedArt)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtsBinding.inflate(inflater,container,false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ArtViewModel::class.java)

        subscribeToObservers()

        binding.recyclerViewArts.adapter = artRecylerAdapter
        binding.recyclerViewArts.layoutManager = LinearLayoutManager(requireContext())
        ItemTouchHelper(swipeCallback).attachToRecyclerView(binding.recyclerViewArts)

        binding.fab.setOnClickListener {
            findNavController().navigate(FragmentArtsDirections.actionFragmentArtsToFragmentDetails())
        }
    }


    private fun subscribeToObservers(){
        viewModel.artList.observe(viewLifecycleOwner, Observer {
            artRecylerAdapter.artList = it
        })
    }


}