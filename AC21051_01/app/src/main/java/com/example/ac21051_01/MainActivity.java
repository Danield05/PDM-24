package com.example.ac21051_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
Button btnEjecutarMetodo1, btnEjecutarMetodo2, btnEjecutarMetodo3;
TextView lblEtiqueta;
EditText edtParametro1, edtParametro2, edtParametro3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEjecutarMetodo1 = (Button) findViewById(R.id.button);
        btnEjecutarMetodo1.setOnClickListener(onclick);
        btnEjecutarMetodo2 = (Button) findViewById(R.id.button2);
        btnEjecutarMetodo2.setOnClickListener(onclick);
        btnEjecutarMetodo3 = (Button) findViewById(R.id.button3);
        btnEjecutarMetodo3.setOnClickListener(onclick);
       lblEtiqueta = (TextView) findViewById(R.id.textView);
        edtParametro1 = (EditText) findViewById(R.id.editTextNumber);
        edtParametro2 = (EditText) findViewById(R.id.editTextNumber2);
        edtParametro3 = (EditText) findViewById(R.id.editTextNumber3);

    }

    View.OnClickListener onclick= new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            float numfloat1, numfloat2, numfloat3;
            if (v.getId() == R.id.button) {
                numfloat1 = (float) Float.valueOf(edtParametro1.getText().toString());
                numfloat2 = (float) Float.valueOf(edtParametro2.getText().toString());
                numfloat3 = (float) Float.valueOf(edtParametro3.getText().toString());
                String sumastr = Metodos.suma(numfloat1, numfloat2, numfloat3);
                lblEtiqueta.setText(sumastr);
            }
            if (v.getId() == R.id.button2) {
                numfloat1 = (float) Float.valueOf(edtParametro1.getText().toString());
                numfloat2 = (float) Float.valueOf(edtParametro2.getText().toString());
                numfloat3 = (float) Float.valueOf(edtParametro3.getText().toString());
                String restastr = Metodos.resta(numfloat1, numfloat2, numfloat3);
                lblEtiqueta.setText(restastr);
            }
            if (v.getId() == R.id.button3) {
                numfloat1 = (int) Integer.valueOf(edtParametro1.getText().toString());
                numfloat2 = (int) Integer.valueOf(edtParametro2.getText().toString());
                numfloat3 = (int) Integer.valueOf(edtParametro3.getText().toString());
                String multstr = Metodos.mult(numfloat1, numfloat2, numfloat3);
                lblEtiqueta.setText(multstr);
            }
        }
    };
}