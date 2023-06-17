package com.example.notaapp.Enitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class noteenitiy(
    @ColumnInfo(name = "title") var title :String,
    @ColumnInfo(name = "text") var text :String,
    @ColumnInfo(name = "date") var date :String

)
{
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
