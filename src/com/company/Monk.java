package com.company;

public class Monk extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Monk(String chosenRace){
        super(chosenRace, 35, 0, 8, new boolean[] {true, true, false, false, false, false});
    }

    public void attack(){

    }
}
