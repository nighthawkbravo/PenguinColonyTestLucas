package com.example.karls.penguincolony;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GamePage extends AppCompatActivity {

    TextView numOfPenguinsTextView;
    Button huntButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        numOfPenguinsTextView= findViewById(R.id.textView1);
        huntButton = findViewById(R.id.butHunt);
        numOfPenguinsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfPenguinsTextView.setText("Test");
            }
        });

    }
    }


