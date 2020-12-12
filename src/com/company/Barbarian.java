package com.company;

public class Barbarian extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private int ragesUsed = 0;
    private int[] rages = new int[] {2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 999};
    private int[] rageDamage = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
    private boolean raging = false;
    //rage lasts for 10 rounds
    //unarmored defense -> while not wearing armor
    // '->your armor class = 10 + dexterity + constitution

    public Barbarian(String chosenRace, String name){
        super(name, chosenRace, 105, 0, 12);
    }
    public Barbarian(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie, abilityScores);
    }
    public void levelUp(){
        userLevel += 1;
        maxHP += 7;
    }
    public String getClassName(){return "Barbarian";}
    public void attack(Player p, Weapon w){

        if (raging){
            raging = false;
        }
    }

    public void startRage(){
        if (rages[this.getLevel() - 1] > ragesUsed){
            raging = true;
            ragesUsed++;
        }
    }


}
