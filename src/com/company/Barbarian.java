package com.company;

public class Barbarian extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private int ragesUsed = 0;
    private int[] rages = new int[] {2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 999};
    private int[] rageDamage = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
    //rage lasts for 10 rounds
    //unarmored defense -> while not wearing armor
    //your armor class = 10 + dexterity + constitution

    public Barbarian(String chosenRace){
        super(chosenRace, 105, 0, 12, new boolean[] {true, false, true, false, false, false});
    }

    public void attack(){

    }
}
