package com.company;

public abstract class NonMagicUser extends Player{
    //list of attacks? (is that how this works)

    public NonMagicUser(String chosenRace, int startingGold){
        super(chosenRace, startingGold);
    }

    //not sure if this should be done here or in child class
    public abstract void attack();
}
