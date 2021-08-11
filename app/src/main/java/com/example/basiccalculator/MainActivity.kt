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
    lateinit var add: Button
    lateinit var sub: Button
    lateinit var mul: Button
    lateinit var div: Button
    lateinit var reset: Button
    lateinit var out: TextView
    lateinit var result: String
    lateinit var txt1: TextView
    lateinit var txt2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add = findViewById(R.id.button1)
        sub = findViewById(R.id.button2)
        mul = findViewById(R.id.button3)
        div = findViewById(R.id.button4)
        reset = findViewById(R.id.Reset1)
        out = findViewById(R.id.outputscreen)
        txt1 = findViewById(R.id.Option)
        txt2 = findViewById(R.id.Title)
        result = "z"

        reset.isVisible = false
        out.isVisible = false
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


            if (result != "null" && result != "z") {
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


                    add.isVisible = true
                    sub.isVisible = true
                    mul.isVisible = true
                    div.isVisible = true
                    txt1.isVisible = true
                    txt2.isVisible = true
                    reset.isVisible = false
                    out.isVisible = false


                }
            } else {

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

    override fun onBackPressed() {
        super.onBackPressed()

        val add: Button = findViewById(R.id.button1)

        if (add.isVisible == false) {
            val intent = intent
            finish()
            startActivity(intent)
        }

    }

}

