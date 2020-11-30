package com.company;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public abstract class Player {
    String alignment;
    int currentHP;
    int maxHP;
    int experience;
    Race playerRace;

    //i think it would be better to have these in an array (stats)
    //it would make setting them up easier
    int strength;     //0
    int dexterity;    //1
    int constitution; //2
    int intelligence; //3
    int wisdom;       //4
    int charisma;     //5
    int[] abilityScores = new int[6];
    boolean Alive;
    int[] money = new int[3]; // depends on class
    ArrayList<Item> inventory;

    //The chosen race input will come from the gui/a generation
    //constructor is currently empty (maybe not the best way to implement?)
    public Player(String chosenRace){
        playerRace = new Race(chosenRace);
        rollAbilityScores();
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
