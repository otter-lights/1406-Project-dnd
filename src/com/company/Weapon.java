package com.company;

public class Weapon extends Item{
    private String name;
    private int damage;
    private String type;
    private boolean twoHanded;
    private boolean melee; //true -> melee, false -> ranged
    public Weapon(String name, int cost, double weight, int damage, String type, boolean twoHanded, boolean melee){
        super(cost, weight);
        this.name = name;
        this.damage = damage;
        this.type = type;
        this.twoHanded = twoHanded;
        this.melee = melee;
    }
}
