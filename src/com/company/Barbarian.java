package com.company;

import java.util.Random;

public class Barbarian extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private int ragesUsed = 0;
    private int[] rages = new int[] {2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 999};
    private int[] rageDamage = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
    //rage lasts for 10 rounds
    //unarmored defense -> while not wearing armor
    // '->your armor class = 10 + dexterity + constitution

    public Barbarian(String chosenRace, String name, int level){
        super(name, chosenRace, 105, 12, level);
    }
    public Barbarian(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, hitDie, xp, abilityScores);
    }
    public void levelUp(){
        setMaxHP(getMaxHP() + 7);
    }
    public void longRest(){
        int currentLevel = getLevel();
        if(setLevel() > currentLevel){
            //you leveled up
            levelUp();
        }
        setCurrentHP(getMaxHP());
        Store generalStore = new Store(4,4,6);
        ragesUsed = 0;
    }
    public String getClassName(){return "Barbarian";}

    public boolean canRage(){
        return rages[this.getLevel() - 1] > ragesUsed;
    }

    public String startRage(Player p){
        if (canRage()){
            ragesUsed++;
            Random rand = new Random();
            int roll = rand.nextInt(20) + 1;
            if(roll >= p.getAC()) {
                roll = rand.nextInt(12) + 1  + rageDamage[getLevel() - 1];
                p.takeDamage(roll);
                return("Rage Attack Hits, " + p.getName() + " takes " + roll + " damage. \n");
            }
            else{
                return("Rage Attack Misses. \n");
            }
        }
        return("No Rages Left. \n");
    }
}
