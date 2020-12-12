package com.company;

public abstract class NonMagicUser extends Player{
    //list of attacks? (is that how this works)

    public NonMagicUser(String name, String chosenRace, int startingGold, int xp, int hitDie){
        super(name, chosenRace, startingGold, xp, hitDie);
    }
    public NonMagicUser(String name, String chosenRace, int startingGold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, startingGold, xp, hitDie, abilityScores);
    }

}
