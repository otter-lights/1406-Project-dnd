package com.company;
import java.util.Random;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    String alignment;
    int currentHP;
    int maxHP;
    int experience;
    Race playerRace;
    int strength;
    int dexterity;
    int constiution;
    int intelligence;
    int wisdom;
    int charisma;
    boolean Alive;
    int[] money = new int[3]; // depends on class
    ArrayList<Item> inventory;

    public Player(){

    }
    // A players carrying capacity depends on the size of their Race, this function allows the item to be added to inventory as long as the total weight of the items is under their carrying capacity
    // For now I am ignoring the decrease in speed that comes with higher weights, potentially added at a later date.
    public void addToInventory(Item newItem){
        int weight = 0;
        for(Item i: inventory){
            weight += i.getWeight();
        }
        if((playerRace.getSize().equals("Small") || playerRace.getSize().equals("Medium")) && weight + newItem.getWeight() <= 15*strength){
            inventory.add(newItem);
        }
        else if(playerRace.getSize().equals("Tiny") && weight + newItem.getWeight() <= (15*strength)/2){
            inventory.add(newItem);
        }
        else if((playerRace.getSize().equals("Large") || playerRace.getSize().equals("Huge") || playerRace.getSize().equals("Gargantuan")) && weight + newItem.getWeight() <= 2*15*strength){
            inventory.add(newItem);
        }
    }


    public void getRacialBonus(){

    }

    public void getStartingEquipment(){
        //depends on class
    }

    public void getSpells(){
        //depends on class
    }

    private void doRolls(){
        int[] abilityScores = new int[6];
        Random rand = new Random();
        //have to roll a six-sided die 4 times per ability and sum the top 3 rolls
        for (int i = 0; i < abilityScores.length; i++){
            ArrayList<Integer> rolls = new ArrayList<>();
            for (int n = 0; n < 4; n++){
                rolls.add(rand.nextInt(6) + 1);
            }
            rolls.remove(Collections.min(rolls));
            abilityScores[i] = rolls.stream().mapToInt(Integer::intValue).sum();
        }
        //ignoring class primary stat
        strength = abilityScores[0];
        dexterity = abilityScores[1];
        constiution = abilityScores[2];
        intelligence = abilityScores[3];
        wisdom = abilityScores[4];
        charisma = abilityScores[5];
    }


}
