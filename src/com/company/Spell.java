package com.company;

public class Spell {
    String name;
    boolean hasSave;
    String savingThrow;
    String damageDie;
    int range;
    //cantrip is level 0
    int level;
    String damageType;

    public Spell(String name, boolean hasSave, String savingThrow, String damageDie, int range, int level, String type){
        this.name = name;
        this.hasSave = hasSave;
        this.savingThrow = savingThrow;
        this.damageDie = damageDie;
        this.range = range;
        this.level  = level;
        this.damageType = type;
    }


}
