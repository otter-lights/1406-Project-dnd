package com.company;
import java.util.Random;

public class Rouge extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    String[] sneakAttack = new String[] {"1d6", "1d6", "2d6", "2d6", "3d6", "3d6", "4d6", "4d6", "5d6", "5d6", "6d6", "6d6", "7d6", "7d6", "8d6", "8d6", "9d6", "9d6", "10d6", "10d6"};
    /*
    SNEAK ATTACK

    if u have advantage on roll u can deal extra damage (depends on lvl^)
    '-> going to have a 30% chance for sneak attack instead

    attack must used ranged weapon IGNORING THIS

     */

    public Rouge(String chosenRace){
        super(chosenRace, 140, 0, 8, new boolean[] {false, true, false, true, false, false});
    }

    public void attack(Player p, Weapon w){
        Random random = new Random();
        int sneakAttack = random.nextInt(3);
        if (sneakAttack == 0) {
            //yes sneak attack
            //damage(?) idk += roll however many times u need for your lvl^^ sneakAttack
            //attack:
        }
    }
}
