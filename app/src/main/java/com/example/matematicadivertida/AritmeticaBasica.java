package com.example.matematicadivertida;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class AritmeticaBasica extends AppCompatActivity {

    int resultado;
    int acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica_basica);
        acertos = 0;
        int i;
        for(i=0; i< 5; i++) {
            geraConta();
        }
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
            resultado = operando1 + operando2;
        } else {
            operador.setText("-");
            resultado = operando1 - operando2;
        }
        System.out.println(resultado);
    }

    public void verificaResultado (View view) {
        EditText result = (EditText) findViewById(R.id.editResultado);
        int intresult = Integer.parseInt(result.getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alert;
        builder.setPositiveButton("OK",null);
        if (intresult == resultado) {
            builder.setTitle("Resultado Correto");
            builder.setMessage("O resultado está correto!");
            alert = builder.create();
            alert.show();
            acertos++;
            //new AlertDialog.Builder(this).setTitle("Resultado Correto").setMessage("O resultado está correto!");
        } else {
            builder.setTitle("Resultado Errado");
            builder.setMessage("O resultado correto é: " + String.valueOf(resultado));
            alert = builder.create();
            alert.show();
        }
    }
}
