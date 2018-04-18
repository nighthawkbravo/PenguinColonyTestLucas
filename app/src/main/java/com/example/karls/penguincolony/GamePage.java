package com.example.karls.penguincolony;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

//Old code that works
public class GamePage extends AppCompatActivity {

    //Screen size

    private double screenWidth;
    private double screenHieght;

    //Image

    private ImageView penguinImage;

    //Position

    private double penguinUpX;
    private double penguinUpY;
    private float penguinDownX;
    private float penguinDownY;
    private float penguinLeftX;
    private float penguinLeftY;
    private float penguinRightX;
    private float penuinRightY;

    //Initalize Class

    private Handler handler = new Handler();
    private Timer timer = new Timer();


    ColonyData PinguLibrary = new ColonyData();

    TextView numOfPingusTextView;
    TextView foodTextView;
    TextView dayCount;
    Random rand = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        this.dayCount = findViewById(R.id.dayTextView);
        this.numOfPingusTextView = findViewById(R.id.textView1);
        this.foodTextView = findViewById(R.id.textView2);


        Button button = findViewById(R.id.butHunt);
        Button button2 = findViewById(R.id.butEgg);

        //Hunt Button
        button.setOnClickListener(new View.OnClickListener() {
            //Hunt button
            public void onClick(View v) {
                //checks penguin count
                if (PinguLibrary.getNumOfPingus() == 0){
                    //if all pingus are dead, then toast message
                    Toast.makeText(getApplicationContext(),"All your penguins are dead", Toast.LENGTH_LONG).show();
                    numOfPingusTextView.setText("Pingus " + PinguLibrary.getNumOfPingus());
                }
                else {
                    //or... decrease pingu count by 1
                    PinguLibrary.setNumOfPingus(PinguLibrary.getNumOfPingus()-1);
                    String NewNumOfPengus = "Pingus " + PinguLibrary.getNumOfPingus();
                    numOfPingusTextView.setText(NewNumOfPengus);

                    //this adds a day to the counter
                    PinguLibrary.setDay(PinguLibrary.getDay()+1);

                    //Every five days, all pingus eat, exra pingus with no food die if they don't eat.
                    if (PinguLibrary.getDay() % 5 == 0){
                        if (PinguLibrary.getFood() < PinguLibrary.getNumOfPingus()){
                            PinguLibrary.setNumOfPingus(PinguLibrary.getNumOfPingus()-(PinguLibrary.getNumOfPingus()-PinguLibrary.getFood()));
                            PinguLibrary.setNumOfPingus(0);
                        }
                        else{
                            PinguLibrary.setFood(PinguLibrary.getFood()-PinguLibrary.getNumOfPingus());
                        }
                    }
                    String daySetText = "Day: " + PinguLibrary.getDay();
                    dayCount.setText(daySetText);

                    //adds random food from 0 - 3
                    PinguLibrary.setFood(PinguLibrary.getFood()+rand.nextInt(4));
                    String foodGain = "Food: " + PinguLibrary.getFood();
                    foodTextView.setText(foodGain);
                }
            }
        });

        //Egg button
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // food is used to make an egg. Zero food = no new pingus
                if (PinguLibrary.getFood() == 0){
                    String noFood = "Food: " + PinguLibrary.getFood();
                    foodTextView.setText(noFood);
                    Toast.makeText(getApplicationContext(),"Out Of Food", Toast.LENGTH_LONG).show();//notifies you that food is gone
                }

                // This will add a pingu at the cost of 1 food

                if (PinguLibrary.getFood() > 0) {
                    PinguLibrary.setFood(PinguLibrary.getFood()-1);
                    String foodLoss = "Food: " + PinguLibrary.getFood();
                    foodTextView.setText(foodLoss);
                    PinguLibrary.setNumOfPingus(PinguLibrary.getNumOfPingus()+rand.nextInt(2));
                    String NewNumOfPengus = "Pingus " + PinguLibrary.getNumOfPingus();
                    numOfPingusTextView.setText(NewNumOfPengus);
                }
            }
        });

        //Movement stuff

        penguinImage = (ImageView) findViewById(R.id.penguinsprite);

        //Gets screen size

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHieght = size.y;

        //Timer

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);
        screenHieght = screenHieght/1.5; // Maybe will reduce the travel


    }

    //WORK ON METHOD SO WHEN IT REACHES CERTAIN HEIGHT IT WILL GO BACK DOWN
    public void changePos(){

        //Makes the penguin move up
        penguinUpY -=3;//Controls speed of penguin, originally at 10
        if (penguinImage.getY() + penguinImage.getHeight() <0){
            penguinUpX = 10; //(float)Math.floor(Math.random() * (screenWidth - penguinImage.getWidth())); The 10 keeps the penguin in the position and not random, find out a way to make it more dynamic
            penguinUpY = screenHieght + 100;
        }


        penguinImage.setX((float)penguinUpX);
        penguinImage.setY((float)penguinUpY);

        //Supposed to go down, not final yet
        if(penguinImage.getHeight() >= (penguinImage.getY()/3)){


        }
    }
}
