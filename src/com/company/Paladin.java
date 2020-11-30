package com.company;

public class Paladin extends MagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5


    public Paladin(String chosenRace){
        super(chosenRace, 175, 0, 10, new boolean[] {false, false, false, false, true, true});
    }

    public void castSpell(){

    }

}
