package com.company;

public class Weapon extends Item{
    private String name;
    private int damage;
    private boolean twoHanded;
    private String type;
    private int range;
    public Weapon(String name, int cost, double weight, int damage, String type, boolean twoHanded, int range){
        super(cost, weight);
        this.name = name;
        this.damage = damage;
        this.type = type;
        this.twoHanded = twoHanded;
        this.range = range;
    }
    public int getRange(){return range;}
    public int getDamage(){return damage;}
}
