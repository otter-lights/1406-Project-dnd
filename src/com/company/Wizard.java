package com.company;

import java.util.Random;

public class Wizard extends MagicUser{
    private static int[][] wizardTable = {{3,2,0,0,0,0,0,0,0,0},
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
    private static Spell[] allSpells = {new Spell("Acid Splash", 1, 0, "1:6", 60,0,"acid"),
                                        new Spell("Ray of Frost","1:8", 60, 0,"cold"),
                                        new Spell("Magic Missle", "3:5", 120, 1, "force"),
                                        new Spell("Acid Arrow", "4:6",90, 2, "acid")};
    private Spell[] useableSpells;
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5

    public Wizard(String chosenRace, String name, int level){
        super(name, chosenRace, 70, 6,3, level);
        useableSpells = new Spell[getLevel() + abilityMods[3]];
    }
    public Wizard(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie, 5, abilityScores);
        useableSpells = new Spell[getLevel() + abilityMods[3]];
    }
    public void levelUp(){
        maxHP += 4;
        useableSpells = new Spell[getLevel() + abilityMods[3]];
    }
    public int[] getSpellSlots(){return wizardTable[userLevel];}
    public String getClassName(){return "Wizard";}
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
            if(curSpell == null && wizardTable[userLevel][s.getLevel()+1] != 0){
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
