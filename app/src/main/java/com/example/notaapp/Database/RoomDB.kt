package com.example.notaapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notaapp.Dao.NoteDao
import com.example.notaapp.Enitiy.noteenitiy

@Database(entities = [noteenitiy::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    companion object {
        fun init(context: Context): RoomDB {
            val db = Room.databaseBuilder(context, RoomDB::class.java, "note.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }
    }

    abstract fun note(): NoteDao
}