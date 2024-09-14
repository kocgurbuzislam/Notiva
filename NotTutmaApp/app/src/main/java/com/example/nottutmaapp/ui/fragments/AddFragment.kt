package com.example.nottutmaapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.nottutmaapp.R
import com.example.nottutmaapp.databinding.FragmentAddBinding
import com.example.nottutmaapp.ui.adapter.NotesAdapter
import com.example.nottutmaapp.ui.viewmodels.AddViewModel
import com.example.nottutmaapp.util.transition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: AddViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add ,container, false)
        binding.addfragment = this


        return binding.root
    }

    fun back(it: View){
        Navigation.transition(it,R.id.addTohome)
    }

    fun addNote(note_title: String, note_detail: String){
        viewModel.addNotes(note_title, note_detail)
        Toast.makeText(requireContext(), "Not eklendi", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddViewModel by viewModels()
        viewModel = tempViewModel

    }
}