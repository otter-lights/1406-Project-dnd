package com.company;

abstract public class Race {
    String size;
    int baseSpeed;
    //this will be a 6 int array containing the base ability score increases for each race.
    // Order is {Strength, Dex, Con, Int, Wis, Charisma}
    int[] abilityIncrease = new int[6];
    boolean darkvision;

    public String getSize(){
        return size;
    }

}
