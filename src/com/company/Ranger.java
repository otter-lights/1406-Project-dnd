package com.company;

public class Ranger extends MagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Ranger(String chosenRace){
        super(chosenRace, 175, 0, 10, new boolean[] {true, true, false, false, false, false});
    }

    public void castSpell(){

    }
}
