package com.company;

public abstract class NonMagicUser extends Player{
    //list of attacks? (is that how this works)

    public NonMagicUser(String chosenRace, int startingGold, int xp, int hitDie, boolean[] saves){
        super(chosenRace, startingGold, xp, hitDie, saves);
    }

    //not sure if this should be done here or in child class

}
