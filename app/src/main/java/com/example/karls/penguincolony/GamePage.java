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

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GamePage extends AppCompatActivity {

    //Screen Size
    private int screenWidth;
    private int screenHeight;

    //Pingu Image
    private ImageView penguinsprite;

    //Position

    private float pingUpX;
    private float pinguUpY;
    private float pingDownX;
    private float PingDownY;
    private float PingLeftX;
    private float PingLeftY;
    private float PingRightX;
    private float PingRightY;

    //Initalizer

    private Handler handler = new Handler();
    private Timer timer = new Timer();


    //Game Variables

    public int numOfPingus = 10;
    public int food = 5;
    public int day = 0;
    TextView numOfPingusTextView;
    TextView foodTextView;
    TextView dayCount;
    Random rand = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        //Not sure what it does yet
        penguinsprite = (ImageView)findViewById(R.id.penguinsprite);

        //Getting the screensize
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //Starts the timer
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
        },0,20);{
        public void changePos(){
            //Up
                pingUpX-=10;
                if pinguinsprite.getY() + ping //Minute 6:14
            }

        }

        this.dayCount = findViewById(R.id.dayTextView);
        this.numOfPingusTextView = findViewById(R.id.textView1);
        this.foodTextView = findViewById(R.id.textView2);


        Button button = findViewById(R.id.butHunt);
        Button button2 = findViewById(R.id.butEgg);


        button.setOnClickListener(new View.OnClickListener() {
            //Hunt button
            public void onClick(View v) {
                if (numOfPingus == 0){
                    Toast.makeText(getApplicationContext(),"All your penguins are dead", Toast.LENGTH_LONG).show();//notifies you that all penguins are dead


                    numOfPingusTextView.setText("Pingus " + numOfPingus);
                }
                else {
                    numOfPingus = (numOfPingus - 1);
                    String NewNumOfPengus = "Pingus " + numOfPingus;
                    numOfPingusTextView.setText(NewNumOfPengus);

                    day = day + 1;
                    if (day % 5 == 0){
                        if (food < numOfPingus){
                            numOfPingus = numOfPingus - (numOfPingus - food);
                            food = 0;
                        }
                        else{
                            food = food - numOfPingus;
                        }
                    }
                    String daySetText = "Day: " + day;
                    dayCount.setText(daySetText);

                    food = food + rand.nextInt(4);
                    String foodGain = "Food: " + food;
                    foodTextView.setText(foodGain);
                }
            }
        });

        //Egg button
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (food == 0){
                    String noFood = "Food: " + food;
                    foodTextView.setText(noFood);
                    Toast.makeText(getApplicationContext(),"Out Of Food", Toast.LENGTH_LONG).show();//notifies you that food is gone
                }
                if (food >= 1) {
                    food = food - 1;
                    String foodLoss = "Food: " + food;
                    foodTextView.setText(foodLoss);
                    numOfPingus = numOfPingus + rand.nextInt(2);
                    String NewNumOfPengus = "Num of pingus " + numOfPingus;
                    numOfPingusTextView.setText(NewNumOfPengus);
                }
            }
        });
    }
}
