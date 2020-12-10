package com.company;

public abstract class NonMagicUser extends Player{
    //list of attacks? (is that how this works)

    public NonMagicUser(String chosenRace, int startingGold, int xp, int hitDie, String name){
        super(chosenRace, startingGold, xp, hitDie, name);
    }

}
