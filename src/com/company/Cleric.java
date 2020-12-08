package com.company;

public class Cleric extends MagicUser{
    //Table formula is cantrips known, spells known (-1 if not relevant), then the slots at each level
    static int[][] clericTable = {{3,-1,2,0,0,0,0,0,0,0,0},
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
    static Spell[] allSpells = {new Spell("Word of Radiance", 2, 0,"1:6", 5,0,"radiant"),
                                new Spell("Sacred Flame", 1, 0,"1:8", 60, 0,"radiant"),
                                new Spell("Inflict Wounds", "3:10", 0, 1, "necrotic"),
                                new Spell("Guiding Bolt", "4:6", 120, 1, "radiant")};
    Spell[] preparedSpells;
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Cleric(String chosenRace){
        super(chosenRace, 140, 0, 8, new boolean[] {false, false, false, false, true, true},4);
        preparedSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public void prepareSpell(Spell prep){
        for(int i = 0; i < preparedSpells.length; i++){
            Spell curSpell = preparedSpells[i];
            if(curSpell == null && clericTable[getLevel()][prep.getLevel()+1] != 0){
                preparedSpells[i] = prep;
                break;
            }
        }
    }

    public void castSpell(Spell s, int level, Player p){

    }
}
