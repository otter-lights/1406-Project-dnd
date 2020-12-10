package com.company;

public class Fighter extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    /* FIGHTING STYLE
    Archery
    You gain a +2 bonus to attack rolls you make with ranged weapons.

    Defense
    While you are wearing armor, you gain a +1 bonus to AC.

    Dueling
    When you are wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.

    Great Weapon Fighting
    When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that you are wielding with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or a 2. The weapon must have the two-handed or versatile property for you to gain this benefit.

    Protection
    When a creature you can see attacks a target other than you that is within 5 feet of you, you can use your reaction to impose disadvantage on the attack roll. You must be wielding a shield.

    Two-Weapon Fighting
    When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.

     */

    //SECOND WIND
    //u can use bonus action to regain hit points equal to 1d10 + lvl
    //must short or long rest before use again
    public Fighter(String chosenRace){
        super(chosenRace, 175, 0, 10, new boolean[] {true, false, true, false, false, false});
    }

    public void attack(Player p, Weapon w){

    }
}
