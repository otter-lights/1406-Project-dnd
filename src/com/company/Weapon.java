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

    public Weapon(String name, int cost, double weight, int damage){
        super(cost, weight);
        this.name = name;
        this.damage = damage;
    }

    public String getDamageType() { return type; }
    public String getTwoHanded() {
        if (twoHanded){
            return "This is a two-handed weapon.";
        } else {
            return "";
        }
    }
    public int getDamage() { return damage; }
}
