package com.company;

public class Fighter extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Fighter(String chosenRace){
        super(chosenRace, 175, 0, 10, new boolean[] {true, false, true, false, false, false});
    }

    public void attack(){

    }
}
