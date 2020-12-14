package com.company;

import java.util.Random;

public class Druid extends MagicUser{
    private static int[][] druidTable = {{2,2,0,0,0,0,0,0,0,0},
                                         {2,3,0,0,0,0,0,0,0,0},
                                         {2,4,2,0,0,0,0,0,0,0},
                                         {3,4,3,0,0,0,0,0,0,0},
                                         {3,4,3,2,0,0,0,0,0,0},
                                         {3,4,3,3,0,0,0,0,0,0},
                                         {3,4,3,3,1,0,0,0,0,0},
                                         {3,4,3,3,2,0,0,0,0,0},
                                         {3,4,3,3,3,1,0,0,0,0},
                                         {4,4,3,3,3,2,0,0,0,0},
                                         {4,4,3,3,3,2,1,0,0,0},
                                         {4,4,3,3,3,2,1,0,0,0},
                                         {4,4,3,3,3,2,1,1,0,0},
                                         {4,4,3,3,3,2,1,1,0,0},
                                         {4,4,3,3,3,2,1,1,1,0},
                                         {4,4,3,3,3,2,1,1,1,0},
                                         {4,4,3,3,3,2,1,1,1,1},
                                         {4,4,3,3,3,3,1,1,1,1},
                                         {4,4,3,3,3,3,2,1,1,1},
                                         {4,4,3,3,3,3,2,2,1,1}};
    private static Spell[] allSpells = {new Spell("Poison Spray",2,0, "1:12", 10, 0, "poison"),
                                new Spell("Thornwhip", "1:6", 30, 0, "piercing"),
                                new Spell("Thunderwave", 2, 0.5, "2:8", 15,1,"thunder"),
                                new Spell("Sunburst", 2, 0.5,"12:6", 150, 8,"radiant")};
    private Spell[] useableSpells;
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Druid(String chosenRace, String name, int level){
        super(name, chosenRace, 70, 8, 4, level);
        useableSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public Druid(String chosenRace, String name, int gold,  int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie,5, abilityScores);
        useableSpells = new Spell[getLevel() + abilityMods[4]];
    }
    public void levelUp(){
        maxHP += 5;
        useableSpells = new Spell[getLevel() + abilityMods[4]];
    }

    public int[] getSpellSlots(){return druidTable[userLevel - 1];}
    public String getClassName(){return "Druid";}
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
            if(curSpell == null && druidTable[userLevel - 1][s.getLevel()+1] != 0){
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
