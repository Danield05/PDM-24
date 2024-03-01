package com.example.ac21051_01b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaracion de variables
       val lblResult: TextView = findViewById(R.id.textView);
        val btnSum: Button = findViewById(R.id.button);
        val btnRes: Button = findViewById(R.id.button2);
        val btnMul: Button = findViewById(R.id.button3);
        val editText:EditText= findViewById(R.id.editTextNumber);
        val editText2:EditText= findViewById(R.id.editTextNumber2);
        val editText3:EditText= findViewById(R.id.editTextNumber3)


        //Definicion de eventos click de los Botones
        btnSum.setOnClickListener {
            val num1=editText.text.toString().toIntOrNull()?:0;
            val num2=editText2.text.toString().toIntOrNull()?:0;
            val num3=editText3.text.toString().toIntOrNull()?:0;
            val num4=num1+num2+num3;
            lblResult.setText("La suma es: $num4 ")
        }
        btnRes.setOnClickListener {
            val num1=editText.text.toString().toIntOrNull()?:0;
            val num2=editText2.text.toString().toIntOrNull()?:0;
            val num3=editText3.text.toString().toIntOrNull()?:0;
            val num4=when{
                num1!=null->{
                    num1-(num2 ?:0)-(num3 ?:0)
                }
                num2!=null->{
                    num2-(num3 ?:0)
                }
                else->{
                    num3 ?:0
                }
            }
            lblResult.setText("La resta es: $num4 ")
        }
        btnMul.setOnClickListener {
            val num1=editText.text.toString().toIntOrNull()?:0;
            val num2=editText2.text.toString().toIntOrNull()?:0;
            val num3=editText3.text.toString().toIntOrNull()?:0;
            val num4=num1*num2*num3;
            lblResult.setText("La multiplicacion es: $num4 ")
        }

    }
}
