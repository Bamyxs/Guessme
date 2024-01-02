package com.example.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



 import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

        private TextView resultTextView;
        private EditText guessEditText;
        private View colorView;
        private String[] colorNames = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple", "Pink"};
        private String correctColorName;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            resultTextView = findViewById(R.id.resultTextView);
            guessEditText = findViewById(R.id.guessEditText);
            colorView = findViewById(R.id.colorView);

            playGame();

            Button submitButton = findViewById(R.id.submitButton);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkGuess();
                }
            });

            Button newGameButton = findViewById(R.id.newGameButton);
            newGameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playGame();
                }
            });
        }

        private void playGame() {
            Random random = new Random();
            int randomColor = random.nextInt(colorNames.length);
            correctColorName = colorNames[randomColor];

            int randomColorValue = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            colorView.setBackgroundColor(randomColorValue);
        }

        private void checkGuess() {
            String userGuess = guessEditText.getText().toString().trim();
            if (!userGuess.isEmpty()) {
                if (userGuess.equalsIgnoreCase(correctColorName)) {
                    resultTextView.setText("Correct!");
                    Toast.makeText(MainActivity.this, "CONGRATULATIONS!", Toast.LENGTH_SHORT).show();
                } else {
                    resultTextView.setText("Incorrect. Try again.");
                    Toast.makeText(MainActivity.this, "Try again!", Toast.LENGTH_SHORT).show();
                }
            } else {
                resultTextView.setText("Please enter a color name.");
                Toast.makeText(MainActivity.this, "Please enter a color name!", Toast.LENGTH_SHORT).show();
            }
        }
    }

