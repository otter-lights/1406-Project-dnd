package com.company;

import java.util.Objects;

public class Spell {
    String name;
    boolean hasSave;
    int savingThrow;
    double save;
    String damageDie;
    int range;
    //cantrip is level 0
    int level;
    String damageType;

    public Spell(String name, int savingThrow, double save, String damageDie, int range, int level, String type){
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
    public int getRange(){return range;}
    public boolean isHasSave(){return hasSave;}
    public int getSavingThrow(){return savingThrow;}
    public String getDamageDie(){return damageDie;}
    public double getSave(){return save;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spell)) return false;

        Spell spell = (Spell) o;
        return hasSave == spell.hasSave &&
                Double.compare(spell.save, save) == 0 &&
                range == spell.range &&
                level == spell.level &&
                Objects.equals(name, spell.name) &&
                Objects.equals(savingThrow, spell.savingThrow) &&
                Objects.equals(damageDie, spell.damageDie) &&
                Objects.equals(damageType, spell.damageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hasSave, savingThrow, save, damageDie, range, level, damageType);
    }
}
