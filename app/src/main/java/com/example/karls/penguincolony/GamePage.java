package com.example.karls.penguincolony;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
// test commit

public class GamePage extends AppCompatActivity {

    public int numOfPingus = 20;
    public int food = 5;
    TextView numOfPingusTextView;
    TextView foodTextView;
    Random rand = new Random();

    //Random chanceOfEgg = new Random();
    //int max = 100;
    //int min = 0;
    //int egge = chanceOfEgg.nextInt(max - min) + min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        this.numOfPingusTextView = findViewById(R.id.textView1);
        this.foodTextView = findViewById(R.id.textView2);



        Button button = findViewById(R.id.butHunt);
        Button button2 = findViewById(R.id.butEgg);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (numOfPingus == 0){
                    Toast.makeText(getApplicationContext(),"All your penguins are dead", Toast.LENGTH_LONG).show();//notifies you that all penguins are dead
                    String NewNumOfPengus = "Num of pingus " + numOfPingus;
                    numOfPingusTextView.setText(NewNumOfPengus);
                }
                else {
                    numOfPingus = (numOfPingus - 1);
                    String NewNumOfPengus = "Num of pingus " + numOfPingus;
                    numOfPingusTextView.setText(NewNumOfPengus);
                    food = food + rand.nextInt(3 + 1);
                    String foodGain = "Food: " + food;
                    foodTextView.setText(foodGain);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (food == 0){
                    String noFood = "No food " + food;
                    foodTextView.setText(noFood);
                }
                else {
                    if (food >= 5) {
                        food = food - 5;
                        String foodLoss = "Food: " + food;
                        foodTextView.setText(foodLoss);

                        numOfPingus = numOfPingus + rand.nextInt(1 + 1);
                        String NewNumOfPengus = "Num of pingus " + numOfPingus;
                        numOfPingusTextView.setText(NewNumOfPengus);
                        //numOfPingus = chanceOfEgg.nextInt(max - min) + min;                           //Karl's chance of egg code does not work
                        //if (numOfPingus <= 20) {
                        //    numOfPingus = numOfPingus + 1;
                        //}
                        //numOfPingusTextView.setText("Num of pingus: " + numOfPingus);
                    }
                    else {
                        food = 0;
                        String foodGain = "Food " + food;
                        foodTextView.setText(foodGain);
                        numOfPingus = numOfPingus + rand.nextInt(1 + 1);
                        //numOfPingus = chanceOfEgg.nextInt(max - min) + min;
                        //if (numOfPingus <= 20) {
                        //    numOfPingus = numOfPingus + 1;
                        //}
                        String NewNumOfPengus = "Num of pingus " + numOfPingus;
                        numOfPingusTextView.setText(NewNumOfPengus);
                    }
                }
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


//
//mark//
Toast.makeText(getApplicationContext(),"This is my toast message",Toast.LENGTH_LONG).show(); Comment
////
 */


