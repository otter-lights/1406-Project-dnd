package com.company;

public class Bard extends MagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Bard(String chosenRace){
        super(chosenRace, 105, 0, 8, new boolean[] {false, true, false, false, false, true});
    }

    public void castSpell(){

    }
}
