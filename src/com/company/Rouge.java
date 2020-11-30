package com.company;

public class Rouge extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Rouge(String chosenRace){
        super(chosenRace, 140, 0, 8, new boolean[] {false, true, false, true, false, false});
    }

    public void attack(){

    }
}
