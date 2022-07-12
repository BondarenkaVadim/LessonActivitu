package com.example.lessonactivitu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonactivitu.adapter.DaysOfWeeksAdapter
import com.example.lessonactivitu.model.ItemModel

class MainActivity : AppCompatActivity() {
    val data = listOf(
        ItemModel("Monday", true),
        ItemModel("Tuesday", true),
        ItemModel("Wendsday", false),)

       // "Monday", "Tuesday", "Wendsday", "Thusday", "Friyday", "Saturday", "Sunday")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.list)
        val adapter = DaysOfWeeksAdapter(data)
        list.adapter = adapter
    }
}