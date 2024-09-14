package com.example.nottutmaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nottutmaapp.R
import com.example.nottutmaapp.databinding.FragmentHomeBinding
import com.example.nottutmaapp.ui.adapter.NotesAdapter
import com.example.nottutmaapp.ui.viewmodels.HomeViewModel
import com.example.nottutmaapp.util.transition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home ,container, false)
        binding.homefragment = this



        viewModel.notesList.observe(viewLifecycleOwner){
            binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
            val notesAdapter = NotesAdapter(requireContext(), it,viewModel)
            binding.notesAdapter = notesAdapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchNotes(query!!)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchNotes(newText!!)
                return true
            }
        })

        return binding.root
    }

    fun searchNotes(searchWord: String){
        viewModel.searchNotes(searchWord)
    }

    fun fabClick(it: View){
        Navigation.transition(it,R.id.homeToadd)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }
}