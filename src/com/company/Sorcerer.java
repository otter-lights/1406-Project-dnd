package com.company;

import java.util.Random;

public class Sorcerer extends MagicUser{
    static int[][] sorcererTable = {{4,2,2,0,0,0,0,0,0,0,0},
                                {4,3,3,0,0,0,0,0,0,0,0},
                                {4,4,4,2,0,0,0,0,0,0,0},
                                {5,5,4,3,0,0,0,0,0,0,0},
                                {5,6,4,3,2,0,0,0,0,0,0},
                                {5,7,4,3,3,0,0,0,0,0,0},
                                {5,8,4,3,3,1,0,0,0,0,0},
                                {5,9,4,3,3,2,0,0,0,0,0},
                                {5,10,4,3,3,3,1,0,0,0,0},
                                {6,11,4,3,3,3,2,0,0,0,0},
                                {6,12,4,3,3,3,2,1,0,0,0},
                                {6,12,4,3,3,3,2,1,0,0,0},
                                {6,13,4,3,3,3,2,1,1,0,0},
                                {6,13,4,3,3,3,2,1,1,0,0},
                                {6,14,4,3,3,3,2,1,1,1,0},
                                {6,14,4,3,3,3,2,1,1,1,0},
                                {6,15,4,3,3,3,2,1,1,1,1},
                                {6,15,4,3,3,3,3,1,1,1,1},
                                {6,15,4,3,3,3,3,2,1,1,1},
                                {6,15,4,3,3,3,3,2,2,1,1}};
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    static Spell[] allSpells = {new Spell("Chill Touch", "1:8",120, 0, "necrotic"),
                                new Spell("Mind Spike", 4, 0.5, "3:8", 60, 2, "psychic"),
                                new Spell("Blight", 2, 0.5, "8:8", 30, 4,"necrotic"),
                                new Spell("Cone of Cold", 2, 0.5, "8:8", 60, 5, "cold")};
    Spell[] useableSpells;

    public Sorcerer(String chosenRace, String name){
        super(chosenRace, 70, 0, 6, 5, name);
        useableSpells = new Spell[sorcererTable[getLevel()][1]];
        spellSlots = sorcererTable[userLevel];
    }
    public void levelUp(){
        userLevel += 1;
        maxHP += 4;
        spellSlots = sorcererTable[userLevel];
    }
    public int[] getSpellSlots(){return sorcererTable[userLevel];}

    public boolean isUseable(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            if(curSpell.equals(s)){
                return true;
            }
        }
        return false;
    }

    public void learnSpell(Spell prep){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
            //this makes sure that the bard is able to cast a spell of this level before learning it
            if(curSpell == null && sorcererTable[getLevel()][prep.getLevel()+1] != 0){
                useableSpells[i] = prep;
                break;
            }
        }
    }

    public void attack(Player p, Weapon w){}

}
