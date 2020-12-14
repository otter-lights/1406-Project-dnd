package com.company;

public class Cleric extends MagicUser{
    //Table formula is cantrips known, spells known (-1 if not relevant), then the slots at each level
    private static int[][] clericTable = {{3,2,0,0,0,0,0,0,0,0},
                                          {3,3,0,0,0,0,0,0,0,0},
                                          {3,4,2,0,0,0,0,0,0,0},
                                          {4,4,3,0,0,0,0,0,0,0},
                                          {4,4,3,2,0,0,0,0,0,0},
                                          {4,4,3,3,0,0,0,0,0,0},
                                          {4,4,3,3,1,0,0,0,0,0},
                                          {4,4,3,3,2,0,0,0,0,0},
                                          {4,4,3,3,3,1,0,0,0,0},
                                          {5,4,3,3,3,2,0,0,0,0},
                                          {5,4,3,3,3,2,1,0,0,0},
                                          {5,4,3,3,3,2,1,0,0,0},
                                          {5,4,3,3,3,2,1,1,0,0},
                                          {5,4,3,3,3,2,1,1,0,0},
                                          {5,4,3,3,3,2,1,1,1,0},
                                          {5,4,3,3,3,2,1,1,1,0},
                                          {5,4,3,3,3,2,1,1,1,1},
                                          {5,4,3,3,3,3,1,1,1,1},
                                          {5,4,3,3,3,3,2,1,1,1},
                                          {5,4,3,3,3,3,2,2,1,1}};
    private static Spell[] allSpells = {new Spell("Word of Radiance", 2, 0,"1:6", 5,0,"radiant"),
                                        new Spell("Sacred Flame", 1, 0,"1:8", 60, 0,"radiant"),
                                        new Spell("Inflict Wounds", "3:10", 0, 1, "necrotic"),
                                        new Spell("Guiding Bolt", "4:6", 120, 1, "radiant")};
    private Spell[] useableSpells;

    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Cleric(String chosenRace, String name, int level){
        super(name, chosenRace, 140, 8,4, level);
        useableSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public Cleric(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie,5, abilityScores);
        useableSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public void levelUp(){
        maxHP += 5;
        useableSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public int[] getSpellSlots(){return clericTable[userLevel];}
    public String getClassName(){return "Cleric";}
    public Spell[] getAllSpells(){return allSpells;}
    public Spell[] getUseableSpells(){return useableSpells;}

    public boolean isUseable(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell != null && curSpell.equals(s)){
                return true;
            }
        }
        return false;
    }

    public void prepSpell(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell == null && clericTable[userLevel][s.getLevel()+1] != 0){
                useableSpells[i] = s;
                break;
            }
        }
    }
    public void removeSpell(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell != null && curSpell.equals(s) && s.getLevel() != 0){
                useableSpells[i] = null;
                break;
            }
        }
    }
}
