package com.example.karls.penguincolony;

/**
 * Created by 1802070 on 4/12/2018.
 */

public class ColonyData {

    private int numOfAnimals;
    private int food;
    private static int day;

    private double Position;


    public ColonyData() {
        this.numOfAnimals = 6;
        this.food = 3;
        this.day = 0;

        this.Position = 100;
    }

    //getters
    public int getNumOfZebras() {
        return numOfAnimals;
    }
    public int getFood() {
        return food;
    }
    public static int getDay() {
        return day;
    }

    public double getPosition() {return Position;}

    //Setters
    public void setNumOfAnimals(int numOfAnimals) {
        this.numOfAnimals = numOfAnimals;
    }
    public void setFood(int food) {
        this.food = food;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public void setPosition(double Position) {this.Position = Position;}
}
