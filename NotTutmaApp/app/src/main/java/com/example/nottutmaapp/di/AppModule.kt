package com.example.nottutmaapp.di

import android.content.Context
import androidx.room.Room
import com.example.nottutmaapp.data.datasource.NotesDataSource
import com.example.nottutmaapp.data.repo.NotesRepository
import com.example.nottutmaapp.room.Database
import com.example.nottutmaapp.room.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.modules.ApplicationContextModule
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideNotesDataSource(noteDao: NotesDao): NotesDataSource {
        return NotesDataSource(noteDao)

    }

    @Provides
    @Singleton
    fun provideNotesRepository(noteds: NotesDataSource): NotesRepository {
        return NotesRepository(noteds)

    }

    @Provides
    @Singleton
    fun provideNotesDao(@ApplicationContext context: Context): NotesDao {
        val dt = Room.databaseBuilder(context, Database::class.java, "Notes.sqlite")
            .createFromAsset("Notes.sqlite")
            .build()
        return dt.getNotesDao()

    }
}