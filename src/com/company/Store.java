package com.company;
import java.util.Arrays;


public class Store {
    //String name, int cost, double weight, int armorClass, int modifier, String type, int maxHP
    //strength = 0, dexterity = 1, constitution = 2, intelligence = 3, wisdom = 4, charisma = 5
    Armor[] armor = new Armor[] {new Armor("Cloth Armor", 1, 2.0, 11, 1, "Light", 20),
            new Armor("Padded Cloth Armor", 3, 6.0, 12, 1, "Light", 50),
            new Armor("Assassin's Garb", 120, 6.0, 12, 1,"Light", -1),
            new Armor("Plated Leather Armor", 500, 20.0, 13, 1, "Light", -1),
            new Armor("Light Wooden Armor", 50, 13.0, 12, 1, "Light", -1),
            new Armor("Battle Robe", 100, 10.0, 11, 1, "Light", -1),
            new Armor("Pumpkin Armor", 3, 13.0, 12, 1, "Medium", -1),
            new Armor("Light Leather Jacket", 10, 5.0, 11, 1, "Medium", -1),
            new Armor("Wood Armor", 30, 20.0, 13, 1, "Medium", -1),
            new Armor("Duskwood Armor", 600, 15.0, 14, 1, "Medium", -1),
            new Armor("Hero's Tunic", 1500, 30.0, 14, 1, "Medium", -1),
            new Armor("Chain Cloth", 2250, 45.0, 15, 1, "Medium", -1),
            new Armor("Magnificen Half-Plate", 1800, 25.0, 15, 1, "Medium", -1),
            new Armor("Tinkerer's Armor", 35, 20.0, 13, 0, "Heavy", -1),
            new Armor("Stone", 25, 90.0, 16, 0, "Heavy", -1),
            new Armor("Samurai Armor", 1350, 75.0, 17, 0, "Heavy", -1),
            new Armor("Wyvern Bone Armor", 600, 40.0, 17, 0, "Heavy", -1)};

    Weapon[] weapon = new Weapon[] {new Weapon("Acrobat's Staff", 3, 2.0, 4,"bludgeoning", false, true),
            new Weapon("Bladed Knuckle Duster", 2, 1.0, 4, "slashing", false, true),
            new Weapon("Brandistock", 10, 4.0, 8, "piercing", true, true),
            new Weapon("Broad Claw", 25, 3.0, 4, "slashing", false, true),
            new Weapon("Horn Knife", 10, 2.0, 4, "piercing", false, true),
            new Weapon("Motherwrench", 6, 10.0, 6, "bludgeoning", false, true),
            new Weapon("Three-Section Staff", 2, 5.0, 4, "bludgeoning", true, true),
            new Weapon("Umbrella", 5, 2.5, 6, "bludgeoning", false, true),
            new Weapon("Wakizashi", 5, 1.0, 6, "slashing", false, true),
            new Weapon("Spiked Staff", 2, 8, 8, "piercing", true, true),
            new Weapon("Mattock", 7, 3.0, 6, "slashing", false, true),
            new Weapon("Crab Claw", 10, 8.0, 4, "slashing", false, true),
            new Weapon("Bonesaw", 15, 8, 8, "slashing", false, true),
            new Weapon("Broken Greatsword", 1, 10.0, 8, "slashing", true, true),
            new Weapon("")};
}
