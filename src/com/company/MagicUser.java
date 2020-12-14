package com.company;

import java.util.ArrayList;
import java.util.Random;

public abstract class MagicUser extends Player{
    protected int spellSaveDC;
    protected int spellCastingType;
    protected int[] spellSlots;

    public MagicUser(String name, String chosenRace, int startingGold, int hitDie, int spellMod, int level){
        super(name, chosenRace, startingGold, hitDie, level);
        spellSaveDC = 8 + proficencyBonus + abilityMods[spellMod];
        spellCastingType = spellMod;
        spellSlots = getSpellSlots();
    }
    public MagicUser(String name, String chosenRace, int startingGold, int xp, int hitDie, int spellMod, int[] abilityScores){
        super(name, chosenRace, startingGold, hitDie, xp, abilityScores);
        spellSaveDC = 8 + proficencyBonus + abilityMods[spellMod];
        spellCastingType = spellMod;
        spellSlots = getSpellSlots();
    }

    public abstract boolean isUseable(Spell s);
    public abstract void prepSpell(Spell s);
    public abstract void removeSpell(Spell s);
    public abstract int[] getSpellSlots();
    public abstract Spell[] getAllSpells();
    public abstract Spell[] getUseableSpells();

    public boolean canPrepSpell(){
        for(Spell s: getUseableSpells()){
            if(s == null){
                return true;
            }
        }
        return false;
    }

    public void randomUseableSpells(){
        boolean stop = false;
        Random rand = new Random();
        while(!stop){
            prepSpell(getAllSpells()[rand.nextInt(getAllSpells().length)]);

            stop = !canPrepSpell();
        }
    }

    public ArrayList<Spell> getUseableSpellsList(){
        ArrayList<Spell> use = new ArrayList<>();
        for(Spell s: getUseableSpells()){
            if(s!=null){
                use.add(s);
            }
        }
        return use;
    }

    public String castSpell(Spell s, Player p){
        String[] parts = s.getDamageDie().split(":");
        int numDie = Integer.parseInt(parts[0]);
        int dice = Integer.parseInt(parts[1]);

        if(isUseable(s) && spellSlots[s.getLevel()] != 0){
            System.out.println(p.getPosition());
            System.out.println(position);
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
                        if(s.getSave() == 0){
                            p.takeDamage((int) Math.floor(totalDamage * s.getSave()));
                            removeSpell(s);
                            return("Save is successful, no damage taken.");
                        }
                        else if (s.getSave() == 0.5){
                            p.takeDamage((int) Math.floor(totalDamage * s.getSave()));
                            removeSpell(s);
                            return("Save is successful, deals half damage. " + p.getName() + " takes " + Math.floor(totalDamage * s.getSave()) + " damage.");
                        }
                    }
                    else{
                        p.takeDamage(totalDamage);
                        removeSpell(s);
                        return ("Attack is Successful, spell does " + totalDamage + " damage.");

                    }
                }
                else{
                    roll = rand.nextInt(20) + 1;
                    if(roll + proficencyBonus + abilityMods[spellCastingType] >= p.getAC()){
                        p.takeDamage(totalDamage);
                        removeSpell(s);
                        return("Attack Hits, it does " + totalDamage + " damage.");

                    }
                    else{
                        removeSpell(s);
                        return("Attack Misses.");
                    }
                }
            }
            else{
                return("Spell is unable to be cast. (" + p.getName() + " is out of range)");
            }
        }
        else{
            return("Spell is unable to be cast. (No spell slots of level " + s.getLevel() +  " remain.)");
        }
        return("Error Casting, Please Try Again.");
    }

}
