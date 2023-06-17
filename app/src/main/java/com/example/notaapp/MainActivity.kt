package com.example.notaapp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notaapp.Database.RoomDB
import com.example.notaapp.Enitiy.noteenitiy
import com.example.notaapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var db: RoomDB

    lateinit var binding: ActivityMainBinding

    lateinit var adapter: noteAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        db = RoomDB.init(this)
        binding.btnsave.setOnClickListener {

            var txt = binding.edtext.text.toString()
            var title = binding.edtitle.text.toString()
            var format = SimpleDateFormat("dd/MM/yyyy")
            var current = format.format(Date())

            if (txt.isEmpty() || title.isEmpty()) {
                Toast.makeText(this, "Enter the title ", Toast.LENGTH_SHORT).show()
            } else {
                var model = noteenitiy(txt, title, current)
                db.note().addnote(model)

                adapter.updata(db.note().getnote())

                binding.edtext.setText("")
                binding.edtitle.setText("")
            }
        }
        adapter = noteAdapter(db.note().getnote())
        binding.rcv.layoutManager = GridLayoutManager(this,2)
        binding.rcv.adapter = adapter

    }
}