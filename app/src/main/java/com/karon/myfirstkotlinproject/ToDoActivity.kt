package com.karon.myfirstkotlinproject

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.karon.myfirstkotlinproject.adapters.ToDoAdapter
import com.karon.myfirstkotlinproject.models.ToDo

class ToDoActivity : AppCompatActivity() {


    private lateinit var listView:ListView
    private val todoList = ArrayList<ToDo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_to_do)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById<ListView>(R.id.listView)

        getdata()
    }

    private fun getdata()
    {
        val url = "https://jsonplaceholder.typicode.com/todos"
        val queue = Volley.newRequestQueue(this)

        val jsonArrayReuqest = JsonArrayRequest(
            Request.Method.GET,url,null,
            {
                response->
                    for(i in 0 until response.length()){
                        val obj = response.getJSONObject(i)

                        val userId = obj.getLong("userId")
                        val id = obj.getLong("id")
                        val title = obj.getString("title")
                        val completed = obj.getBoolean("completed")

                        todoList.add(ToDo(userId,id,title,completed))
                    }

                val adapter = ToDoAdapter(this,todoList)
                listView.adapter = adapter
            },
            {
                error->
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
        )

        queue.add(jsonArrayReuqest)
    }
}