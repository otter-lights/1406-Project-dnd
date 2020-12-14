package com.company;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public abstract class Player {
    private int currentHP;
    private int maxHP;
    private int positionX;
    private int positionY;
    private int userLevel;
    private int proficencyBonus;
    private int experience;
    private int hitDie;
    private int armorClass;
    private Race playerRace;
    private String name;
    private int goldPieces;
    private ArrayList<Item> inventory;
    private double carryingWeight = 0;
    private String[] standardItems = {"Padded Armor", "Hide", "Scale Mail", "Ring Mail", "Acrobat's Staff", "Horn Knife", "Bladed-Staff", "Double Scythe", "Bolas", "War Sling", "Boomerang"};
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private int[] abilityScores = new int[6];
    private int[] abilityMods = new int[6];

    public Player(String name, String chosenRace, int gold, int hitDie, int level){
        this.name = name;
        this.playerRace = new Race(chosenRace);
        this.hitDie = hitDie;
        this.goldPieces = gold;
        this.userLevel = level;

        rollAbilityScores();
        setArmorClass();
        setExperience(level);

        maxHP = (hitDie + abilityMods[2]) * userLevel;
        currentHP = maxHP;
        positionX = 0;
        positionY = 0;
        inventory = new ArrayList<>();
    }
    public Player(String name, String chosenRace, int gold, int xp, int hitDie, int[] abilityScores){
        this.name = name;
        this.playerRace = new Race(chosenRace);
        this.experience = xp;
        this.hitDie = hitDie;
        this.abilityScores = abilityScores;
        this.goldPieces = gold;

        setArmorClass();
        setLevel();

        maxHP = (hitDie + abilityMods[2]) * userLevel;
        currentHP = maxHP;
        positionX = 0;
        positionY = 0;
        inventory = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            abilityMods[i] = calculateMods(abilityScores[i]);
        }
    }
    public ArrayList<Item> getInventory(){ return this.inventory; }
    public abstract void levelUp();
    public abstract String getClassName();

    //the position is calculated by making a square of the coords.
    public int getPosition(){return (int)(Math.sqrt(Math.pow(positionX, 2) + Math.pow(positionY, 2)));}
    public int getProficencyBonus(){return proficencyBonus;}
    public int getLevel(){return userLevel;}
    public int getAC(){return armorClass;}
    public int[] getAbilityMods(){return abilityMods;}
    public int[] getAbilityScores(){return abilityScores;}
    public boolean isAlive(){return currentHP > 0;}
    public int getPurse(){return goldPieces;}
    public String getName(){return name;}
    public int getXP(){return experience;}
    public int getHitDie(){return hitDie;}

    public void spendMoney(int price){goldPieces -= price;}
    public void recieveMoney(int gold){goldPieces += gold;}

    public void takeDamage(int damage){
        currentHP -= damage;
        if(currentHP < 0){
            currentHP = 0;
        }
    }

    public Race getPlayerRace(){
        return playerRace;
    }

    public void winsAgainst(Player opponent){
        experience += 100 * opponent.getLevel();
        goldPieces += 25;
        longRest();
    }
    public void losesAgainst(Player opponent){
        experience += 50 * opponent.getLevel();
        longRest();
    }

    public void randomItems(){
        Random rand = new Random();
        for(int i = inventory.size(); i < 4; i++){
            Item it = Store.getItemFromHashMap(standardItems[rand.nextInt(standardItems.length)]);
            if(!getInventory().contains(it)){
                addToInventory(it);
            }
            else{
                i--;
            }
        }
    }


    public String attack(Player p, Weapon w){
        System.out.println(w.getRange());
        if(Math.abs(p.getPosition() - getPosition()) <= w.getRange()){
            Random rand = new Random();
            int roll = rand.nextInt(20) + 1;
            if(roll >= p.getAC()) {
                roll = rand.nextInt(w.getDamage()) + 1;
                p.takeDamage(roll);
                return(getName() + " attacks with " + w.getName() + ". Attack Hits, " + p.getName() + " takes " + roll + " damage.\n");
            }
            else{
                return(getName() + " attacks with " + w.getName() + ". Attack Misses.\n");
            }
        }
        else{
            return("Player not in range. \n");
        }
    }
    //the position is calculated by making a square of the coords.
    public String move(int x, int y){
        if(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= playerRace.getSpeed()){
            int formerX = positionX;
            int formerY = positionY;
            positionX += x;
            positionY += y;
            return(getName() + " moves from (" + formerX + "," + formerY + ") to (" + positionX + "," + positionY + "). \n");
        }
        return(getName() + " cannot move that far. \n");
    }

    public void longRest(){
        int currentLevel = userLevel;
        if(setLevel() > currentLevel){
            levelUp();
        }
        currentHP = maxHP;
    }
    public void addXP(int xp){
        experience += xp;
    }

    public void setExperience(int level) {
        if (level == 1) {
            experience = 0;
        } else if (level == 2) {
            experience = 300;
        } else if (level == 3) {
            experience = 900;
        } else if (level == 4) {
            experience = 2700;
        } else if (level == 5) {
            experience = 6500;
        } else if (level == 6) {
            experience = 14000;
        } else if (level == 7) {
            experience = 23000;
        } else if (level == 8) {
            experience = 34000;
        } else if (level == 9) {
            experience = 48000;
        } else if (level == 10) {
            experience = 64000;
        } else if (level == 11) {
            experience = 85000;
        } else if (level == 12) {
            experience = 100000;
        } else if (level == 13) {
            experience = 120000;
        } else if (level == 14) {
            experience = 140000;
        } else if (level == 15) {
            experience = 165000;
        } else if (level == 16) {
            experience = 195000;
        } else if (level == 17) {
            experience = 225000;
        } else if (level == 18) {
            experience = 265000;
        } else if (level == 19) {
            experience = 305000;
        } else if (level == 20) {
            experience = 355000;
        }
    }
    public int setLevel(){
        if(experience < 300){
            userLevel = 1;
            proficencyBonus = 2;
        }
        else if (experience < 900){
            userLevel = 2;
            proficencyBonus = 2;
        }
        else if (experience < 2700){
            userLevel = 3;
            proficencyBonus = 2;
        }
        else if(experience < 6500){
            userLevel = 4;
            proficencyBonus = 2;
        }
        else if(experience < 14000){
            userLevel = 5;
            proficencyBonus = 3;
        }
        else if(experience < 23000){
            userLevel = 6;
            proficencyBonus = 3;
        }
        else if(experience < 34000){
            userLevel = 7;
            proficencyBonus = 3;
        }
        else if(experience < 48000){
            userLevel = 8;
            proficencyBonus = 3;
        }
        else if(experience < 64000){
            userLevel = 9;
            proficencyBonus = 4;
        }
        else if(experience < 85000){
            userLevel = 10;
            proficencyBonus = 4;
        }
        else if(experience < 100000){
            userLevel = 11;
            proficencyBonus = 4;
        }
        else if(experience < 120000){
            userLevel = 12;
            proficencyBonus = 4;
        }
        else if(experience < 140000){
            userLevel = 13;
            proficencyBonus = 5;
        }
        else if(experience < 165000){
            userLevel = 14;
            proficencyBonus = 5;
        }
        else if(experience < 195000){
            userLevel = 15;
            proficencyBonus = 5;
        }
        else if(experience < 225000){
            userLevel = 16;
            proficencyBonus = 5;
        }
        else if(experience < 265000){
            userLevel = 17;
            proficencyBonus = 6;
        }
        else if(experience < 305000){
            userLevel = 18;
            proficencyBonus = 6;
        }
        else if(experience < 355000){
            userLevel = 19;
            proficencyBonus = 6;
        }
        else if(experience >= 355000){
            userLevel = 20;
            proficencyBonus = 6;
        }
        return userLevel;
    }

    // A players carrying capacity depends on the size of their Race, this function allows the item to be added to inventory as long as the total weight of the items is under their carrying capacity
    // For now I am ignoring the decrease in speed that comes with higher weights, potentially added at a later date.
    public boolean addToInventory(Item newItem){
        if((playerRace.getSize().equals("Small") || playerRace.getSize().equals("Medium")) && carryingWeight + newItem.getWeight() <= 15*abilityScores[0]){
            inventory.add(newItem);
            carryingWeight += newItem.getWeight();
            return true;
        }
        else if(playerRace.getSize().equals("Tiny") && carryingWeight + newItem.getWeight() <= (15*abilityScores[0])/2){
            inventory.add(newItem);
            carryingWeight += newItem.getWeight();
            return true;
        }
        else if((playerRace.getSize().equals("Large") || playerRace.getSize().equals("Huge") || playerRace.getSize().equals("Gargantuan")) && carryingWeight + newItem.getWeight() <= 2*15*abilityScores[0]){
            inventory.add(newItem);
            carryingWeight += newItem.getWeight();
            return true;
        }
        return false;//not added to inventory
    }
    public ArrayList<String> getWeapons(){
        ArrayList<String> weapons = new ArrayList<String>();
        for(Item i: inventory){
            if(i instanceof Weapon){
                weapons.add(i.getName());
            }
        }
        return weapons;
    }


    private void rollAbilityScores(){
        int[] abilityIncrease = playerRace.getAbilityIncrease();
        Random rand = new Random();
        //have to roll a six-sided die 4 times per ability and sum the top 3 rolls
        for (int i = 0; i < 6; i++){ // one for each ability score
            ArrayList<Integer> rolls = new ArrayList<>();
            for (int n = 0; n < 4; n++){
                rolls.add(rand.nextInt(6) + 1);
            }
            rolls.remove(Collections.min(rolls)); //just need top 3

            abilityScores[i] = rolls.stream().mapToInt(Integer::intValue).sum() + abilityIncrease[i]; // sum rolls
            abilityMods[i] = calculateMods(abilityScores[i]);
        }
    }
    public void setArmorClass(){
        boolean wearingArmor = false;
        if(inventory!=null){
            for(Item i: inventory){
                if(i instanceof Armor){
                    armorClass = ((Armor) i).getArmorClass() + abilityMods[1];
                    wearingArmor = true;
                }
            }
        }

        if(!wearingArmor){
            armorClass = 10 + abilityMods[1];
        }
    }

    public int calculateMods(int score){
        if(score <= 1){
            return -5;
        }
        else if(score == 2 || score == 3){
            return -4;
        }
        else if(score == 4 || score == 5){
            return -3;
        }
        else if(score == 6 || score == 7){
            return -2;
        }
        else if(score == 8 || score == 9){
            return -1;
        }
        else if(score == 10 || score == 11){
            return 0;
        }
        else if(score == 12 || score == 13){
            return 1;
        }
        else if(score == 14 || score == 15){
            return 2;
        }
        else if(score == 16 || score == 17){
            return 3;
        }
        else if(score == 18 || score == 19){
            return 4;
        }
        else if(score == 20 || score == 21){
            return 5;
        }
        else if(score == 22 || score == 23){
            return 6;
        }
        else if(score == 24 || score == 25){
            return 7;
        }
        else if(score == 26 || score == 27){
            return 8;
        }
        else if(score == 28 || score == 29){
            return 9;
        }
        else{
            return 10;
        }
    }

    public int getCurrentHP(){ return currentHP; }
    public void setCurrentHP(int hp){ currentHP = hp; }
    public void setMaxHP(int hp){maxHP = hp;}
    public int getMaxHP(){ return maxHP; }
    public String toString(){
        return getName() + ", a level " + getLevel() + " " + getPlayerRace().getRaceName() + ", " + getClassName();
    }
}
