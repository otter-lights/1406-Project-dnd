package com.company;
import java.util.Random;

public class Fighter extends NonMagicUser{
    private boolean secondWind = true;

    public Fighter(String chosenRace, String name, int level){
        super(name, chosenRace, 175, 10, level);
    }
    public Fighter(String chosenRace, String name, int gold,  int xp, int hitDie, int[] abilityScores){
        super(name, chosenRace, gold, xp, hitDie, abilityScores);
    }

    public void levelUp(){
        setMaxHP(getMaxHP() + 6);
    }
    public void longRest(){
        int currentLevel = getLevel();
        if(setLevel() > currentLevel){
            //you leveled up
            levelUp();
        }
        setCurrentHP(getMaxHP());
        Store generalStore = new Store(4,4,6);
        secondWind = true;
    }

    public String getClassName(){return "Fighter";}
    public boolean getSecondWind(){return secondWind;}


    public String secondWind(){
        //allows fighter to heal yay
        Random random = new Random();
        if (secondWind){
            secondWind = false;
            int addHP = random.nextInt(10) + 1 + this.getLevel();
            if (getCurrentHP() + addHP <= getMaxHP()){
                setCurrentHP(getCurrentHP() + addHP);
                return(getName() + " heals " + addHP + " points of damage.");
            } else {
                setCurrentHP(getMaxHP());
                return(getName() + " heals to max HP.");
            }

        }
        return (getName() + " has already used Second Wind.");
    }
}
