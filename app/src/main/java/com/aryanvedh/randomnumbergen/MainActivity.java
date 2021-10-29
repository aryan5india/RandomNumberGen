package com.aryanvedh.randomnumbergen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    Random randomGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(21);
    }


    public void guess(View view){

        EditText guessedNumber = findViewById(R.id.editTextGuss);
        int guessedNUmberInt = Integer.parseInt(guessedNumber.getText().toString());
        String message ="";
        if (guessedNUmberInt > randomNumber){
            message = "Too High";
        } else if (guessedNUmberInt < randomNumber){
            message = "Too Low";
        } else {
            message ="Correct! Well done, Lets play agian!";
            guessedNumber.setText("");
            randomNumber = randomGenerator.nextInt(21);
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        Log.i(String.valueOf(guessedNUmberInt), message);

    }
}