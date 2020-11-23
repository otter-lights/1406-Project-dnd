package com.company;

public class Halfling extends Race{
    public Halfling(){
        size = "Small";
        baseSpeed = 25;
        darkvision = false;
        // sets the dex increase to +2
        abilityIncrease[1] = 2;
        // sets the con increase to +1
        abilityIncrease[2] = 1;
    }
}
