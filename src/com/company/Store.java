package com.company;
import java.util.Arrays;
import java.util.Random;


public class Store {
    //String name, int cost, double weight, int armorClass, int modifier, String type, int maxHP
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    private static Armor[] allArmor = new Armor[] {new Armor("Cloth Armor", 1, 2.0, 11, 1, "Light", 20),
                                                   new Armor("Padded Armor", 5, 8.0, 11, 1, "Light", 50),
                                                   new Armor("Assassin's Garb", 120, 6.0, 12, 1,"Light", -1),
                                                   new Armor("Leather Armor", 10, 10.0, 11, 1, "Light", -1),
                                                   new Armor("Light Wooden Armor", 50, 13.0, 12, 1, "Light", -1),
                                                   new Armor("Battle Robe", 100, 10.0, 11, 1, "Light", -1),
                                                   new Armor("Hide", 10, 12.0, 12, 1, "Medium", -1),
                                                   new Armor("Wood Armor", 30, 20.0, 13, 1, "Medium", -1),
                                                   new Armor("Scale Mail", 50, 45.0, 14, 1, "Medium", -1),
                                                   new Armor("Breastplate", 400, 20.0, 14, 1, "Medium", -1),
                                                   new Armor("Half plate", 750, 20.0, 15, 1, "Medium", -1),
                                                   new Armor("Ring Mail", 30, 40.0, 14, 0, "Heavy", -1),
                                                   new Armor("Chain Mail", 75, 55.0, 15, 0, "Heavy", -1),
                                                   new Armor("Splint", 200, 60.0, 17, 0, "Heavy", -1),
                                                   new Armor("Tinkerer's Armor", 35, 20.0, 13, 0, "Heavy", -1),
                                                   new Armor("Stone", 25, 90.0, 16, 0, "Heavy", -1),
                                                   new Armor("Samurai Armor", 1350, 75.0, 17, 0, "Heavy", -1),
                                                   new Armor("Wyvern Bone Armor", 600, 40.0, 17, 0, "Heavy", -1)};

    private static Melee[] allMelee = new Melee[] {new Melee("Acrobat's Staff", 3, 2.0, 4,"bludgeoning", false),
                                                   new Melee("Bladed Knuckle Duster", 2, 1.0, 4, "slashing", false),
                                                   new Melee("Brandistock", 10, 4.0, 8, "piercing", true),
                                                   new Melee("Broad Claw", 25, 3.0, 4, "slashing", false),
                                                   new Melee("Horn Knife", 10, 2.0, 4, "piercing", false),
                                                   new Melee("Motherwrench", 6, 10.0, 6, "bludgeoning", false),
                                                   new Melee("Three-Section Staff", 2, 5.0, 4, "bludgeoning", true),
                                                   new Melee("Umbrella", 5, 2.5, 6, "bludgeoning", false),
                                                   new Melee("Wakizashi", 5, 1.0, 6, "slashing", false),
                                                   new Melee("Spiked Staff", 2, 8, 8, "piercing", true),
                                                   new Melee("Mattock", 7, 3.0, 6, "slashing", false),
                                                   new Melee("Crab Claw", 10, 8.0, 4, "slashing", false),
                                                   new Melee("Bonesaw", 15, 8, 8, "slashing", false),
                                                   new Melee("Broken Greatsword", 1, 10.0, 8, "slashing", true),
                                                   new Melee("Anchor", 90, 60.0, 10, "bludgeoning", true),
                                                   new Melee("Arming Sword", 20, 3.0, 6, "piercing", false),
                                                   new Melee("Ball and Chain", 55, 12.0, 8, "bludgeoning", false),
                                                   new Melee("Battle Fan", 20, 2.0, 6, "slashing", false),
                                                   new Melee("Battle Wire", 10, 1.0, 3, "slashing", false),
                                                   new Melee("Bladed-Staff", 30, 2.0, 8, "slashing", false),
                                                   new Melee("Boar Spear", 10, 5.0, 8, "piercing", true),
                                                   new Melee("Boom Hammer", 50, 10.0, 8, "bludgeoning", false),
                                                   new Melee("Dagger Whip", 2, 2.0, 2, "slashing", false),
                                                   new Melee("Double Axe", 30, 10.0, 6, "slashing", true),
                                                   new Melee("Double Scythe", 15, 3.0, 10, "slashing", true),
                                                   new Melee("Elvish Warsword", 100, 5.0, 10, "slashing", false),
                                                   new Melee("Great-Cleaver", 23, 11.0, 10, "slashing", true)};

    private static Ranged[] allRanged = new Ranged[] {new Ranged("Axe Crossbow", 100, 28.0, 10, "piercing", true, 60),
                                                      new Ranged("Bladed Long Bow", 150, 5.5, 6, "piercing", true, 100),
                                                      new Ranged("Bolas", 1, 2.0, 4, "bludgeoning", false, 20),
                                                      new Ranged("Bowblade", 250, 10.0, 10, "piercing", true, 100),
                                                      new Ranged("Chakri", 5, 0.5, 4, "slashing", false, 20),
                                                      new Ranged("Crossbow", 300, 2.0, 6, "piercing", false, 30),
                                                      new Ranged("Greatbow", 65, 5.0, 10, "piercing", true, 200),
                                                      new Ranged("War Sling", 5, 0.5, 8, "bludgeoning", false, 60),
                                                      new Ranged("Spear-thrower", 5, 1.0, 8, "piercing", true, 50),
                                                      new Ranged("Blowgun", 1, 1.0, 1, "piercing", false, 25),
                                                      new Ranged("Boomerang", 1, 1.0, 4, "bludgeoning", false, 30),
                                                      new Ranged("Wrist Bow", 100, 3.0, 4, "piercing", false, 20),
                                                      new Ranged("Corded Harpoon Launcher", 15, 6.0, 8, "piercing", true, 45)};

    private Armor[] armor;
    private Melee[] meleeWeapons;
    private Ranged[] rangedWeapons;

    public Store(int numMelee, int numRanged, int numArmor){
        Random rand = new Random();

        armor = new Armor[numArmor];
        for(int i = 0; i < numArmor; i++){
            armor[i] = allArmor[rand.nextInt(allArmor.length)];
        }
        meleeWeapons = new Melee[numMelee];
        for(int i = 0; i < numMelee; i++){
            meleeWeapons[i] = allMelee[rand.nextInt(allMelee.length)];
        }
        rangedWeapons = new Ranged[numRanged];
        for(int i = 0; i < numRanged; i++){
            rangedWeapons[i] = allRanged[rand.nextInt(allRanged.length)];
        }
    }
    public Boolean purchase(Item item, Player customer){
        if(item.getPrice() <= customer.getPurse()){
            customer.spendMoney(item.getPrice());
            if(!customer.addToInventory(item)){
                //oops you are too weak to carry this item... "can i have my money back"
                customer.recieveMoney(item.getPrice());
                return false;
            } else {
                return true;
            }
        }
        return false;

    }

    public Armor[] getArmor() {
        return armor;
    }
    public Melee[] getMeleeWeapons(){
        return meleeWeapons;
    }
    public Ranged[] getRangedWeapons(){
        return rangedWeapons;
    }
}
