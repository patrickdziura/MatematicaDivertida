package com.example.matematicadivertida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAritmetica(View view) {
        Intent it = new Intent(this, AritmeticaBasica.class);
        startActivity(it);
    }

    public void goMaiorNumero(View view) {
        Intent it = new Intent(this, MaiorNumero.class);
        startActivity(it);
    }
}
