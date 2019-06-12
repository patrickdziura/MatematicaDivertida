package com.example.matematicadivertida;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Contagem extends AppCompatActivity {

    TextView titleTextView;
    ImageView randomImageView;
    Button firstButton,secondButton,thirdButton;
    int rightanswer;
    int success;
    int count;
    ArrayList<Integer> doneimages = new ArrayList<Integer>();
    int pos = 0;

    Integer[] images = {
            R.drawable.one_image,
            R.drawable.two_image,
            R.drawable.three_image,
            R.drawable.four_image,
            R.drawable.five_image,
            R.drawable.six_image,
            R.drawable.seven_image,
            R.drawable.eigth_image,
            R.drawable.nine_image,
            R.drawable.ten_image
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);

        titleTextView = findViewById(R.id.titleTextView);
        randomImageView = findViewById(R.id.randomImageView);
        firstButton = findViewById(R.id.firstButton);
        secondButton = findViewById(R.id.secondButton);
        thirdButton = findViewById(R.id.thirdButton);

        rightanswer = generateAll();

    }

    public int generateAll(){

        int number = generateRandomImage(new View(this));
        number++;
        generateNumbers(new View(this),number);
        return number;

    }

    public int generateRandomImage(View view) {

        Random random = new Random();
        int number = random.nextInt(10);

        while (doneimages.contains(number)) {
            number = random.nextInt(10);
        }

        doneimages.add(pos,number);;
        pos++;

        randomImageView.setImageResource(images[number]);

        return number;

    }

    public void generateNumbers(View view, int number) {

        Random random = new Random();
        int buttonumber = random.nextInt(3);
        int[] buttonumberarray = {0,0,0};

        buttonumberarray[buttonumber] = number; //número correto

        int anotherbuttonnumber = random.nextInt(10);

        while (anotherbuttonnumber == buttonumberarray[buttonumber]) {
            anotherbuttonnumber = random.nextInt(10);
        }

        int position = random.nextInt(3);
        while(position == buttonumber){
            position = random.nextInt(3);
        }

        buttonumberarray[position] = anotherbuttonnumber;

        anotherbuttonnumber = random.nextInt(10);

        while (anotherbuttonnumber == buttonumberarray[buttonumber]) {
            anotherbuttonnumber = random.nextInt(10);
        }

        position = random.nextInt(3);
        while(position == buttonumber){
            position = random.nextInt(3);
        }

        buttonumberarray[position] = anotherbuttonnumber;

        firstButton.setText(Integer.toString(buttonumberarray[0]));
        secondButton.setText(Integer.toString(buttonumberarray[1]));
        thirdButton.setText(Integer.toString(buttonumberarray[2]));

    }

    public boolean checkAnswerFirst() {
        int answer = Integer.parseInt(firstButton.getText().toString());
        if(answer == rightanswer){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkAnswerSecond() {
        int answer = Integer.parseInt(secondButton.getText().toString());
        if(answer == rightanswer){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkAnswerThird() {
        int answer = Integer.parseInt(thirdButton.getText().toString());
        if(answer == rightanswer){
            return true;
        }else{
            return false;
        }
    }

    public void firstClick(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alert;
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (count >= 4) {
                    criaDialogFinal();
                } else {
                    count++;
                    rightanswer = generateAll();
                }
            }
        });
        if (checkAnswerFirst()) {
            builder.setTitle("Resultado Correto");
            builder.setMessage("O resultado está correto!");
            alert = builder.create();
            alert.show();
            success++;
            //new AlertDialog.Builder(this).setTitle("Resultado Correto").setMessage("O resultado está correto!");
        } else {
            builder.setTitle("Resultado Errado");
            builder.setMessage("O resultado correto é: " + String.valueOf(rightanswer));
            alert = builder.create();
            alert.show();
        }

    }

    public void secondClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alert;
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (count >= 4) {
                    criaDialogFinal();
                } else {
                    count++;
                    rightanswer = generateAll();
                }
            }
        });
        if (checkAnswerSecond()) {
            builder.setTitle("Resultado Correto");
            builder.setMessage("O resultado está correto!");
            alert = builder.create();
            alert.show();
            success++;
            //new AlertDialog.Builder(this).setTitle("Resultado Correto").setMessage("O resultado está correto!");
        } else {
            builder.setTitle("Resultado Errado");
            builder.setMessage("O resultado correto é: " + String.valueOf(rightanswer));
            alert = builder.create();
            alert.show();
        }
    }

    public void thirdClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alert;
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (count >= 4) {
                    criaDialogFinal();
                } else {
                    count++;
                    rightanswer = generateAll();
                }
            }
        });
        if (checkAnswerThird()) {
            builder.setTitle("Resultado Correto");
            builder.setMessage("O resultado está correto!");
            alert = builder.create();
            alert.show();
            success++;
            //new AlertDialog.Builder(this).setTitle("Resultado Correto").setMessage("O resultado está correto!");
        } else {
            builder.setTitle("Resultado Errado");
            builder.setMessage("O resultado correto é: " + String.valueOf(rightanswer));
            alert = builder.create();
            alert.show();
        }
    }

    private void criaDialogFinal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("final de jogo!");
        int nota = success * 20;
        builder.setMessage("sua nota é de: " + String.valueOf(nota) + " pontos!");
        builder.setPositiveButton("voltar ao menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
