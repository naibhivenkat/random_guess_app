package com.example.randomguess;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.chaquo.python.*;

public class MainActivity extends AppCompatActivity {
    int number = (int) (Math.random() * 100) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Python.start(new AndroidPlatform(this));
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.input);
        Button checkBtn = findViewById(R.id.checkBtn);
        TextView result = findViewById(R.id.result);

        checkBtn.setOnClickListener(v -> {
            String guess = input.getText().toString();
            PyObject res = Python.getInstance()
                                 .getModule("game")
                                 .callAttr("check_guess", guess, number);
            result.setText(res.toString());
        });
    }
}
