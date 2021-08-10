package com.example.basiccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class GetValues : AppCompatActivity(), View.OnClickListener {

    var ch: String = ""
    var numb1: Int = 0
    var numb2: Int = 0
    var answer: Int = 0
    var Number1: String = ""
    var Number2: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_values)

        ch = getIntent().getStringExtra("key").toString()

        var sym: TextView = findViewById(R.id.symbol)

        var number1: EditText = findViewById(R.id.num1)
        var number2: EditText = findViewById(R.id.num2)

        Number1 = number1.text.toString()
        Number2 = number2.text.toString()


        when (ch) {
            "+" -> {
                sym.setText("+")
            }
            "-" -> {
                sym.setText("-")
            }
            "x" -> {
                sym.setText("x")
            }
            "/" -> {
                sym.setText("/")
            }
        }
        var result: Button = findViewById(R.id.Result)
        result.setOnClickListener(this)

        var reset: Button = findViewById(R.id.Reset)

        reset.setOnClickListener() {

            Toast.makeText(this, "Working", Toast.LENGTH_LONG).show()
            number1.setText("")
            number2.setText("")

        }


    }

    override fun onClick(view: View) {

        val intent = Intent()

        var number1: EditText = findViewById(R.id.num1)
        var number2: EditText = findViewById(R.id.num2)

        Number1 = number1.text.toString()
        Number2 = number2.text.toString()

        var result: String = ""

        if (Number1 != "" && Number2 != "") {

            numb1 = Number1.toInt()
            numb2 = Number2.toInt()

            result = Number1 + " " + ch + " " + Number2 + " = "
            when (ch) {
                "+" -> {
                    answer = numb1 + numb2
                }
                "-" -> {
                    answer = numb1 - numb2
                }
                "x" -> {
                    answer = numb1 * numb2
                }
                "/" -> {
                    if (numb2 != 0)
                        answer = numb1 / numb2
                    else
                        result = "infinity"
                }
            }

//            Toast.makeText(this, answer.toString(), Toast.LENGTH_LONG).show()
            if (numb2 != 0)
                result += answer.toString()
            intent.putExtra("ans", result)
            setResult(1, intent)

            //  MainActivity().output(result)

            finish()
            //startActivity(intent)


        } else
            Toast.makeText(this, "Please enter values", Toast.LENGTH_LONG).show()


    }
}



