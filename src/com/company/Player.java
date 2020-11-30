package com.company;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public abstract class Player {
    String alignment;
    int currentHP;
    int maxHP;

    int userLevel;
    int proficencyBonus;
    int experience;
    Race playerRace;

    //Acrobatics, Animal Handling, Arcana, Athletics, Deception, History, Insight, Intimidation, Investigation, Medicine, Nature, Perception, Performance, Persuasion, Religion, Slight of Hand, Stealth, Survival
    boolean[] skillProficency = new boolean[18];

    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    int[] abilityScores = new int[6];
    int[] abilityMods = new int[6];
    boolean Alive;
    int[] money = new int[3]; // depends on class
    ArrayList<Item> inventory;

    //The chosen race input will come from the gui/a generation
    //constructor is currently empty (maybe not the best way to implement?)
  
    public Player(String chosenRace, int experience, int startingGold){
        playerRace = new Race(chosenRace);
        money[0] = startingGold;
        this.experience = experience;
        rollAbilityScores();
        setLevel();
    }
    public int getLevel(){return userLevel;}
    public int getProficencyBonus(){return proficencyBonus;}

    //needs to be supplied with the index of the appropriate modifier, the score that needs to be beaten, and a boolean indicating proficency
    public boolean attackRoll(int modifier, int scoreToBeat, boolean profienct){
        Random d20 = new Random();
        int roll = (d20.nextInt(20) + 1) + abilityMods[modifier];
        if(profienct){
            roll = roll + proficencyBonus;
        }
        return roll >= scoreToBeat;
    }
    //needs to be supplied with the index of the appropriate modifier.
    public int damageRoll(int modifier){
        Random d20 = new Random();
        return (d20.nextInt(20)+ 1) + abilityMods[modifier];
    }

    public void setAbilityMods(){
        for(int i = 0; i < 6; i++){
            abilityMods[i] = (int) Math.floor((abilityScores[i] - 10)/2);
        }
    }
    public void setLevel(){
        if(experience < 300){
            userLevel = 1;
            proficencyBonus = 2;
        }
        else if (experience < 900){
            userLevel = 2;
            proficencyBonus = 2;
        }
        else if (experience < 2700){
            userLevel = 3;
            proficencyBonus = 2;
        }
        else if(experience < 6500){
            userLevel = 4;
            proficencyBonus = 2;
        }
        else if(experience < 14000){
            userLevel = 5;
            proficencyBonus = 3;
        }
        else if(experience < 23000){
            userLevel = 6;
            proficencyBonus = 3;
        }
        else if(experience < 34000){
            userLevel = 7;
            proficencyBonus = 3;
        }
        else if(experience < 48000){
            userLevel = 8;
            proficencyBonus = 3;
        }
        else if(experience < 64000){
            userLevel = 9;
            proficencyBonus = 4;
        }
        else if(experience < 85000){
            userLevel = 10;
            proficencyBonus = 4;
        }
        else if(experience < 100000){
            userLevel = 11;
            proficencyBonus = 4;
        }
        else if(experience < 120000){
            userLevel = 12;
            proficencyBonus = 4;
        }
        else if(experience < 140000){
            userLevel = 13;
            proficencyBonus = 5;
        }
        else if(experience < 165000){
            userLevel = 14;
            proficencyBonus = 5;
        }
        else if(experience < 195000){
            userLevel = 15;
            proficencyBonus = 5;
        }
        else if(experience < 225000){
            userLevel = 16;
            proficencyBonus = 5;
        }
        else if(experience < 265000){
            userLevel = 17;
            proficencyBonus = 6;
        }
        else if(experience < 305000){
            userLevel = 18;
            proficencyBonus = 6;
        }
        else if(experience < 355000){
            userLevel = 19;
            proficencyBonus = 6;
        }
        else if(experience >= 355000){
            userLevel = 20;
            proficencyBonus = 6;
        }
    }

    // A players carrying capacity depends on the size of their Race, this function allows the item to be added to inventory as long as the total weight of the items is under their carrying capacity
    // For now I am ignoring the decrease in speed that comes with higher weights, potentially added at a later date.
    public void addToInventory(Item newItem){
        int weight = 0;
        for(Item i: inventory){
            weight += i.getWeight();
        }
        if((playerRace.getSize().equals("Small") || playerRace.getSize().equals("Medium")) && weight + newItem.getWeight() <= 15*abilityScores[0]){
            inventory.add(newItem);
        }
        else if(playerRace.getSize().equals("Tiny") && weight + newItem.getWeight() <= (15*abilityScores[0])/2){
            inventory.add(newItem);
        }
        else if((playerRace.getSize().equals("Large") || playerRace.getSize().equals("Huge") || playerRace.getSize().equals("Gargantuan")) && weight + newItem.getWeight() <= 2*15*abilityScores[0]){
            inventory.add(newItem);
        }
    }

    public void getStartingEquipment(){
        //depends on class
    }

    public void getSpells(){
        //depends on class
    }

    private void rollAbilityScores(){
        int[] abilityIncrease = playerRace.getAbilityIncrease();
        Random rand = new Random();
        //have to roll a six-sided die 4 times per ability and sum the top 3 rolls
        for (int i = 0; i < 6; i++){
            ArrayList<Integer> rolls = new ArrayList<>();
            for (int n = 0; n < 4; n++){
                rolls.add(rand.nextInt(6) + 1);
            }
            rolls.remove(Collections.min(rolls));

            //this is an option if you want to store the stats in an array
            //it adds the ability increase in this main loop
            abilityScores[i] = rolls.stream().mapToInt(Integer::intValue).sum() + abilityIncrease[i];
        }
    }


}
