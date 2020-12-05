package com.company;

public class Weapon extends Item{
    int damage;
    String type;
    public Weapon(int cost, int weight, int damage, String type){
        super(cost, weight);
        this.damage = damage;
        this.type = type;
    }
}
