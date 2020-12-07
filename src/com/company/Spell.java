package com.company;

public class Spell {
    String name;
    boolean hasSave;
    String savingThrow;
    double save;
    String damageDie;
    int range;
    //cantrip is level 0
    int level;
    String damageType;

    public Spell(String name, String savingThrow, double save, String damageDie, int range, int level, String type){
        this.name = name;
        this.hasSave = true;
        this.savingThrow = savingThrow;
        this.save = save;
        this.damageDie = damageDie;
        this.range = range;
        this.level  = level;
        this.damageType = type;
    }
    public Spell(String name, String damageDie, int range, int level, String type){
        this.name = name;
        this.hasSave = false;
        this.damageDie = damageDie;
        this.range = range;
        this.level  = level;
        this.damageType = type;
    }
    public int getLevel(){return level;}


}
