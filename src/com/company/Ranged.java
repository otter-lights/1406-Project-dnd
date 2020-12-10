package com.company;

public class Ranged extends Weapon{
    private int range;

    public Ranged(String name, int cost, double weight, int damage, String type, boolean twoHanded, int range){
        super(name, cost, weight, damage, type, twoHanded, range);
    }
}
