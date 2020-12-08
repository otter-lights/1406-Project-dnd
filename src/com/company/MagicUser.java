package com.company;

public abstract class MagicUser extends Player{
    //spell save dc
    int spellSaveDC;
    //spell attack bonus

    int[] spellSlots;

    public MagicUser(String chosenRace, int startingGold, int xp, int hitDie, boolean[] saves, int spellMod){
        super(chosenRace, startingGold, xp, hitDie, saves);
        spellSaveDC = 8 + proficencyBonus + abilityMods[spellMod];
    }

    //not sure if this should be done here or in child class
    // requires a Spell to be cast, the level you want to cast the spell at, and the player being targeted
    public abstract void castSpell(Spell s, int level, Player p);
}
