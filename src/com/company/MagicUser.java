package com.company;

public abstract class MagicUser extends Player{
    //list of spells, using an arraylist or will be stored elsewhere?
    //spell save dc
    //spell attack bonus

    public MagicUser(String chosenRace, int startingGold, int xp, int hitDie, boolean[] saves){
        super(chosenRace, startingGold, xp, hitDie, saves);
    }

    //not sure if this should be done here or in child class
    public abstract void castSpell();
}
