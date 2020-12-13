package com.company;

import java.util.Random;

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
    static Spell[] allSpells = {new Spell("Vicious Mockery", 4, 0, "1:4", 60, 0,"psychic"),
                                new Spell("Thunderwave", 2, 0.5, "2:8", 15,1,"thunder"),
                                new Spell("Dissonant Whispers", 4, 0.5, "3:6", 60, 1, "psychic"),
                                new Spell("Shatter", 2, 0.5, "3:8", 60, 2, "thunder")};
  
    Spell[] useableSpells;

    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    public Bard(String chosenRace, String name){
        super(name, chosenRace, 105, 0, 8,5);
        useableSpells = new Spell[bardTable[getLevel()][1]];
    }
    public Bard(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie,5, abilityScores);
        useableSpells = new Spell[bardTable[getLevel()][1]];
    }
    public void levelUp(){
        userLevel += 1;
        useableSpells = new Spell[bardTable[getLevel()][1]];
    }
    public int[] getSpellSlots(){return bardTable[userLevel];}

    public boolean isUseable(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell.equals(s)){
                return true;
            }
        }
        return false;
    }
    public String getClassName(){return "Bard";}
    public Spell[] getAllSpells(){return allSpells;};
    public Spell[] getUseableSpells(){return useableSpells;}

    public void prepSpell(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            //this makes sure that the bard is able to cast a spell of this level before learning it
            if(curSpell == null && bardTable[userLevel][s.getLevel()+1] != 0){
                useableSpells[i] = s;
                break;
            }
        }
    }

    public void attack(Player p, Weapon w){}

}
