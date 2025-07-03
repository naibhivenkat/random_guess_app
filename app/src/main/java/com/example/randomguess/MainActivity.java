package com.example.randomguess;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random;
    private int numberToGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        numberToGuess = random.nextInt(10) + 1;

        EditText guessInput = findViewById(R.id.guessInput);
        Button submitBtn = findViewById(R.id.submitBtn);
        TextView resultText = findViewById(R.id.resultText);

        submitBtn.setOnClickListener(v -> {
            String input = guessInput.getText().toString();
            if (input.isEmpty()) {
                resultText.setText("Please enter a number!");
                return;
            }

            int guess = Integer.parseInt(input);
            if (guess == numberToGuess) {
                resultText.setText("🎉 Correct! You guessed it.");
            } else {
                resultText.setText("❌ Wrong! Try again.");
            }
        });
    }
}
