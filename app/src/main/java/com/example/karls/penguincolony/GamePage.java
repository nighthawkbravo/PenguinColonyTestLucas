package com.example.karls.penguincolony;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class GamePage extends AppCompatActivity {
//
//    TextView numOfPenguinsTextView;
//    Button huntButton;

    public int numOfPingus = 20;
    TextView numOfPingusTextView = findViewById(R.id.textView1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);


        Button button = findViewById(R.id.butHunt);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // hunt function
            }
        });
    }
}

//        numOfPenguinsTextView= findViewById(R.id.textView1);
//        huntButton = findViewById(R.id.butHunt);
//        numOfPenguinsTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                numOfPenguinsTextView.setText("Test");
//            }
//        });


/*int battlePingus = 0; //Has to reset the BattlePingu count everytime the method is called
                battlePingus = 2;
                Random chanceOfBeingHit = new Random();
                int max = 100;
                int min = 0;
                int variable = chanceOfBeingHit.nextInt(max - min) + min;
                numOfPingus = numOfPingus - 2;


                if (numOfPingus <= 2) {
                } else {
                    if (variable <= 20) {
                        battlePingus = battlePingus - 1;
                    }
                    variable = chanceOfBeingHit.nextInt(max - min) + min;
                    if (variable <= 20) {
                        battlePingus = battlePingus - 1;
                    }
                }
                numOfPingus = numOfPingus + battlePingus;


                String theIntString = Integer.toString(numOfPingus);

                numOfPingusTextView.setText(theIntString + "Pingus");


 */


