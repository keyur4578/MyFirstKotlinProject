package com.karon.myfirstkotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


//    Int x = 10;


    val x:Int = 10
    val y:Int = 20
    var btnSubmit:Button? = null

    var edt1:EditText? = null
    var edt2:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnSubmit = findViewById<Button>(R.id.btnSubmit)
        edt1 = findViewById<EditText>(R.id.edt1)
        edt2 = findViewById<EditText>(R.id.edt2)

        btnSubmit?.setOnClickListener {

            var intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivity(intent)

         //   var n1:Int = Integer.parseInt(edt1?.getText().toString())
          //  var n2:Int = Integer.parseInt(edt2?.getText().toString())

          //  var total:Int = calculate(n1,n2)


            //var total:Int = x + y
          //  Toast.makeText(this@MainActivity,"Total = " + total,Toast.LENGTH_LONG).show()
        }
    }

    fun calculate(x:Int,y:Int):Int
    {
        var total:Int = x + y
        return total
    }


}