package com.example.nottutmaapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nottutmaapp.data.entity.Notes

@Database(entities = [Notes::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun getNotesDao(): NotesDao
}