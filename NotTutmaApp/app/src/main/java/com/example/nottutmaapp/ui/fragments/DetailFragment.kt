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
import androidx.navigation.fragment.navArgs
import com.example.nottutmaapp.R
import com.example.nottutmaapp.databinding.FragmentDetailBinding
import com.example.nottutmaapp.ui.viewmodels.DetailViewModel
import com.example.nottutmaapp.util.transition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail ,container, false)
        binding.detailfragment = this

        val bundle: DetailFragmentArgs by navArgs()
        var incomingNote = bundle.note

        binding.notesObject = incomingNote


        return binding.root
    }

    fun back(it: View){
        Navigation.transition(it,R.id.detailTohome)
    }

    fun updateNote(note_id: Int,note_title: String, note_detail: String){
        viewModel.updateNote(note_id,note_title, note_detail)
        Toast.makeText(requireContext(),"Notunuz Güncellendi", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel

    }

}