package com.company;

import java.util.Random;

public abstract class MagicUser extends Player{
    //spell save dc
    int spellSaveDC;
    //spell attack bonus
    int spellCastingType;

    int[] spellSlots;
    Spell[] useableSpells;

    public MagicUser(String chosenRace, int startingGold, int xp, int hitDie, int spellMod, String name){
        super(chosenRace, startingGold, xp, hitDie, name);
        spellSaveDC = 8 + proficencyBonus + abilityMods[spellMod];
        spellCastingType = spellMod;
    }
    public boolean isUseable(Spell s){
        for(int i = 0; i < useableSpells.length; i++){
            Spell curSpell = useableSpells[i];
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

        if(isUseable(s) && spellSlots[level] != 0){
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
                        p.takeDamage((int) Math.floor(totalDamage * s.getSave()));
                    }
                    else{
                        System.out.println("Attack is Successful");
                        p.takeDamage(totalDamage);
                    }
                }
                else{
                    roll = rand.nextInt(20) + 1;
                    if(roll + proficencyBonus + abilityMods[spellCastingType] >= p.getAC()){
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
