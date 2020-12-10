package com.company;

public class Melee extends Weapon{
    public Melee(String name, int cost, double weight, int damage, String type, boolean twoHanded){
        super(name, cost, weight, damage, type, twoHanded);
    }

    public Melee(String name, int cost, double weight, int damage){
        super(cost, weight, damage);
    }
}
