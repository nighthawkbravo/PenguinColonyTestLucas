package com.example.karls.penguincolony;

/**
 * Created by 1802070 on 4/12/2018.
 */

public class ColonyData {

    private int numOfPingus;
    private int food;
    private int day;


    public ColonyData() {
        this.numOfPingus = 10;
        this.food = 5;
        this.day = 0;
    }

    //getters
    public int getNumOfPingus() {
        return numOfPingus;
    }
    public int getFood() {
        return food;
    }
    public int getDay() {
        return day;
    }

    //Setters
    public void setNumOfPingus(int numOfPingus) {
        this.numOfPingus = numOfPingus;
    }
    public void setFood(int food) {
        this.food = food;
    }
    public void setDay(int day) {
        this.day = day;
    }
}
