package com.company;
import java.util.Random;

public class Rogue extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    String[] sneakAttack = new String[] {"1d6", "1d6", "2d6", "2d6", "3d6", "3d6", "4d6", "4d6", "5d6", "5d6", "6d6", "6d6", "7d6", "7d6", "8d6", "8d6", "9d6", "9d6", "10d6", "10d6"};
    /*
    SNEAK ATTACK

    if u have advantage on roll u can deal extra damage (depends on lvl^)
    '-> going to have a 30% chance for sneak attack instead

    attack must used ranged weapon IGNORING THIS

     */

    public Rogue(String chosenRace, String name){
        super(chosenRace, 140, 0, 8, name);
    }
    public void levelUp(){
        userLevel += 1;
        maxHP += 5;
    }
    public String getClassName(){return "Rouge";}

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
