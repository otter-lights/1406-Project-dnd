package com.company;

import java.util.Random;

public class Sorcerer extends MagicUser{
    private static int[][] sorcererTable = {{4,2,0,0,0,0,0,0,0,0},
                                            {4,3,0,0,0,0,0,0,0,0},
                                            {4,4,2,0,0,0,0,0,0,0},
                                            {5,4,3,0,0,0,0,0,0,0},
                                            {5,4,3,2,0,0,0,0,0,0},
                                            {5,4,3,3,0,0,0,0,0,0},
                                            {5,4,3,3,1,0,0,0,0,0},
                                            {5,4,3,3,2,0,0,0,0,0},
                                            {5,4,3,3,3,1,0,0,0,0},
                                            {6,4,3,3,3,2,0,0,0,0},
                                            {6,4,3,3,3,2,1,0,0,0},
                                            {6,4,3,3,3,2,1,0,0,0},
                                            {6,4,3,3,3,2,1,1,0,0},
                                            {6,4,3,3,3,2,1,1,0,0},
                                            {6,4,3,3,3,2,1,1,1,0},
                                            {6,4,3,3,3,2,1,1,1,0},
                                            {6,4,3,3,3,2,1,1,1,1},
                                            {6,4,3,3,3,3,1,1,1,1},
                                            {6,4,3,3,3,3,2,1,1,1},
                                            {6,4,3,3,3,3,2,2,1,1}};
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private static Spell[] allSpells = {new Spell("Chill Touch", "1:8",120, 0, "necrotic"),
                                new Spell("Mind Spike", 4, 0.5, "3:8", 60, 2, "psychic"),
                                new Spell("Blight", 2, 0.5, "8:8", 30, 4,"necrotic"),
                                new Spell("Cone of Cold", 2, 0.5, "8:8", 60, 5, "cold")};
    private Spell[] useableSpells;

    public Sorcerer(String chosenRace, String name, int level){
        super(name, chosenRace, 70, 6, 5, level);
        if(getAbilityMods()[5] > 0){
            useableSpells = new Spell[getLevel() + getAbilityMods()[5]];
        }
        else{
            useableSpells = new Spell[getLevel()];
        }
    }
    public Sorcerer(String chosenRace, String name, int gold,  int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie,5, abilityScores);
        if(getAbilityMods()[5] > 0){
            useableSpells = new Spell[getLevel() + getAbilityMods()[5]];
        }
        else{
            useableSpells = new Spell[getLevel()];
        }
    }
    public void levelUp(){
        setMaxHP(getMaxHP() + 4);
        useableSpells = new Spell[getLevel() + getAbilityMods()[5]];
        spellSlots = sorcererTable[getLevel() - 1];
    }

    public int[] getSpellSlots(){return sorcererTable[getLevel() - 1];}
    public String getClassName(){return "Sorcerer";}
    public Spell[] getAllSpells(){return allSpells;}
    public Spell[] getUseableSpells(){return useableSpells;}


    public boolean isUseable(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell != null && curSpell.equals(s)){
                return true;
            }
        }
        System.out.println("not useable");
        return false;
    }

    public void prepSpell(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            //this makes sure that the bard is able to cast a spell of this level before learning it
            if(curSpell == null && sorcererTable[getLevel() - 1][s.getLevel()+1] != 0){
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
