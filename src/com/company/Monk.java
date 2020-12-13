package com.company;

public class Monk extends NonMagicUser{
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    int[] martialArts = new int[] {4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10};
    //unarmored defense:
    //AC = 10 + dex + wisdom

    //if no weapon & no armor:
    //attack with martialArts ^
    public Monk(String chosenRace, String name, int level){
        super(name, chosenRace, 35, 0, 8, level);
        addToInventory((new Melee("Martial Arts", 0, 0.0, martialArts[this.getLevel() - 1])));
    }
    public Monk(String chosenRace, String name, int gold, int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie, abilityScores);
        addToInventory((new Melee("Martial Arts", 0, 0.0, martialArts[this.getLevel() - 1])));
    }
    public String getClassName(){return "Monk";}

    public void levelUp(){
        userLevel += 1;
        maxHP += 5;

    }

    public void attack(Player p, Weapon w){

    }
}
