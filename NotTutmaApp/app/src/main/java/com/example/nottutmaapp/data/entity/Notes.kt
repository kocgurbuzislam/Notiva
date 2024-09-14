package com.example.nottutmaapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "notes")
data class Notes(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "notes_id") @NotNull var notes_id: Int,
                @ColumnInfo(name = "notes_title") @NotNull var notes_title: String,
                @ColumnInfo(name = "notes_detail") @NotNull var notes_detail: String): Serializable
