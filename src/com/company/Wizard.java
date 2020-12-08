package com.company;

public class Wizard extends MagicUser{
    static int[][] wizardTable = {{3,-1,2,0,0,0,0,0,0,0,0},
                                    {3,-1,3,0,0,0,0,0,0,0,0},
                                    {3,-1,4,2,0,0,0,0,0,0,0},
                                    {4,-1,4,3,0,0,0,0,0,0,0},
                                    {4,-1,4,3,2,0,0,0,0,0,0},
                                    {4,-1,4,3,3,0,0,0,0,0,0},
                                    {4,-1,4,3,3,1,0,0,0,0,0},
                                    {4,-1,4,3,3,2,0,0,0,0,0},
                                    {4,-1,4,3,3,3,1,0,0,0,0},
                                    {5,-1,4,3,3,3,2,0,0,0,0},
                                    {5,-1,4,3,3,3,2,1,0,0,0},
                                    {5,-1,4,3,3,3,2,1,0,0,0},
                                    {5,-1,4,3,3,3,2,1,1,0,0},
                                    {5,-1,4,3,3,3,2,1,1,0,0},
                                    {5,-1,4,3,3,3,2,1,1,1,0},
                                    {5,-1,4,3,3,3,2,1,1,1,0},
                                    {5,-1,4,3,3,3,2,1,1,1,1},
                                    {5,-1,4,3,3,3,3,1,1,1,1},
                                    {5,-1,4,3,3,3,3,2,1,1,1},
                                    {5,-1,4,3,3,3,3,2,2,1,1}};
    static Spell[] allSpells = {new Spell("Acid Splash", 1, 0, "1:6", 60,0,"acid"),
                                new Spell("Ray of Frost","1:8", 60, 0,"cold"),
                                new Spell("Magic Missle", "3:5", 120, 1, "force"),
                                new Spell("Acid Arrow", "4:6",90, 2, "acid")};
    Spell[] preparedSpells;
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Wizard(String chosenRace){
        super(chosenRace, 70, 0, 6, new boolean[] {false, false, false, true, true, false},3);
        preparedSpells = new Spell[getLevel() + abilityMods[3]];
    }
    public void prepareSpell(Spell prep){
        for(int i = 0; i < preparedSpells.length; i++){
            Spell curSpell = preparedSpells[i];
            if(curSpell == null && wizardTable[getLevel()][prep.getLevel()+1] != 0){
                preparedSpells[i] = prep;
                break;
            }
        }
    }

    public void castSpell(Spell s, int level, Player p){

    }
}
