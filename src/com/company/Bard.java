package com.company;

import java.util.Random;

public class Bard extends MagicUser{
    private static int[][] bardTable = {{2,2,0,0,0,0,0,0,0,0},
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
    private static Spell[] allSpells = {new Spell("Vicious Mockery", 4, 0, "1:4", 60, 0,"psychic"),
                                        new Spell("Thunderwave", 2, 0.5, "2:8", 15,1,"thunder"),
                                        new Spell("Dissonant Whispers", 4, 0.5, "3:6", 60, 1, "psychic"),
                                        new Spell("Shatter", 2, 0.5, "3:8", 60, 2, "thunder")};
  
    private Spell[] useableSpells;

    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Bard(String chosenRace, String name, int level){
        super(name, chosenRace, 105, 8,5, level);
        useableSpells = new Spell[getLevel() + abilityMods[5]];
    }
    public Bard(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie,5, abilityScores);
        useableSpells = new Spell[bardTable[getLevel()][1]];
    }
    public void levelUp(){
        userLevel += 1;
        useableSpells = new Spell[bardTable[getLevel()][1]];
    }
    public int[] getSpellSlots(){return bardTable[userLevel - 1];}

    public boolean isUseable(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell != null && curSpell.equals(s)){
                return true;
            }
        }
        return false;
    }
    public String getClassName(){return "Bard";}
    public Spell[] getAllSpells(){return allSpells;}
    public Spell[] getUseableSpells(){return useableSpells;}

    public void prepSpell(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            //this makes sure that the bard is able to cast a spell of this level before learning it
            if(curSpell == null && bardTable[userLevel - 1][s.getLevel()+1] != 0){
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

    public void attack(Player p, Weapon w){}

}
