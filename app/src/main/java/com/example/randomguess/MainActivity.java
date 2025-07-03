package com.example.randomguess;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("python3.10");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Welcome to Random Number Game!");
        setContentView(textView);
    }
}
