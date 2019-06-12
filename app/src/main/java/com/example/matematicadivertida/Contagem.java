package com.example.matematicadivertida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Contagem extends AppCompatActivity {

    TextView titleTextView;
    ImageView randomImageView;
    Button firstButton,secondButton,thirdButton;

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

        generateAll(new View(this));

    }

    public void generateAll(View view){

        int number = generateRandomImage(new View(this));
        number++;
        generateNumbers(new View(this),number);
    }

    public int generateRandomImage(View view) {

        Random random = new Random();
        int number = random.nextInt(10);
        randomImageView.setImageResource(images[number]);

        return number;

    }

    public void generateNumbers(View view, int number) {

        Random random = new Random();
        int buttonumber = random.nextInt(3);
        int[] buttonumberarray = {0,0,0};

        buttonumberarray[buttonumber] = number;

        firstButton.setText(Integer.toString(buttonumberarray[0]));
        secondButton.setText(Integer.toString(buttonumberarray[1]));
        thirdButton.setText(Integer.toString(buttonumberarray[2]));

    }

    public boolean checkAnswer() {

        return false;
    }
}
