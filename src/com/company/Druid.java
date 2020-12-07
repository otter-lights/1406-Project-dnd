package com.company;

public class Druid extends MagicUser{
    static int[][] druidTable = {{2,-1,2,0,0,0,0,0,0,0,0},
                                 {2,-1,3,0,0,0,0,0,0,0,0},
                                 {2,-1,4,2,0,0,0,0,0,0,0},
                                 {3,-1,4,3,0,0,0,0,0,0,0},
                                 {3,-1,4,3,2,0,0,0,0,0,0},
                                 {3,-1,4,3,3,0,0,0,0,0,0},
                                 {3,-1,4,3,3,1,0,0,0,0,0},
                                 {3,-1,4,3,3,2,0,0,0,0,0},
                                 {3,-1,4,3,3,3,1,0,0,0,0},
                                 {4,-1,4,3,3,3,2,0,0,0,0},
                                 {4,-1,4,3,3,3,2,1,0,0,0},
                                 {4,-1,4,3,3,3,2,1,0,0,0},
                                 {4,-1,4,3,3,3,2,1,1,0,0},
                                 {4,-1,4,3,3,3,2,1,1,0,0},
                                 {4,-1,4,3,3,3,2,1,1,1,0},
                                 {4,-1,4,3,3,3,2,1,1,1,0},
                                 {4,-1,4,3,3,3,2,1,1,1,1},
                                 {4,-1,4,3,3,3,3,1,1,1,1},
                                 {4,-1,4,3,3,3,3,2,1,1,1},
                                 {4,-1,4,3,3,3,3,2,2,1,1}};
    static Spell[] allSpells = {new Spell("Poison Spray","Constitution",0, "1:12", 10, 0, "poison"),
                                new Spell("Thornwhip", "1:6", 30, 0, "piercing"),
                                new Spell("Thunderwave", "Constitution", 0.5, "2:8", 15,1,"thunder"),
                                new Spell("Sunburst", "Constitution", 0.5,"12:6", 150, 8,"radiant")};
    Spell[] preparedSpells;
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Druid(String chosenRace){
        super(chosenRace, 70, 0, 8, new boolean[] {false, false, false, true, true, false});
        preparedSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public void prepareSpell(Spell prep){
        for(int i = 0; i < preparedSpells.length; i++){
            Spell curSpell = preparedSpells[i];
            if(curSpell == null && druidTable[getLevel()][prep.getLevel()+1] != 0){
                preparedSpells[i] = prep;
                break;
            }
        }
    }

    public void castSpell(){

    }
}
