package com.example.matematicadivertida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Random;

public class AritmeticaBasica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica_basica);
        geraConta();
    }

    private void geraConta() {
        EditText op1 = (EditText) findViewById(R.id.editOp1);
        EditText op2 = (EditText) findViewById(R.id.editOp2);
        EditText operador = (EditText) findViewById(R.id.editOperador);
        Random r = new Random();
        int operando1 = r.nextInt(10);
        int operando2 = r.nextInt(10);
        int opaux = r.nextInt(2);
        op1.setText(Integer.toString(operando1));
        op2.setText(Integer.toString(operando2));
        if (opaux == 0) {
            operador.setText("+");
        } else {
            operador.setText("-");
        }
    }
}
