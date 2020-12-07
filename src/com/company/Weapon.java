package com.company;

public class Weapon extends Item{
    private String name;
    private int damage;
    private boolean twoHanded;
    private String type;
    public Weapon(String name, int cost, double weight, int damage, String type, boolean twoHanded){
        super(cost, weight);
        this.name = name;
        this.damage = damage;
        this.type = type;
        this.twoHanded = twoHanded;
    }
}
