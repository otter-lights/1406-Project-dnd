package com.company;

public class Barbarian extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Barbarian(String chosenRace){
        super(chosenRace, 105, 0, 12, new boolean[] {true, false, true, false, false, false});
    }

    public void attack(){

    }
}
