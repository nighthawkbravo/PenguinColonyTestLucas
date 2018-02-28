package com.example.karls.penguincolony;

import android.view.View;
import android.widget.TextView;


/**
 * Created by karls on 27-Feb-18.
 */

public class Penguin extends GamePage {
    public double breedRate = .25; //Here for future purposes
    public int numOfPingus =20;

    public void onHuntClick(View view){
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(numOfPingus + "Pingus");
    }
}
