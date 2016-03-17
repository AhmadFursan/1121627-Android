package com.example.ahmadfursan.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class Main extends AppCompatActivity {
    EditText userNumber;
    int number=generateRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button tryToGuess = (Button)findViewById(R.id.button1);
        final Button generateNew = (Button)findViewById(R.id.button2);
        tryToGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNumber =(EditText)findViewById(R.id.editText1);
                int distance=Integer.parseInt(userNumber.getText().toString());
                if(distance<(number-5)){
                    Toast.makeText(getBaseContext(),"The entered number is smaller",Toast.LENGTH_LONG).show();
                }
                else if(distance>(number+5)){
                    Toast.makeText(getBaseContext(),"The entered number is greater",Toast.LENGTH_LONG).show();
                }
                else if(distance<number||distance>number){
                    Toast.makeText(getBaseContext(),"The entered number is very close!",Toast.LENGTH_LONG).show();
                }
                else if(distance==number){
                    Toast.makeText(getBaseContext(),"You got it ;)",Toast.LENGTH_LONG).show();
                }
            }
        });
        generateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=generateRandom();
            }
        });
    }
    public int generateRandom(){
        Random r = new Random();
        int number = r.nextInt(1000)+0;
        return number;
    }
}
