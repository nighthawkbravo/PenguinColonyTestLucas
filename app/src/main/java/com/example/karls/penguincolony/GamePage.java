package com.example.karls.penguincolony;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

//Old code that works
public class GamePage extends AppCompatActivity {


    //Initalize Class

    private Handler handler = new Handler();
    private Timer timer = new Timer();


    ColonyData SaharaLib = new ColonyData();

    TextView numOfZebrasTextView;
    TextView foodTextView;
    TextView dayCount;
    Random rand = new Random();


    //dialog
    public void showDialog() {
        int mStackLevel = 1;
        mStackLevel++;

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = MyDialogFragment.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
    }

    public void endGame() {
        if (SaharaLib.getNumOfZebras() == 0 && SaharaLib.getFood() == 0) {
            showDialog();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        this.dayCount = findViewById(R.id.dayTextView);
        this.numOfZebrasTextView = findViewById(R.id.textView1);
        this.foodTextView = findViewById(R.id.textView2);


        Button button = findViewById(R.id.butHunt);
        Button button2 = findViewById(R.id.butEgg);

        //Graze Button
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //checks penguin count

                endGame();


                if (SaharaLib.getNumOfZebras() == 0) {
                    //if all Zebras are dead, then toast message


                    //Toast.makeText(getApplicationContext(),"All your penguins are dead", Toast.LENGTH_LONG).show();
                    numOfZebrasTextView.setText("Zebras: " + SaharaLib.getNumOfZebras());
                } else {
                    //or... decrease Zebra count by 0 or 1
                    SaharaLib.setNumOfAnimals(SaharaLib.getNumOfZebras() - rand.nextInt(2));
                    String NewNumOfPengus = "Zebras: " + SaharaLib.getNumOfZebras();
                    numOfZebrasTextView.setText(NewNumOfPengus);

                    //this adds a day to the counter
                    SaharaLib.setDay(SaharaLib.getDay() + 1);

                    //Every five days, all Zebras eat, extra Zebras with no food die if they don't eat.
                    /*
                    if (SaharaLib.getDay() % 20 == 0) {
                        if (SaharaLib.getFood() < SaharaLib.getNumOfZebras()) {
                            SaharaLib.setNumOfAnimals(SaharaLib.getNumOfZebras() - (SaharaLib.getNumOfZebras() - SaharaLib.getFood()));
                            SaharaLib.setNumOfAnimals(0);
                        } else {
                            SaharaLib.setFood(SaharaLib.getFood() - SaharaLib.getNumOfZebras());
                        }
                    }
                    */
                    String daySetText = "Day: " + SaharaLib.getDay();
                    dayCount.setText(daySetText);

                    //adds random food from 0 or 3
                    SaharaLib.setFood(SaharaLib.getFood() + 3*rand.nextInt(2));
                    String foodGain = "Grass: " + SaharaLib.getFood();
                    foodTextView.setText(foodGain);
                }
            }
        });

        //Reproduce button
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                endGame();

                // grass is used to make a Zebra. Zero grass = no new Zebras
                if (SaharaLib.getFood() < 3) {
                    String noFood = "Grass: " + SaharaLib.getFood();
                    foodTextView.setText(noFood);
                    //Toast.makeText(getApplicationContext(),"Out Of Food", Toast.LENGTH_LONG).show();//notifies you that food is gone
                }

                // This will add 0 or 1 Zebra at the cost of 3 food

                if (SaharaLib.getFood() > 2) {
                    SaharaLib.setFood(SaharaLib.getFood() - 3);
                    String foodLoss = "Grass: " + SaharaLib.getFood();
                    foodTextView.setText(foodLoss);
                    SaharaLib.setNumOfAnimals(SaharaLib.getNumOfZebras() + rand.nextInt(2));
                    String NewNumOfZebras = "Zebras: " + SaharaLib.getNumOfZebras();
                    numOfZebrasTextView.setText(NewNumOfZebras);
                }
            }
        });

    }
}
