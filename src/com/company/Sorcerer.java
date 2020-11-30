package com.company;

public class Sorcerer extends MagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Sorcerer(String chosenRace){
        super(chosenRace, 70, 0, 6, new boolean[] {false, false, true, false, false, true});
    }

    public void castSpell(){

    }
}
