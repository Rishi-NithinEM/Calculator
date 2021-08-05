package com.example.basiccalculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //    val add: Button = findViewById(R.id.button1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add: Button = findViewById(R.id.button1)
        val sub: Button = findViewById(R.id.button2)
        val mul: Button = findViewById(R.id.button3)
        val div: Button = findViewById(R.id.button4)
        val reset: Button = findViewById(R.id.Reset1)

        reset.isVisible = false
        add.setOnClickListener(this)
        sub.setOnClickListener(this)
        mul.setOnClickListener(this)
        div.setOnClickListener(this)


    }

    override fun onClick(view: View) {

        val intent = Intent(this, GetValues::class.java)
        when (view.id) {
            R.id.button1 -> {

                intent.putExtra("key", "+")

            }
            R.id.button2 -> {
                intent.putExtra("key", "-")

            }
            R.id.button3 -> {

                intent.putExtra("key", "x")

            }
            R.id.button4 -> {

                intent.putExtra("key", "/")

            }
        }
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        val add: Button = findViewById(R.id.button1)
        val sub: Button = findViewById(R.id.button2)
        val mul: Button = findViewById(R.id.button3)
        val div: Button = findViewById(R.id.button4)
        val txt1: TextView = findViewById(R.id.Option)
        val txt2: TextView = findViewById(R.id.Title)
        val out: TextView = findViewById(R.id.outputscreen)
        val reset: Button = findViewById(R.id.Reset1)
        val intent = Intent(this, MainActivity::class.java)

        if(data?.getStringExtra("ans").toString()=="null"){
            val intent = getIntent()
            finish()
            startActivity(intent)
        }

        add.isVisible = false
        sub.isVisible = false
        mul.isVisible = false
        div.isVisible = false
        txt1.isVisible = false
        txt2.isVisible = false
        reset.isVisible = true


        out.text = data?.getStringExtra("ans").toString()

        reset.setOnClickListener {
            startActivity(intent)
        }
//        Toast.makeText(this,string,Toast.LENGTH_LONG).show()

    }
}

