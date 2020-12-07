package com.company;

public class Monk extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    int[] martialArts = new int[] {4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10};
    //unarmored defense:
    //AC = 10 + dex + wisdom

    //if no weapon & no armor:
    //attack with martialArts ^
    public Monk(String chosenRace){
        super(chosenRace, 35, 0, 8, new boolean[] {true, true, false, false, false, false});
    }

    public void attack(){

    }
}
