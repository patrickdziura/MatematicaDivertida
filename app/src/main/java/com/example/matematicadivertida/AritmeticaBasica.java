package com.example.matematicadivertida;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AritmeticaBasica extends AppCompatActivity {

    int resultado;
    int acertos;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica_basica);
        acertos = 0;
        count = 1;
        geraConta();
    }



    private void geraConta() {
        TextView titulo = (TextView) findViewById(R.id.txtTitulo);
        EditText op1 = (EditText) findViewById(R.id.editOp1);
        EditText op2 = (EditText) findViewById(R.id.editOp2);
        EditText operador = (EditText) findViewById(R.id.editOperador);
        EditText aux = (EditText) findViewById(R.id.editResultado);
        aux.setText("");
        titulo.setText("Pergunta " + String.valueOf(count) + " de 5: ");
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
    }

    public void verificaResultado (View view) {
        EditText result = (EditText) findViewById(R.id.editResultado);
        int intresult = Integer.parseInt(result.getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alert;
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (count >= 5) {
                    criaDialogFinal();
                } else {
                    count++;
                    geraConta();
                }
            }
        });
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

    private void criaDialogFinal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fim!");
        int porcentagem = acertos * 20;
        builder.setMessage("Você acertou " + String.valueOf(porcentagem) + "%.");
        builder.setPositiveButton("Voltar ao menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
