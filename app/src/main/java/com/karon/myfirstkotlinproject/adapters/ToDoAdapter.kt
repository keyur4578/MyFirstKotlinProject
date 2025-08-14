package com.karon.myfirstkotlinproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.karon.myfirstkotlinproject.R
import com.karon.myfirstkotlinproject.models.ToDo
import org.w3c.dom.Text

class ToDoAdapter(private val context:Context,private val todoList:List<ToDo>):BaseAdapter() {
    override fun getCount(): Int {
        return todoList.size
    }

    override fun getItem(p0: Int): Any {
        return todoList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if(view == null)
        {
            view  = LayoutInflater.from(context).inflate(R.layout.single_todo,p2,false)
        }
        val todo = todoList[position]

        val tvTitle = view!!.findViewById<TextView>(R.id.tvTitle)
        val tvStatus = view!!.findViewById<TextView>(R.id.tvStatus)

        tvTitle.text = todo.title.toString()
        tvStatus.text = todo.completed.toString()

        return view
    }
}