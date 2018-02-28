package com.example.karls.penguincolony;

import android.view.View;
import android.widget.TextView;

import java.util.Random;


/**
 * Created by karls on 27-Feb-18.
 */

public class Penguin extends GamePage {
    public double breedRate = .25; //Here for future purposes

    public int numOfPingus =20;

    public void onHuntClick(View view){
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(numOfPingus + "Pingus");
        Random rand = new Random();
        int  probability = rand.nextInt(100) + 1;

        numOfPingus = numOfPingus-2;
        int battlePingus = 2;
        if (numOfPingus<=2){
        }
        else{
           if (probability<20){
               battlePingus - 2;
           }


        }
    }
}
