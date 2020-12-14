package com.company;

public abstract class NonMagicUser extends Player{

    public NonMagicUser(String name, String chosenRace, int startingGold, int hitDie, int level){
        super(name, chosenRace, startingGold, hitDie, level);
    }
    public NonMagicUser(String name, String chosenRace, int startingGold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, startingGold, hitDie, xp, abilityScores);
    }

}
