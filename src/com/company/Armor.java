package com.company;

public class Armor extends Item{
    private int armorClass;
    String name;
    int modifier;
    int maxHP;
    String type;

    public Armor(String name, int cost, double weight, int armorClass, int modifier, String type, int maxHP){
        super(cost, weight);
        this.name = name;
        this.armorClass = armorClass;
        this.modifier = modifier;
        this.maxHP = maxHP;
        this.type = type;
    }
}
