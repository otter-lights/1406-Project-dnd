package com.company;

public class Armor extends Item{
    private int armorClass;
    String modifier;
    int maxHP;
    String type;

    public Armor(int cost, double weight, int armorClass, String modifier, String type, int maxHP){
        super(cost, weight);
        this.armorClass = armorClass;
        this.modifier = modifier;
        this.maxHP = maxHP;
        this.type = type;
    }
}
