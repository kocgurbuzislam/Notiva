package com.example.nottutmaapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.nottutmaapp.data.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var nrepo: NotesRepository): ViewModel(){


    fun updateNote(note_id: Int, note_title: String, note_detail: String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.updateNotes(note_id, note_title, note_detail)
        }
    }
}