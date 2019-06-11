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
    Button firstButton,secondButton, thirdButton;

    Integer[] imageId = {
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

        View view = null;
        generateRandomImage(view);

    }

    public void generateRandomImage(View view) {

        Random random = new Random();
        int number = random.nextInt(10);
        randomImageView.setImageResource(imageId[number]);

    }

    public boolean checkAnswer() {

        return false;
    }
}
