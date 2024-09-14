package com.example.nottutmaapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nottutmaapp.data.entity.Notes
import com.example.nottutmaapp.data.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (var nrepo: NotesRepository): ViewModel() {
    var notesList = MutableLiveData<List<Notes>>()

    init {
        getNotes()
    }


    fun getNotes(){
        CoroutineScope(Dispatchers.Main).launch {
           notesList.value = nrepo.getNotes()
        }
    }

    fun searchNotes(searchWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            notesList.value = nrepo.searchNotes(searchWord)
        }
    }

    fun deleteNotes(note_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.deleteNotes(note_id)
            getNotes()
        }
    }
}