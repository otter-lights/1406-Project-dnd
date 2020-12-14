package com.company;
import java.util.Random;

public class Rogue extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private static String[] sneakAttack = new String[] {"1d6", "1d6", "2d6", "2d6", "3d6", "3d6", "4d6", "4d6", "5d6", "5d6", "6d6", "6d6", "7d6", "7d6", "8d6", "8d6", "9d6", "9d6", "10d6", "10d6"};

    public Rogue(String chosenRace, String name, int level){
        super(name, chosenRace, 140, 8, level);
    }
    public Rogue(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie, abilityScores);
    }
    public void levelUp(){
        maxHP += 5;
    }
    public String getClassName(){return "Rouge";}

    public void attack(Player p, Weapon w){
        //override on attack class
        Random random = new Random();
        int iSneakAttack = random.nextInt(3);
        int extraDamage = 0;
        if (iSneakAttack == 0) {
            for (Integer i = 0; i <= sneakAttack[userLevel - 1].charAt(0); i++){
                extraDamage += random.nextInt(sneakAttack[userLevel - 1].charAt(2));
            }
        }
        if(Math.abs(p.getPosition() - position) <= w.getRange()){
            Random rand = new Random();
            int roll = rand.nextInt(20) + 1;
            if(roll >= p.getAC()) {
                roll = rand.nextInt(w.getDamage()) + 1;
                p.takeDamage(roll + extraDamage);
                System.out.println("Attack Hits");
            }
            else{
                System.out.println("Attack Misses");
            }
        }
        else{
            System.out.println("Player not in range");
        }
    }

}
