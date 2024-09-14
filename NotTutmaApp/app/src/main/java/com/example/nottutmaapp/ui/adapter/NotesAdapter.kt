package com.example.nottutmaapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.nottutmaapp.data.entity.Notes
import com.example.nottutmaapp.databinding.CardDesignBinding
import com.example.nottutmaapp.ui.fragments.HomeFragmentDirections
import com.example.nottutmaapp.ui.viewmodels.HomeViewModel
import com.example.nottutmaapp.util.transition
import com.google.android.material.snackbar.Snackbar

class NotesAdapter(var mContext: Context, var notesList: List<Notes>, var viewModel: HomeViewModel): RecyclerView.Adapter<NotesAdapter.cardHolder>() {

    inner class cardHolder(var binding: CardDesignBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardHolder {
        var binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return cardHolder(binding)
    }


    override fun onBindViewHolder(holder: cardHolder, position: Int) {
        var note = notesList.get(position)
        var t = holder.binding

        t.notesObject = note

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${note.notes_title} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.deleteNotes(note.notes_id)
                }
                .show()
        }

        t.cardView.setOnClickListener {
            var transition = HomeFragmentDirections.homeTodetail(note = note)
            Navigation.transition(it,transition)
        }

    }

    override fun getItemCount(): Int {
        return notesList.size
    }


}