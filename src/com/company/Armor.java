package com.company;

public class Armor extends Item{
    private int armorClass;
    private String name;
    private int modifier;
    private int maxHP;
    private String type;

    public Armor(String name, int cost, double weight, int armorClass, int modifier, String type, int maxHP){
        super(cost, weight, name);
        this.name = name;
        this.armorClass = armorClass;
        this.modifier = modifier;
        this.maxHP = maxHP;
        this.type = type;
    }
    public int getArmorClass(){return armorClass;}

    public String toString(){
        if (this.getCost() <= 10){
            return "A relatively cheap (compared to other stuff) " + this.type.toLowerCase() + " piece of armor. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and has an armor class of " + armorClass + " .";
        } else if (this.getCost() <= 500){
            return "An expensive " + this.type.toLowerCase() + " piece of armor. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and has an armor class of " + armorClass + " .";
        } else {
            return "A VERY EXPENSIVE " + this.type.toLowerCase() + " piece of armor. It weighs " + getWeight() + " lbs, costs " + getCost() + " gold piece(s), and has an armor class of " + armorClass + " .";
        }
    }
}
