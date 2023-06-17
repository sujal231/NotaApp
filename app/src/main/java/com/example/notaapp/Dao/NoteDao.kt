package com.example.notaapp.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notaapp.Enitiy.noteenitiy

@Dao
interface NoteDao {

    @Insert
    fun addnote(noteenitiy: noteenitiy)

    @Query("SELECT * FROM note")
    fun getnote() :List<noteenitiy>

    @Update
    fun updatenote(noteenitiy: noteenitiy)

    @Delete
    fun delete(noteenitiy: noteenitiy)

    @Query("DELETE FROM note")
    fun alldelete()
}
