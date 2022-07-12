package com.example.lessonactivitu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lessonactivitu.R
import com.example.lessonactivitu.model.ItemModel
import kotlinx.android.synthetic.main.ithem_first.view.*
import kotlinx.android.synthetic.main.ithem_second.view.*
import java.lang.RuntimeException

class DaysOfWeeksAdapter(private val daysOfWeek: List<ItemModel>) :
    RecyclerView.Adapter<ViewHolder>() {  // список наших ячеек (один элемент одна ячейка (кнопка или textView))

    class DaysOfWeekViewHolder(layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    class ButtonViewHolder(layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

    override fun getItemViewType(position: Int): Int {
        return if (daysOfWeek[position].isButton) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0 -> {
                val ithemList = LayoutInflater.from(parent.context)
                    .inflate(R.layout.ithem_second, parent, false) as ConstraintLayout
                ButtonViewHolder(ithemList)
            }
            1 -> {
                val ithemList = LayoutInflater.from(parent.context)
                    .inflate(R.layout.ithem_first, parent, false) as ConstraintLayout
                DaysOfWeekViewHolder(ithemList)
            }
            else -> {
                throw  RuntimeException("Unknown viewTyper")
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DaysOfWeekViewHolder -> {
                holder.itemView.textView.text = daysOfWeek[position].text
            }
            is ButtonViewHolder -> {
                holder.itemView.itemButton.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context,
                        daysOfWeek[position].text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun getItemCount() = daysOfWeek.size
}
