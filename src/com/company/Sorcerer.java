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
    Spell[] knownSpells;

    public Sorcerer(String chosenRace){
        super(chosenRace, 70, 0, 6, new boolean[] {false, false, true, false, false, true}, 5);
        knownSpells = new Spell[sorcererTable[getLevel()][1]];
        spellSlots = sorcererTable[userLevel];
    }
    public void learnSpell(Spell prep){
        for(int i = 0; i < knownSpells.length; i++){
            Spell curSpell = knownSpells[i];
            //this makes sure that the bard is able to cast a spell of this level before learning it
            if(curSpell == null && sorcererTable[getLevel()][prep.getLevel()+1] != 0){
                knownSpells[i] = prep;
                break;
            }
        }
    }
    public boolean isKnown(Spell s){
        for(int i = 0; i < knownSpells.length; i++){
            Spell curSpell = knownSpells[i];
            if(curSpell.equals(s)){
                return true;
            }
        }
        return false;
    }

    public void castSpell(Spell s, int level, Player p){
        String[] parts = s.getDamageDie().split(":");
        int numDie = Integer.parseInt(parts[0]);
        int dice = Integer.parseInt(parts[1]);

        if(isKnown(s) && spellSlots[level] != 0){
            if(Math.abs(p.getPosition() - position) <= s.getRange()){
                // then the player is in range
                Random rand = new Random();
                int roll;
                int totalDamage = 0;
                for(int i = 0; i < numDie; i++){
                    totalDamage += rand.nextInt(dice) + 1;
                }

                if(s.isHasSave()){
                    roll = rand.nextInt(20) + 1;
                    if(roll + p.getAbilityMods()[s.getSavingThrow()] > spellSaveDC){
                        System.out.println("Save is successful");
                        p.takeDamage(totalDamage);
                    }
                    else{
                        System.out.println("Attack is Successful");
                        p.takeDamage((int) Math.floor(totalDamage * s.getSave()));
                    }
                }
                else{
                    roll = rand.nextInt(20) + 1;
                    if(roll + proficencyBonus + abilityMods[5] >= p.getAC()){
                        System.out.println("Attack Hits");
                        p.takeDamage(totalDamage);
                    }
                    else{
                        System.out.println("Attack Misses");
                    }
                }
            }
            else{
                System.out.println("Player is out of range or no spell slots of this level remain.");
            }
        }
    }
}
