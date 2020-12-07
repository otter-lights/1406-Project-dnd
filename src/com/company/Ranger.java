package com.company;

public class Ranger extends MagicUser{
    static int[][] rangerTable = {{0,0,0,0,0,0,0,0,0,0,0},
                                {0,2,2,0,0,0,0,0,0,0,0},
                                {0,3,3,0,0,0,0,0,0,0,0},
                                {0,3,3,0,0,0,0,0,0,0,0},
                                {0,4,4,2,0,0,0,0,0,0,0},
                                {0,4,4,2,0,0,0,0,0,0,0},
                                {0,5,4,3,0,0,0,0,0,0,0},
                                {0,5,4,3,0,0,0,0,0,0,0},
                                {0,6,4,3,2,0,0,0,0,0,0},
                                {0,6,4,3,2,0,0,0,0,0,0},
                                {0,7,4,3,3,0,0,0,0,0,0},
                                {0,7,4,3,3,0,0,0,0,0,0},
                                {0,8,4,3,3,1,0,0,0,0,0},
                                {0,8,4,3,3,1,0,0,0,0,0},
                                {0,9,4,3,3,2,0,0,0,0,0},
                                {0,9,4,3,3,2,0,0,0,0,0},
                                {0,10,4,3,3,3,1,0,0,0,0},
                                {0,10,4,3,3,3,1,0,0,0,0},
                                {0,11,4,3,3,3,2,0,0,0,0},
                                {0,11,4,3,3,3,2,0,0,0,0}};
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Ranger(String chosenRace){
        super(chosenRace, 175, 0, 10, new boolean[] {true, true, false, false, false, false});
    }

    public void castSpell(){

    }
}
