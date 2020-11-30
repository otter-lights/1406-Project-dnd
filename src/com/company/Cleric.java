package com.company;

public class Cleric extends MagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Cleric(String chosenRace){
        super(chosenRace, 140, 0, 8, new boolean[] {false, false, false, false, true, true});
    }

    public void castSpell(){

    }
}
