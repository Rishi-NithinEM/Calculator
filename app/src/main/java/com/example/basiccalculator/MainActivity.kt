package com.example.basiccalculator

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //    val add: Button = findViewById(R.id.button1)
    var result: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add: Button = findViewById(R.id.button1)
        val sub: Button = findViewById(R.id.button2)
        val mul: Button = findViewById(R.id.button3)
        val div: Button = findViewById(R.id.button4)
        val reset: Button = findViewById(R.id.Reset1)
        val out: TextView = findViewById(R.id.outputscreen)

        reset.isVisible = false
        out.isVisible=false
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

    override fun onBackPressed() {
        super.onBackPressed()

        val reset: Button = findViewById(R.id.Reset1)

        if (reset.isVisible == true) {
            recreate()
        }
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

        result = data?.getStringExtra("ans").toString()
        if (result == "null") {
            recreate()
        }

        add.isVisible = false
        sub.isVisible = false
        mul.isVisible = false
        div.isVisible = false
        txt1.isVisible = false
        txt2.isVisible = false
        reset.isVisible = true
        out.isVisible = true

        out.text = result

        reset.setOnClickListener {

            val add: Button = findViewById(R.id.button1)
            val sub: Button = findViewById(R.id.button2)
            val mul: Button = findViewById(R.id.button3)
            val div: Button = findViewById(R.id.button4)
            val txt1: TextView = findViewById(R.id.Option)
            val txt2: TextView = findViewById(R.id.Title)
            val out: TextView = findViewById(R.id.outputscreen)
            val reset: Button = findViewById(R.id.Reset1)

            add.isVisible = true
            sub.isVisible = true
            mul.isVisible = true
            div.isVisible = true
            txt1.isVisible = true
            txt2.isVisible = true
            reset.isVisible = false
            out.isVisible = false


//            recreate()
        }
//        Toast.makeText(this,string,Toast.LENGTH_LONG).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val out: TextView = findViewById(R.id.outputscreen)
        if (out.isVisible == true)
            outState.putString("out", result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)


        if (savedInstanceState != null) {
            result = savedInstanceState.getString("out", "null")

            val add: Button = findViewById(R.id.button1)
            val sub: Button = findViewById(R.id.button2)
            val mul: Button = findViewById(R.id.button3)
            val div: Button = findViewById(R.id.button4)
            val txt1: TextView = findViewById(R.id.Option)
            val txt2: TextView = findViewById(R.id.Title)
            val out: TextView = findViewById(R.id.outputscreen)
            val reset: Button = findViewById(R.id.Reset1)

            if (result != "null" && result != "z") {
                add.isVisible = false
                sub.isVisible = false
                mul.isVisible = false
                div.isVisible = false
                txt1.isVisible = false
                txt2.isVisible = false
                reset.isVisible = true
                out.isVisible = true

                out.text=result

                reset.setOnClickListener {

                    val add: Button = findViewById(R.id.button1)
                    val sub: Button = findViewById(R.id.button2)
                    val mul: Button = findViewById(R.id.button3)
                    val div: Button = findViewById(R.id.button4)
                    val txt1: TextView = findViewById(R.id.Option)
                    val txt2: TextView = findViewById(R.id.Title)
                    val out: TextView = findViewById(R.id.outputscreen)
                    val reset: Button = findViewById(R.id.Reset1)

                    add.isVisible = true
                    sub.isVisible = true
                    mul.isVisible = true
                    div.isVisible = true
                    txt1.isVisible = true
                    txt2.isVisible = true
                    reset.isVisible = false
                    out.isVisible = false


                }
            }

            else{
                val add: Button = findViewById(R.id.button1)
                val sub: Button = findViewById(R.id.button2)
                val mul: Button = findViewById(R.id.button3)
                val div: Button = findViewById(R.id.button4)
                val txt1: TextView = findViewById(R.id.Option)
                val txt2: TextView = findViewById(R.id.Title)
                val out: TextView = findViewById(R.id.outputscreen)
                val reset: Button = findViewById(R.id.Reset1)

                add.isVisible = true
                sub.isVisible = true
                mul.isVisible = true
                div.isVisible = true
                txt1.isVisible = true
                txt2.isVisible = true
                reset.isVisible = false
                out.isVisible = false
            }
        }
    }



}

