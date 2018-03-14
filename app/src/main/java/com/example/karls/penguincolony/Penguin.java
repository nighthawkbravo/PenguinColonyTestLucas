package com.example.karls.penguincolony;

import android.view.View;
import android.widget.TextView;

import java.util.Random;


/**
 * Created by karls on 27-Feb-18.
 */

public class Penguin extends GamePage {

    public int numOfPingus =20; //Initial value of penguins at the start of the game

    public void onClickButHunt(View view){
        TextView textView = findViewById(R.id.textView1);
        Random chanceOfBeingHit = new Random();
        int max = 100;
        int min = 0;
        int variable = chanceOfBeingHit.nextInt(max-min)+min;
        numOfPingus = numOfPingus-2;
        int battlePingus = 2;
        if(numOfPingus<=2){
        }
        else{
            if (variable<=20) {
                battlePingus = battlePingus - 1;
            }
            variable = chanceOfBeingHit.nextInt(max-min)+min;
            if (variable<=20){
                battlePingus = battlePingus-1;
            }
        }
        numOfPingus = numOfPingus+battlePingus;
        String theIntString = Integer.toString(numOfPingus);
        textView.setText(theIntString + "Pingus");





    }
}
