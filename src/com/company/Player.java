package com.company;
import java.util.Random;
import java.util.stream.Stream;
import java.util.ArrayList;

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

    public Player(){

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
    }


}
