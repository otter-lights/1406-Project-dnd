package com.company;

public class Bard extends MagicUser{
    static int[][] bardTable = {{2,4,2,0,0,0,0,0,0,0,0},
                                {2,5,3,0,0,0,0,0,0,0,0},
                                {2,6,4,2,0,0,0,0,0,0,0},
                                {3,7,4,3,0,0,0,0,0,0,0},
                                {3,8,4,3,2,0,0,0,0,0,0},
                                {3,9,4,3,3,0,0,0,0,0,0},
                                {3,10,4,3,3,1,0,0,0,0,0},
                                {3,11,4,3,3,2,0,0,0,0,0},
                                {3,12,4,3,3,3,1,0,0,0,0},
                                {4,14,4,3,3,3,2,0,0,0,0},
                                {4,15,4,3,3,3,2,1,0,0,0},
                                {4,15,4,3,3,3,2,1,0,0,0},
                                {4,16,4,3,3,3,2,1,1,0,0},
                                {4,18,4,3,3,3,2,1,1,0,0},
                                {4,19,4,3,3,3,2,1,1,1,0},
                                {4,19,4,3,3,3,2,1,1,1,0},
                                {4,20,4,3,3,3,2,1,1,1,1},
                                {4,22,4,3,3,3,3,1,1,1,1},
                                {4,22,4,3,3,3,3,2,1,1,1},
                                {4,22,4,3,3,3,3,2,2,1,1}};
    static Spell[] allSpells = {new Spell("Vicious Mockery", "Wisdom", 0, "1:4", 60, 0,"psychic"),
                                new Spell("Thunderwave", "Constitution", 0.5, "2:8", 15,1,"thunder"),
                                new Spell("Dissonant Whispers", "Wisdom", 0.5, "3:6", 60, 1, "psychic"),
                                new Spell("Shatter", "Constitution", 0.5, "3:8", 60, 2, "thunder")};
    Spell[] knownSpells;
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Bard(String chosenRace){
        super(chosenRace, 105, 0, 8, new boolean[] {false, true, false, false, false, true});
        knownSpells = new Spell[bardTable[getLevel()][1]];
    }
    public void learnSpell(Spell prep){
        for(int i = 0; i < knownSpells.length; i++){
            Spell curSpell = knownSpells[i];
            //this makes sure that the bard is able to cast a spell of this level before learning it
            if(curSpell == null && bardTable[getLevel()][prep.getLevel()+1] != 0){
                knownSpells[i] = prep;
                break;
            }
        }
    }

    public void castSpell(){

    }
}
