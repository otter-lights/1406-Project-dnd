package com.company;

public class Druid extends MagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Druid(String chosenRace){
        super(chosenRace, 70, 0, 8, new boolean[] {false, false, false, true, true, false});
    }

    public void castSpell(){

    }
}
