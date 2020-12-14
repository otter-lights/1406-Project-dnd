package com.company;
import java.util.Random;


public class Race {
    private String raceName;
    private String size;
    private int baseSpeed;
    private boolean darkvision;
    //this will be a 6 int array containing the base ability score increases for each race.
    // Order is {Strength, Dex, Con, Int, Wis, Charisma}
    private int[] abilityIncrease = new int[6];

    public Race(String chosenRace){
        raceName = chosenRace;
        switch (chosenRace) {
            case "Gnome":
                //Rock Gnome Stats
                size = "Small";
                baseSpeed = 25;
                darkvision = true;

                //intelligence increase
                abilityIncrease[3] = 2;
                //con increase
                abilityIncrease[2] = 1;
                break;
            case "Halfling":
                size = "Small";
                baseSpeed = 25;
                darkvision = false;
                // sets the dex increase to +2
                abilityIncrease[1] = 2;
                // sets the con increase to +1
                abilityIncrease[2] = 1;
                break;
            case "Dwarf":
                //Hill Dwarf
                size = "Medium";
                baseSpeed = 25;
                darkvision = true;

                //con increase
                abilityIncrease[2] = 2;
                //wis increase
                abilityIncrease[4] = 1;
                break;
            case "Dragonborn":
                size = "Medium";
                baseSpeed = 30;
                darkvision = false;

                //strength increase
                abilityIncrease[0] = 2;
                //charisma increase
                abilityIncrease[5] = 1;
                break;
            case "Elf":
                //wood elf
                size = "Medium";
                baseSpeed = 30;
                darkvision = true;

                //dex increase
                abilityIncrease[1] = 2;
                //wis increase
                abilityIncrease[4] = 1;
                break;
            case "HalfElf":
                size = "Medium";
                baseSpeed = 30;
                darkvision = true;

                //charisma increase
                abilityIncrease[5] = 2;

                Random rand = new Random();
                int firstIncrease = rand.nextInt(5);
                int secondIncrease = rand.nextInt(5);

                while (secondIncrease == firstIncrease) {
                    secondIncrease = rand.nextInt(5);
                    if (secondIncrease != firstIncrease) {
                        break;
                    }
                }
                abilityIncrease[firstIncrease] = 1;
                abilityIncrease[secondIncrease] = 1;
                break;
            case "HalfOrc":
                size = "Medium";
                baseSpeed = 30;
                darkvision = true;

                //strength increase
                abilityIncrease[0] = 2;
                //con increase
                abilityIncrease[2] = 1;
                break;
            case "Human":
                size = "Medium";
                baseSpeed = 30;
                darkvision = false;

                //+1 to all scores
                abilityIncrease[0] = 1;
                abilityIncrease[1] = 1;
                abilityIncrease[2] = 1;
                abilityIncrease[3] = 1;
                abilityIncrease[4] = 1;
                abilityIncrease[5] = 1;
                break;
            case "Tiefling":
                size = "Medium";
                baseSpeed = 30;
                darkvision = true;

                //intelligence increase
                abilityIncrease[3] = 1;
                //charisma increase
                abilityIncrease[5] = 2;
                break;
            default:
                System.out.println("Invaild Race");
                break;
        }
    }
    public String getSize(){
        return size;
    }
    public int getSpeed(){return baseSpeed;}
    public String getRaceName(){return raceName;}
    //Strength, Dex, Con, Int, Wis, Charisma
    public int[] getAbilityIncrease() {return abilityIncrease;}

}
