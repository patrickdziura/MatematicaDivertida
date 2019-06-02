package com.example.matematicadivertida;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MaiorNumero extends AppCompatActivity {

    int acertos;
    int count;
    int maiornumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maior_numero);
        count = 1;
        acertos = 0;
        geraProblema();
    }

    private void geraProblema() {
        int m1 = 0, m2 = 0, m3 = 0;
        EditText num1 = (EditText) findViewById(R.id.editNum1);
        EditText num2 = (EditText) findViewById(R.id.editNum2);
        EditText num3 = (EditText) findViewById(R.id.editNum3);
        EditText maiornum = (EditText) findViewById(R.id.editResultado);
        TextView titulo = (TextView) findViewById(R.id.txtTitulo);
        titulo.setText("Pergunta " + String.valueOf(count) + " de 5: ");
        maiornum.setText("");
        Random r = new Random();
        int n1 = r.nextInt(10);
        int n2 = r.nextInt(10);
        int n3 = r.nextInt(10);
        num1.setText(Integer.toString(n1));
        num2.setText(Integer.toString(n2));
        num3.setText(Integer.toString(n3));
        if (n1 >= n2 && n1 >= n3) {
            m1 = n1;
            if (n2 >= n3) {
                m2 = n2;
                m3 = n3;
            } else {
                m2 = n3;
                m3 = n2;
            }
        } else if (n2 >= n1 && n2 >= n3) {
            m1 = n2;
            if (n1 >= n3) {
                m2 = n1;
                m3 = n3;
            } else {
                m2 = n3;
                m3 = n1;
            }
        } else if (n3 >= n1 && n3 >= n2) {
            m1 = n3;
            if (n1 >= n2) {
                m2 = n1;
                m3 = n2;
            } else {
                m2 = n2;
                m3 = n1;
            }
        }
        maiornumero = (100 * m1) + (10 * m2) + m3;
    }

    public void verificaMaior(View view) {
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
                    geraProblema();
                }
            }
        });
        if (intresult == maiornumero) {
            builder.setTitle("Resultado Correto");
            builder.setMessage("O resultado está correto!");
            alert = builder.create();
            alert.show();
            acertos++;
            //new AlertDialog.Builder(this).setTitle("Resultado Correto").setMessage("O resultado está correto!");
        } else {
            builder.setTitle("Resultado Errado");
            builder.setMessage("O resultado correto é: " + String.valueOf(maiornumero));
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
