import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Gamelogic {
    static Scanner scn = new Scanner(System.in);
    static int klassenwahl;
    static Magier pmage = new Magier("phl");
    static Krieger pkrieger = new Krieger("phl");
    static Spaeher pspaeher = new Spaeher("phl");
    static int biome=1;
    static double evadeentropie=0;
    static Random random=new Random();

    public static boolean isRunning=true;

    public static String[] encounters = {"Battle", "Battle", "Battle", "Battle", "Battle", "Rest"};

    public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};
    public static int place = 0, act = 1;
    public static String[] places = {"Feld", "Wald", "Gebirge", "Mine"};
                                    //^-place=1;^-place=2;^-place=3;^-place4
    public static int readInt(String prompt, int userchoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scn.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Bitte eine ganze Zahl eingeben");
            }

        } while (input < 1 || input > userchoices);
        return input;

    }

    public static void cleeren() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    public static void trenner(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();


    }

    public static void printkopfzeile(String titel) {
        trenner(30);
        System.out.println(titel);
        trenner(30);
    }

    public static void anythingtocontinue() {
        System.out.println("Geben sie etwas ein um Fortzufahren!");
        scn.next();
    }

    public static void startgame() {


        boolean nameSet = false;
        cleeren();
        trenner(40);
        trenner(30);
        System.out.println("Path to Ascensione");
        System.out.println("By Alexander Jessel");
        trenner(30);
        trenner(40);
        anythingtocontinue();

        while (isRunning) {
            System.out.println("Wählen sie Ihre Klasse.");
            System.out.println("1. Magier");
            System.out.println("2. Krieger");
            System.out.println("3. Späher");
            do {
                klassenwahl = scn.nextInt();
                if (klassenwahl < 1 || klassenwahl > 3) {
                    System.out.println("Ungültige Wahl, bitte wählen Sie 1, 2 oder 3.");
                }
            } while (klassenwahl < 1 || klassenwahl > 3);
            //für die namensgebung
                do {
                    if(klassenwahl==1){
                        cleeren();
                        printkopfzeile("Wie ist dein Name?");
                        pmage.name = scn.next();
                        cleeren();
                        System.out.println("Dein name ist " + pmage.name + ".\nist das richtig?");
                        System.out.println("(1) Ja");
                        System.out.println("(2) nein");
                        int input = readInt("->", 2);
                        if (input == 1)
                            nameSet = true;
                    }
                    else if (klassenwahl==2) {
                        cleeren();
                        printkopfzeile("Wie ist dein Name?");
                        pkrieger.name = scn.next();
                        cleeren();
                        System.out.println("Dein name ist " + pkrieger.name + ".\nist das richtig?");
                        System.out.println("(1) Ja");
                        System.out.println("(2) nein");
                        int input = readInt("->", 2);
                        if (input == 1)
                            nameSet = true;
                    } else if (klassenwahl==3) {
                        cleeren();
                        printkopfzeile("Wie ist dein Name?");
                        pspaeher.name = scn.next();
                        cleeren();
                        System.out.println("Dein name ist " + pspaeher.name + ".\nist das richtig?");
                        System.out.println("(1) Ja");
                        System.out.println("(2) nein");
                        int input = readInt("->", 2);
                        if (input == 1)
                            nameSet = true;
                    }

                } while (!nameSet);

                gameloop();
        }
    }

    public static void checkAct() {
        if (place == 1) {


            enemies[0] = "evil mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Slime";
            enemies[4] = "Scary Stranger";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        }
        if (place == 2) {
            enemies[0] = "evil mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Slime";
            enemies[4] = "Scary Stranger";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        }
        if (place == 3) {
            enemies[0] = "evil mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Slime";
            enemies[4] = "Scary Stranger";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        }
        if (place == 4) {
            enemies[0] = "evil mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Slime";
            enemies[4] = "Scary Stranger";

            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
        }
    }

    public static void changebiome(){
        if(biome==0) {
            place = 0;
            trenner(20);
            printkopfzeile(places[0]);
            trenner(20);
            cleeren();
            System.out.println("Möchstest du das Biome wechseln?");
            System.out.println("(1) Ja \n(2) Nein");
            int input = readInt("->", 2);
            if (input == 1) {
                System.out.println("Wohin möchtest du?");
                System.out.println("(1) " + places[1] + "\n(2) " + places[2]);
                int selcetion = readInt("->", 2);
                if (selcetion == 1) {
                    place = 1;
                    biome = 1;
                    anythingtocontinue();
                }
                if (selcetion == 2) {
                    place = 2;
                    biome = 2;
                    anythingtocontinue();
                }
            }
        }
      else if(biome==1) {
            trenner(20);
            printkopfzeile(places[1]);
            trenner(20);
            cleeren();
            System.out.println("Möchstest du den Biome wechseln?");
            System.out.println("(1) Ja \n(2) Nein");
            int input = readInt("->", 2);
            if (input == 1) {
                System.out.println("Wohin möchtest du?");
                System.out.println("(1) "+places[2]+" \n(2) " + places[0]);
                int selcetion = readInt("->", 2);
                if (selcetion == 1) {
                    place = 2;
                    biome = 2;
                    anythingtocontinue();
                }
                if (selcetion == 2) {
                    place = 0;
                    biome = 0;
                    anythingtocontinue();
                }
            }

        }
      else if(biome==2){
            trenner(20);
            printkopfzeile(places[2]);
            trenner(20);
            cleeren();
            System.out.println("Möchstest du den Biome wechseln?");
            System.out.println("(1) Ja \n(2) Nein");
            int input=readInt("->",2);
            if(input==1){
                System.out.println("Wohin möchtest du?");
                System.out.println("(1) "+ places[3]+" \n(2) " +places[1]);
                int selcetion=readInt("->",2);
                if(selcetion==1){
                    place=3;
                    biome=3;
                    anythingtocontinue();
                }
                if(selcetion==2){
                    place=1;
                    biome=1;
                    anythingtocontinue();
                }
        }
    }
        else if(biome==3) {
            trenner(20);
            printkopfzeile(places[3]);
            trenner(20);
            cleeren();
            System.out.println("Möchstest du den Biome wechseln?");
            System.out.println("(1) Ja \n(2) Nein");
            int input = readInt("->", 2);
            if (input == 1) {
                System.out.println("Wohin möchtest du?");
                System.out.println("(1) " + places[2] + " \n(2) " + places[1]);
                int selcetion = readInt("->", 2);
                if (selcetion == 1) {
                    place = 2;
                    biome = 2;
                    anythingtocontinue();
                }
                if (selcetion == 2) {
                    place = 1;
                    biome = 1;
                    anythingtocontinue();
                }
            }
        }
    }

    public static void randomEncounter() {
        int encounter = (int) (Math.random() * encounters.length);
        if (encounters[encounter].equals("Battle")) {
            randombattle();
        } else if (encounters[encounter].equals("Rest")) {
            //rest
            takerest();
        } else {
            //shop
            shop();

        }
    }

    public static void continueJourney() {
        checkAct();
        if (act != 5) {
            randomEncounter();


        }
    }

    public static void charinfo() {
        if (klassenwahl == 1) {
            cleeren();
            printkopfzeile("Charackter Info");
            System.out.println(pmage.name);
            System.out.println("HP: " + pmage.hp + "/" + pmage.maxhp);
            System.out.println("MANA: " + pmage.mana + "/" + pmage.maxmana);
            trenner(20);
            System.out.println("XP:" + pmage.xp + "\tGold: " + pmage.gold);
            System.out.println("Potions: " + pmage.pots);
            System.out.println("Mana Potions: " + pmage.manatrank);
            System.out.println("Pausen: " + pmage.restsleft);
            trenner(20);

            if (pmage.numAtkupgrades > 0) {
                System.out.println("Offensive traits " + pmage.atkUpgrades[pmage.numAtkupgrades - 1]);
                trenner(20);
            }
            if (pmage.numdefupgrades > 0) {
                System.out.println("Defensive traits " + pmage.defUpgrades[pmage.numdefupgrades - 1]);
                trenner(20);
            }
            anythingtocontinue();
        }
        if (klassenwahl == 2) {
            cleeren();
            printkopfzeile("Charackter Info");
            System.out.println(pkrieger.name);
            System.out.println("HP: " + pkrieger.hp + "/" + pkrieger.maxhp);
            trenner(20);
            System.out.println("XP:" + pkrieger.xp + "\tGold: " + pkrieger.gold);
            System.out.println("Potions: " + pkrieger.pots);
            System.out.println("Pausen: " + pkrieger.restsleft);
            trenner(20);

            if (pkrieger.numAtkupgrades > 0) {
                System.out.println("Offensive traits " + pkrieger.atkUpgrades[pkrieger.numAtkupgrades - 1]);
                trenner(20);
            }
            if (pkrieger.numdefupgrades > 0) {
                System.out.println("Defensive traits " + pkrieger.defUpgrades[pkrieger.numdefupgrades - 1]);
                trenner(20);
            }
            anythingtocontinue();
        }
        if (klassenwahl == 3) {
            cleeren();
            printkopfzeile("Charackter Info");
            System.out.println(pspaeher.name);
            System.out.println("HP: " + pspaeher.hp + "/" + pspaeher.maxhp);
            trenner(20);
            System.out.println("XP:" + pspaeher.xp + "\tGold: " + pspaeher.gold);
            System.out.println("Potions: " + pspaeher.pots);
            System.out.println("Pausen: " + pspaeher.restsleft);
            trenner(20);

            if (pspaeher.numAtkupgrades > 0) {
                System.out.println("Offensive traits " + pspaeher.atkUpgrades[pspaeher.numAtkupgrades - 1]);
                trenner(20);
            }
            if (pspaeher.numdefupgrades > 0) {
                System.out.println("Defensive traits " + pspaeher.defUpgrades[pspaeher.numdefupgrades - 1]);
                trenner(20);
            }
            anythingtocontinue();
        }
    }

    // potion kaufen für shop encounter
    public static void shop() {
        if(klassenwahl==1){
        cleeren();
        printkopfzeile("Du hast wandernen Händler gefunden.");
        int price = (int) (Math.random() * (10 + pmage.pots * 3) + 10 + pmage.pots);
        System.out.println("(1) Magischer Heiltrank: " + price + "gold.");
        int Manapotprice = (int) (Math.random() * (10 + pmage.manatrank * 3) + 10 + pmage.manatrank);
        System.out.println("(2)Magischer Manatrank: " + Manapotprice + "gold.");
        int input = readInt("->", 2);
        if(input==1) {
            trenner(20);
            System.out.println("Möchtest du einen magischen Heiltrank kaufen? \n(1) Ja \n(2) Nein");
            input = readInt("->", 2);
            if (input == 1) {
                cleeren();
                //gold check
                if (pmage.gold >= price) {
                    printkopfzeile("Du hast einen magischen Heiltrank für " + price + " gold gekauft");
                    pmage.pots++;
                    pmage.gold -= price;

                } else {
                    printkopfzeile("Du hast nicht genügend Gold");
                    anythingtocontinue();
                }

            }
        }
          else if(input==2){
            trenner(20);
            System.out.println("Möchtest du einen magischen Manatrank kaufen? \n(1) Ja \n(2) Nein");
            input = readInt("->", 2);
            if (input == 1) {
                cleeren();
                //gold check
                if (pmage.gold >= price) {
                    printkopfzeile("Du hast einen magischen Manatrank für " + price + " gold gekauft");
                    pmage.manatrank++;
                    pmage.gold -= price;

                } else {
                    printkopfzeile("Du hast nicht genügend Gold");
                    anythingtocontinue();
                }
            }
          }
        }
        if(klassenwahl==2){
            cleeren();
            printkopfzeile("Du hast wandernen Händler gefunden.");
            int price = (int) (Math.random() * (10 + pkrieger.pots * 3) + 10 + pkrieger.pots);
            System.out.println("Magischer Heiltrank: " + price + "gold.");
            trenner(20);
            System.out.println("Möchtest du einen magischen Heiltrank kaufen? \n(1) Ja \n(2) Nein");
            int input = readInt("->", 2);
            if (input == 1) {
                cleeren();
                //gold check
                if (pkrieger.gold >= price) {
                    printkopfzeile("Du hast einen magischen Heiltrank für " + price + " gold gekauft");
                    pkrieger.pots++;
                    pkrieger.gold -= price;

                } else {
                    printkopfzeile("Du hast nicht genügend Gold");
                    anythingtocontinue();
                }

            }
        }
        if(klassenwahl==3){
            cleeren();
            printkopfzeile("Du hast wandernen Händler gefunden.");
            int price = (int) (Math.random() * (10 + pspaeher.pots * 3) + 10 + pspaeher.pots);
            System.out.println("Magischer Heiltrank: " + price + "gold.");
            trenner(20);
            System.out.println("Möchtest du einen magischen Heiltrank kaufen? \n(1) Ja \n(2) Nein");
            int input = readInt("->", 2);
            if (input == 1) {
                cleeren();
                //gold check
                if (pspaeher.gold >= price) {
                    printkopfzeile("Du hast einen magischen Heiltrank für " + price + " gold gekauft");
                    pspaeher.pots++;
                    pspaeher.gold -= price;

                } else {
                    printkopfzeile("Du hast nicht genügend Gold");
                    anythingtocontinue();
                }

            }
        }
    }

    //rest
    public static void takerest() {
        if(klassenwahl==1) {
            cleeren();
            if (pmage.restsleft >= 1) {
                printkopfzeile("Möchtest du eine Pause machen?(" + pmage.restsleft + "Pausen übrig");
                System.out.println("(1) Ja \n(2) Nein");
                int input = readInt("->", 2);
                if (input == 1) {
                    cleeren();
                    if (pmage.hp < pmage.maxhp) {
                        int hprestored = (int) (Math.random() * (pmage.xp / 4 + 1) + 10);
                        pmage.hp += hprestored;
                        if (pmage.hp > pmage.maxhp) {
                            pmage.hp = pmage.maxhp;
                            System.out.println("Du hast eine Pause gemacht und " + hprestored + " Gesundheit erholt");
                            System.out.println("Du hast jetzt " + pmage.hp + "/" + pmage.maxhp + "Gesundheit");
                            pmage.restsleft--;

                        }
                    } else if (pmage.hp == pmage.maxhp) {
                        System.out.println("Du hast schon volle Gesundheit");
                        anythingtocontinue();
                    }
                } else {

                    System.out.println("Du ziehst weiter");
                    anythingtocontinue();
                }

            }

        }
        if(klassenwahl==2) {
            cleeren();
            if (pkrieger.restsleft >= 1) {
                printkopfzeile("Möchtest du eine Pause machen?(" + pkrieger.restsleft + "Pausen übrig");
                System.out.println("(1) Ja \n(2) Nein");
                int input = readInt("->", 2);
                if (input == 1) {
                    cleeren();
                    if (pkrieger.hp < pkrieger.maxhp) {
                        int hprestored = (int) (Math.random() * (pkrieger.xp / 4 + 1) + 10);
                        pkrieger.hp += hprestored;
                        if (pkrieger.hp > pkrieger.maxhp) {
                            pkrieger.hp = pkrieger.maxhp;
                            System.out.println("Du hast eine Pause gemacht und " + hprestored + " Gesundheit erholt");
                            System.out.println("Du hast jetzt " + pkrieger.hp + "/" + pkrieger.maxhp + "Gesundheit");
                            pkrieger.restsleft--;

                        }
                    } else if (pkrieger.hp == pkrieger.maxhp) {
                        System.out.println("Du hast schon volle Gesundheit");
                        anythingtocontinue();
                    }
                } else {

                    System.out.println("Du ziehst weiter");
                    anythingtocontinue();
                }

            }

        }if(klassenwahl==3) {
            cleeren();
            if (pspaeher.restsleft >= 1) {
                printkopfzeile("Möchtest du eine Pause machen?(" + pspaeher.restsleft + "Pausen übrig");
                System.out.println("(1) Ja \n(2) Nein");
                int input = readInt("->", 2);
                if (input == 1) {
                    cleeren();
                    if (pspaeher.hp < pspaeher.maxhp) {
                        int hprestored = (int) (Math.random() * (pspaeher.xp / 4 + 1) + 10);
                        pspaeher.hp += hprestored;
                        if (pspaeher.hp > pspaeher.maxhp) {
                            pspaeher.hp = pspaeher.maxhp;
                            System.out.println("Du hast eine Pause gemacht und " + hprestored + " Gesundheit erholt");
                            System.out.println("Du hast jetzt " + pspaeher.hp + "/" + pspaeher.maxhp + "Gesundheit");
                            pspaeher.restsleft--;

                        }
                    } else if (pspaeher.hp == pspaeher.maxhp) {
                        System.out.println("Du hast schon volle Gesundheit");
                        anythingtocontinue();
                    }
                } else {

                    System.out.println("Du ziehst weiter");
                    anythingtocontinue();
                }

            }

        }
    }
    //random battles

    public static void randombattle() {
        if (klassenwahl == 1) {
            cleeren();
            printkopfzeile("You encountered an Enemy ");
            anythingtocontinue();
            String enemyname= enemies[(int) (Math.random() * enemies.length)];
            battle(new Enemies(enemyname, pmage.xp));
        } else if (klassenwahl == 2) {
            cleeren();
            printkopfzeile("You encountered an Enemy ");
            anythingtocontinue();
            battle(new Enemies(enemies[(int) (Math.random() * enemies.length)], pkrieger.xp));
        }
        else if (klassenwahl == 3) {
            cleeren();
            printkopfzeile("You encountered an Enemy ");
            anythingtocontinue();
            battle(new Enemies(enemies[(int) (Math.random() * enemies.length)], pspaeher.xp));
        }
}

    //crit chance gegner
    public static boolean enemycrit() {
        double enemycritchance = 0.05;  // Default crit chance
        double critThreshold;

        // Calculate crit chance based on class selection
        if (klassenwahl == 1) {
            enemycritchance = ((pmage.xp / 10 + 10) / 2) / 100.0;
        } else if (klassenwahl == 2) {
            enemycritchance = ((pkrieger.xp / 10 + 10) / 2) / 100.0;
        } else if (klassenwahl == 3) {
            enemycritchance = ((pspaeher.xp / 10 + 10) / 2) / 100.0;
        }

        // Calculate the critical hit threshold based on crit chance
        critThreshold = 0.95 - enemycritchance;

        // Return true if a random value is less than the threshold
        return Math.random() < critThreshold;
    }

    //crit chance player
    public static boolean critchance() {
        double critchance = 0;
        if(klassenwahl==1) {
            critchance=0.05;
        }
        else if (klassenwahl==2){
            critchance=0.05;
        } else if (klassenwahl==3) {
            critchance = 0.05;
        }
            return Math.random() < critchance;

    }
    //ausweichen chance skaliert auf ausdauer
    public static boolean evadechance(){
        double evadechance=0.15-evadeentropie;
        if (klassenwahl == 3){
            evadechance+=(pspaeher.ausdauer*0.05);

        }
        return Math.random()<evadechance;
    }
// battlesystem seperiert basiert auf klassenwahl
    public static void battle(Enemies enemy) {
        if (klassenwahl == 1) {


            while (true) {

                cleeren();
                printkopfzeile(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxhp);
                printkopfzeile(pmage.name + "\nHP: " + pmage.hp + "/" + pmage.maxhp + "\n Mana: "+ pmage.mana + "/"+ pmage.maxmana);

                System.out.println("Wähle eine Aktion aus:");
                trenner(20);
                System.out.println("(1) Kämpfe \n(2) Trinke Heiltrank/Manatrank \n(3) Flüchten");
                int input = readInt("->", 3);
                //react Input

                if (input == 1) {

                    //fight
                    //dmg calc
                    // aufgeteilt in enemy crit, player crit und kein crit
                    boolean enemycritchance = enemycrit();
                    boolean playercritchance = critchance();
                    if(playercritchance && enemycritchance){
                        int dmg = pmage.attack() - enemy.defense();
                        int dmgtook = pmage.defense() - enemy.attack() * 2;
                        pmage.hp += dmgtook;

                        pmage.mana-=2;
                        if(pmage.mana<=0) {
                            pmage.mana = 0;
                            dmg = dmg / 2;

                        }
                        else{
                            pmage.mana-=2;

                        } if(dmg==0){
                            dmg=1;
                        }
                        if(dmgtook==0){
                            dmgtook=1;
                        }
                        pkrieger.hp += dmgtook;
                        enemy.hp -= dmg;
                        //dmg never zero always atleast 1
                        // dmg -= dmgtook / 2;


                        cleeren();
                        printkopfzeile("Kampf");
                        System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                        if(pmage.mana==0){
                            System.out.println("Du hast kein Mana mehr du verursachst nur die hälfte des Schadens!");
                        }
                        trenner(15);
                        System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als kritischen schaden zugefügt");
                        //dmgtook = 0;
                        anythingtocontinue();
                      /*  if (player.hp <= 0) {
                            playerdead();
                            break;
                        } else { */
                        if (enemy.hp <= 0) {
                            cleeren();
                            printkopfzeile("Du hast " + enemy.name + "besiegt");
                            pmage.xp += enemy.xp;
                            System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                            levelup();
                            //random drops
                            boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                            int goldearned = (int) (Math.random() * enemy.xp);
                            if (addRest) {
                                pmage.restsleft++;
                                System.out.println("Du hast eine Erholung verdient!");
                            }
                            if (goldearned > 0) {
                                pmage.gold += goldearned;
                                System.out.println("Du hast gold " + goldearned + " gefunden.");
                            }
                            anythingtocontinue();
                            break;

                            //}
                        } else if (pmage.hp <= 0) {
                            playerdead();
                            break;
                        }
                    }
                    if (enemycritchance) {
                        int dmg = pmage.attack() - enemy.defense();
                        int dmgtook = pmage.defense() - enemy.attack() * 2;
                        pmage.hp += dmgtook;

                        pmage.mana-=2;
                        if(pmage.mana<=0) {
                            pmage.mana = 0;
                            dmg = dmg / 2;

                        }
                        else{
                            pmage.mana-=2;

                        }
                        //dmg never zero always atleast 1
                        // dmg -= dmgtook / 2;
                        if(dmg==0){
                            dmg=1;
                        }
                        if(dmgtook==0){
                            dmgtook=1;
                        }
                        pkrieger.hp += dmgtook;
                        enemy.hp -= dmg;

                        cleeren();
                        printkopfzeile("Kampf");
                        System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                        if(pmage.mana==0){
                            System.out.println("Du hast kein Mana mehr du verursachst nur die hälfte des Schadens!");
                        }
                        trenner(15);
                        System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als kritischen schaden zugefügt");
                        //dmgtook = 0;
                        anythingtocontinue();
                      /*  if (player.hp <= 0) {
                            playerdead();
                            break;
                        } else { */
                        if (enemy.hp <= 0) {
                            cleeren();
                            printkopfzeile("Du hast " + enemy.name + "besiegt");
                            pmage.xp += enemy.xp;
                            System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                            levelup();
                            //random drops
                            boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                            int goldearned = (int) (Math.random() * enemy.xp);
                            if (addRest) {
                                pmage.restsleft++;
                                System.out.println("Du hast eine Erholung verdient!");
                            }
                            if (goldearned > 0) {
                                pmage.gold += goldearned;
                                System.out.println("Du hast gold " + goldearned + " gefunden.");
                            }
                            anythingtocontinue();
                            break;

                            //}
                        } else if (pmage.hp <= 0) {
                            playerdead();
                            break;
                        }
                    }
                    else if (playercritchance) {

                        int dmg = pmage.attack() * 2 - enemy.defense();
                        int dmgtook = pmage.defense() - enemy.attack();
                        pmage.hp += dmgtook;


                        if(pmage.mana<=0) {
                            pmage.mana = 0;
                            dmg = dmg / 2;

                        }
                        else{
                            pmage.mana-=2;

                        }
                        if(dmg==0){
                            dmg=1;
                        }
                        if(dmgtook==0){
                            dmgtook=1;
                        }
                        pkrieger.hp += dmgtook;
                        enemy.hp -= dmg;
                        cleeren();
                        printkopfzeile("Kampf");
                        System.out.println("Du hast  " + dmg + "kritschen schaden gegen " + enemy.name + " verursacht.");
                        if(pmage.mana==0){
                            System.out.println("Du hast kein Mana mehr du verursachst nur die hälfte des Schadens!");
                        }
                        trenner(15);
                        System.out.println("Der Feind  hat dir " + dmgtook * -1 + " schaden zugefügt");
                        //dmgtook = 0;
                        anythingtocontinue();

                        if (enemy.hp <= 0) {
                            cleeren();
                            printkopfzeile("Du hast " + enemy.name + "besiegt");
                            pmage.xp += enemy.xp;
                            System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                            levelup();
                            //random drops
                            boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                            int goldearned = (int) (Math.random() * enemy.xp);
                            if (addRest) {
                                pmage.restsleft++;
                                System.out.println("Du hast eine Erholung verdient!");
                            }
                            if (goldearned > 0) {
                                pmage.gold += goldearned;
                                System.out.println("Du hast gold " + goldearned + " gefunden.");
                            }
                            anythingtocontinue();
                            break;

                            //}
                        } else if (pmage.hp <= 0) {

                            playerdead();
                            break;
                        }
                    }
                    else {
                        int dmg = pmage.attack() - enemy.defense();
                        int dmgtook = pmage.defense() - enemy.attack();
                        pmage.hp += dmgtook;
                        enemy.hp -= dmg;
                        //dmg never zero always atleast 1
                        // dmg -= dmgtook / 2;
                        if(dmg==0){
                            dmg=1;
                        }
                        if(dmgtook==0){
                            dmgtook=1;
                        }
                        pkrieger.hp += dmgtook;
                        enemy.hp -= dmg;


                        cleeren();
                        printkopfzeile("Kampf");
                        System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                        trenner(15);
                        System.out.println("Der Feind  hat dir " + dmgtook * -1 + " schaden zugefügt");
                        //dmgtook = 0;
                        anythingtocontinue();
                      /* (player.hp <= 0) {
                            playerdead();
                            break;
                        } else { */
                        if (enemy.hp <= 0) {
                            cleeren();
                            printkopfzeile("Du hast " + enemy.name + "besiegt");
                            pmage.xp += enemy.xp;
                            System.out.println("Du hast " + enemy.xp + "XP bekommen.");

                            //random drops
                            boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                            int goldearned = (int) (Math.random() * enemy.xp);
                            if (addRest) {
                                pmage.restsleft++;
                                System.out.println("Du hast eine Erholung verdient!");
                            }
                            if (goldearned > 0) {
                                pmage.gold += goldearned;
                                System.out.println("Du hast gold " + goldearned + " gefunden.");
                            }
                            anythingtocontinue();
                            break;

                            //}
                        } else if (pmage.hp <= 0) {
                            playerdead();
                            break;
                        }
                    }
                }
                //potion
                else if (input == 2) {
                    cleeren();
                    if (pmage.pots > 0 && pmage.hp < pmage.maxhp) {
                        anythingtocontinue();
                        printkopfzeile("Möchtest du einen trank trinken? (" + pmage.pots + "übrig)");
                        System.out.println("(1) Ja \n(2)Nein");
                        input = readInt("->", 2);
                        if (input == 1) {
                            pmage.hp = pmage.maxhp;
                            cleeren();
                            printkopfzeile("Du hast einen Trank getrunken. Es hat deine Gesundheit erholt auf " + pmage.maxhp);
                            anythingtocontinue();
                        }
                    } else {
                        printkopfzeile("Du hast keine Tränke oder du hast volles Leben.");
                    }
                } else {
                    //wegrennen
                    cleeren();

                    if (Math.random() * 10 <= 3.5) {
                        printkopfzeile("Du bist von dem " + enemy.name + " geflüchtet!");
                        anythingtocontinue();
                        break;
                    } else {
                        printkopfzeile("Du konntest nicht entkommen.");
                        //schaden durch gegner
                        int dmgTooK = enemy.attack();
                        pmage.hp -= dmgTooK;
                        System.out.println("Du hast " + dmgTooK + " schaden erlitten");
                        anythingtocontinue();
                        if (pmage.hp <= 0) {
                            playerdead();
                        }
                    }
                }
            }
        }
        else if (klassenwahl == 2) {


                while (true) {

                    cleeren();
                    printkopfzeile(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxhp);
                    printkopfzeile(pkrieger.name + "\nHP: " + pkrieger.hp + "/" + pkrieger.maxhp);
                    System.out.println("Wähle eine Aktion aus:");
                    trenner(20);
                    System.out.println("(1) Kämpfe \n(2) Trinke Heiltrank \n(3) Flüchten");
                    int input = readInt("->", 3);
                    //react Input

                    if (input == 1) {

                        //fight
                        //dmg calc
                        // aufgeteilt in enemy crit, player crit und kein crit
                        boolean enemycritchance = enemycrit();
                        boolean playercritchance = critchance();
                        if(playercritchance && enemycritchance){
                            int dmg = pkrieger.attack() - enemy.defense();
                            int dmgtook = pkrieger.defense() - enemy.attack() * 2;
                            if(dmg==0){
                                dmg=1;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }
                            pkrieger.hp += dmgtook;
                            enemy.hp -= dmg;



                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                            trenner(15);
                            System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als kritischen schaden zugefügt");

                            anythingtocontinue();

                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pkrieger.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                levelup();

                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pkrieger.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pkrieger.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pkrieger.hp <= 0) {
                                playerdead();
                                break;
                            }
                        }
                        else if (enemycritchance) {
                            int dmg = pkrieger.attack() - enemy.defense();
                            int dmgtook = pkrieger.defense() - enemy.attack() * 2;
                            if(dmg==0){
                                dmg=1;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }
                            pkrieger.hp += dmgtook;
                            enemy.hp -= dmg;



                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                            trenner(15);
                            System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als kritischen schaden zugefügt");

                            anythingtocontinue();

                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pkrieger.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pkrieger.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pkrieger.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pkrieger.hp <= 0) {
                                playerdead();
                                break;
                            }
                        }
                        else if (playercritchance) {

                            int dmg = pkrieger.attack() * 2 - enemy.defense();
                            int dmgtook = pkrieger.defense() - enemy.attack();
                            pkrieger.hp += dmgtook;
                            enemy.hp -= dmg;
                            //dmg never zero always atleast 1
                            // dmg -= dmgtook / 2;
                            if(dmg==0){
                                dmg=1;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }


                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + "kritschen schaden gegen " + enemy.name + " verursacht.");
                            trenner(15);
                            System.out.println("Der Feind  hat dir " + dmgtook * -1 + " schaden zugefügt");
                            //dmgtook = 0;
                            anythingtocontinue();

                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pkrieger.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pkrieger.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pkrieger.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pkrieger.hp <= 0) {

                                playerdead();
                                break;
                            }
                        }
                        else {
                            int dmg = pkrieger.attack() - enemy.defense();
                            int dmgtook = pkrieger.defense() - enemy.attack();
                            if(dmg==0){
                                dmg=1;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }
                            pkrieger.hp += dmgtook;
                            enemy.hp -= dmg;

                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                            trenner(15);
                            System.out.println("Der Feind  hat dir " + dmgtook * -1 + " schaden zugefügt");
                            //dmgtook = 0;
                            anythingtocontinue();

                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pkrieger.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pkrieger.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pkrieger.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pkrieger.hp <= 0) {
                                playerdead();
                                break;
                            }
                        }
                    }
                    //potion
                    else if (input == 2) {
                        cleeren();
                        if (pkrieger.pots > 0 && pkrieger.hp < pkrieger.maxhp) {
                            anythingtocontinue();
                            printkopfzeile("Möchtest du einen trank trinken? (" + pkrieger.pots + "übrig)");
                            System.out.println("(1) Ja \n(2)Nein");
                            input = readInt("->", 2);
                            if (input == 1) {
                                pkrieger.hp = pkrieger.maxhp;
                                cleeren();
                                printkopfzeile("Du hast einen Trank getrunken. Es hat deine Gesundheit erholt auf " + pkrieger.maxhp);
                                anythingtocontinue();
                            }
                        } else {
                            printkopfzeile("Du hast keine Tränke oder du hast volles Leben.");
                        }
                    } else {
                        //wegrennen
                        cleeren();

                        if (Math.random() * 10 <= 3.5) {
                            printkopfzeile("Du bist von dem " + enemy.name + " geflüchtet!");
                            anythingtocontinue();
                            break;
                        } else {
                            printkopfzeile("Du konntest nicht entkommen.");
                            //schaden durch gegner
                            int dmgTooK = enemy.attack();
                            pkrieger.hp -= dmgTooK;
                            System.out.println("Du hast " + dmgTooK + " schaden erlitten");
                            anythingtocontinue();
                            if (pkrieger.hp <= 0) {
                                playerdead();
                            }
                        }
                    }
                }
            }
        else if (klassenwahl == 3) {

                while (true) {

                    cleeren();
                    printkopfzeile(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxhp);
                    printkopfzeile(pspaeher.name + "\nHP: " + pspaeher.hp + "/" + pspaeher.maxhp);
                    System.out.println("Wähle eine Aktion aus:");
                    trenner(20);
                    System.out.println("(1) Kämpfe \n(2) Trinke Heiltrank \n(3) Flüchten");
                    int input = readInt("->", 3);
                    //react Input

                    if (input == 1) {

                        //fight
                        //dmg calc
                        // aufgeteilt in enemy crit, player crit und kein crit
                        boolean enemycritchance = enemycrit();
                        boolean playercritchance = critchance();
                        boolean evade=evadechance();
                        if (playercritchance && enemycritchance){
                            int dmg = pspaeher.attack() - enemy.defense();
                            int dmgtook = pspaeher.defense() - enemy.attack() * 2;
                            pspaeher.hp += dmgtook;
                            enemy.hp -= dmg;
                            //dmg never zero always atleast 1
                            if(dmg==0){
                                dmg=1;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }
                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + "  kritischen schaden gegen " + enemy.name + " verursacht.");
                            if(evade){
                                dmgtook=0;
                                pspaeher.hp += dmgtook;
                                System.out.println("Du bist den Feind ausgewichen");
                                evadeentropie++;
                            }
                            else {
                                trenner(15);
                                System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als kritischen schaden zugefügt");
                                anythingtocontinue();
                                evadeentropie=0;
                            }

                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pspaeher.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                evadeentropie=0;
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pspaeher.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pspaeher.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pspaeher.hp <= 0) {
                                playerdead();
                                break;
                            }
                        }
                        if (enemycritchance) {
                            int dmg = pspaeher.attack() - enemy.defense();
                            int dmgtook = pspaeher.defense() - enemy.attack() * 2;


                            //sicherheitshalber falls dmg is negativ oder null
                            if(dmg<=0){
                                dmg=1;
                                enemy.hp -= dmg;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }



                            cleeren();
                            if(evade){
                                dmgtook=0;
                                pspaeher.hp += dmgtook;
                                System.out.println("Du bist den Feind ausgewichen");
                                evadeentropie++;
                            }
                            else {
                                trenner(15);
                                pspaeher.hp += dmgtook;
                                System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als kritischen schaden zugefügt");
                                //dmgtook = 0;
                                anythingtocontinue();
                                evadeentropie=0;
                            }
                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pspaeher.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                evadeentropie=0;
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pspaeher.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pspaeher.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                evadeentropie=0;
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pspaeher.hp <= 0) {
                                playerdead();
                                break;
                            }
                        }
                        else if (playercritchance) {

                            int dmg = pspaeher.attack() * 2 - enemy.defense();
                            int dmgtook = pspaeher.defense() - enemy.attack();
                            pspaeher.hp += dmgtook;

                            //dmg never zero always atleast 1
                            if(dmg==0){
                                dmg=1;
                                enemy.hp -= dmg;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }

                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + "kritschen schaden gegen " + enemy.name + " verursacht.");
                            trenner(15);
                            if(evade){
                                dmgtook=0;
                                pspaeher.hp += dmgtook;
                                System.out.println("Du bist den Feind ausgewichen");
                                evadeentropie++;
                            }
                            else {
                                trenner(15);
                                pspaeher.hp += dmgtook;
                                System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als schaden zugefügt");

                                anythingtocontinue();
                                evadeentropie=0;
                            }
                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pspaeher.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pspaeher.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pspaeher.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pspaeher.hp <= 0) {

                                playerdead();
                                break;
                            }
                        }
                        else {
                            int dmg = pspaeher.attack() - enemy.defense();
                            int dmgtook = pspaeher.defense() - enemy.attack();
                            pspaeher.hp += dmgtook;
                            enemy.hp -= dmg;
                            //dmg never zero always atleast 1
                            if(dmg==0){
                                dmg=1;
                            }
                            if(dmgtook==0){
                                dmgtook=1;
                            }


                            cleeren();
                            printkopfzeile("Kampf");
                            System.out.println("Du hast  " + dmg + " schaden gegen " + enemy.name + " verursacht.");
                            trenner(15);

                            if(evade){
                                dmgtook=0;
                                pspaeher.hp += dmgtook;
                                System.out.println("Du bist den Feind ausgewichen");
                                evadeentropie++;
                            }
                            else {
                                trenner(15);
                                pspaeher.hp += dmgtook;
                                System.out.println("Der Feind  hat dir " + dmgtook * -1 + "als schaden zugefügt");

                                anythingtocontinue();
                                evadeentropie=0;
                            }
                            if (enemy.hp <= 0) {
                                cleeren();
                                printkopfzeile("Du hast " + enemy.name + "besiegt");
                                pspaeher.xp += enemy.xp;
                                System.out.println("Du hast " + enemy.xp + "XP bekommen.");
                                evadeentropie=0;
                                levelup();
                                //random drops
                                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                                int goldearned = (int) (Math.random() * enemy.xp);
                                if (addRest) {
                                    pspaeher.restsleft++;
                                    System.out.println("Du hast eine Erholung verdient!");
                                }
                                if (goldearned > 0) {
                                    pspaeher.gold += goldearned;
                                    System.out.println("Du hast gold " + goldearned + " gefunden.");
                                }
                                anythingtocontinue();
                                break;

                                //}
                            } else if (pspaeher.hp <= 0) {
                                playerdead();
                                break;
                            }
                        }
                    }
                    //potion
                    else if (input == 2) {
                        cleeren();
                        if (pspaeher.pots > 0 && pspaeher.hp < pspaeher.maxhp) {
                            anythingtocontinue();
                            printkopfzeile("Möchtest du einen trank trinken? (" + pspaeher.pots + "übrig)");
                            System.out.println("(1) Ja \n(2)Nein");
                            input = readInt("->", 2);
                            if (input == 1) {
                                pspaeher.hp = pspaeher.maxhp;
                                cleeren();
                                printkopfzeile("Du hast einen Trank getrunken. Es hat deine Gesundheit erholt auf " + pspaeher.maxhp);
                                anythingtocontinue();
                            }
                        } else {
                            printkopfzeile("Du hast keine Tränke oder du hast volles Leben.");
                        }
                    } else {
                        //wegrennen
                        cleeren();

                        if (Math.random() * 10 <= 3.5) {
                            printkopfzeile("Du bist von dem " + enemy.name + " geflüchtet!");
                            anythingtocontinue();
                            break;
                        } else {
                            printkopfzeile("Du konntest nicht entkommen.");
                            //schaden durch gegner
                            int dmgTooK = enemy.attack();
                            pspaeher.hp -= dmgTooK;
                            System.out.println("Du hast " + dmgTooK + " schaden erlitten");
                            anythingtocontinue();
                            if (pspaeher.hp <= 0) {
                                playerdead();
                            }
                        }
                    }
                }
            }
        }

    public static void levelup() {
        int maxxp = 15;
        if (klassenwahl == 1) {
            maxxp += (pmage.level * 15);
            if (pmage.xp >= maxxp) {
                pmage.level++;
                pmage.xp = 0;
                int min =1;
                int max =3;
                pmage.intelligenz+= random.nextInt(max-min);
                pmage.maxmana+=random.nextInt(max-min)*4;
                pmage.maxhp+=10;

                Gamelogic.cleeren();
                Gamelogic.printkopfzeile("Nimm ein trait:");
                System.out.println("(1) " + pmage.atkUpgrades[pmage.numAtkupgrades]);
                System.out.println("(2) " + pmage.defUpgrades[pmage.numdefupgrades]);
                int input = Gamelogic.readInt("->", 2);
                Gamelogic.cleeren();
                if (input == 1) {
                    Gamelogic.printkopfzeile("Du hast gewählt " + pmage.atkUpgrades[pmage.numAtkupgrades]);
                    pmage.numAtkupgrades++;
                } else {
                    Gamelogic.printkopfzeile("Du hast gewählt " + pmage.defUpgrades[pmage.numdefupgrades]);
                    pmage.numdefupgrades++;
                }
                Gamelogic.anythingtocontinue();
            }
        }
        else if (klassenwahl == 2) {
            maxxp += (pkrieger.level * 15);
            if (pkrieger.xp >= maxxp) {
                pkrieger.level++;
                pkrieger.xp = 0;
                int min =1;
                int max =3;
                pkrieger.staerke+= random.nextInt(max-min);
                pkrieger.ruestung+=random.nextInt(max-min)*2;
                pkrieger.maxhp+=10;

                Gamelogic.cleeren();
                Gamelogic.printkopfzeile("Nimm ein trait:");
                System.out.println("(1) " + pkrieger.atkUpgrades[pkrieger.numAtkupgrades]);
                System.out.println("(2) " + pkrieger.defUpgrades[pkrieger.numdefupgrades]);
                int input = Gamelogic.readInt("->", 2);
                Gamelogic.cleeren();
                if (input == 1) {
                    Gamelogic.printkopfzeile("Du hast gewählt " + pkrieger.atkUpgrades[pkrieger.numAtkupgrades]);
                    pkrieger.numAtkupgrades++;
                } else {
                    Gamelogic.printkopfzeile("Du hast gewählt " + pkrieger.defUpgrades[pkrieger.numdefupgrades]);
                    pkrieger.numdefupgrades++;
                }
                Gamelogic.anythingtocontinue();
            }
        } else if (klassenwahl == 3) {
            maxxp += (pspaeher.level * 15);
            if (pspaeher.xp >= maxxp) {
                pspaeher.level++;
                pspaeher.xp = 0;
                int min =1;
                int max =3;
                pspaeher.agilitaet += random.nextInt(max-min);
                pspaeher.ausdauer+=random.nextInt(max-min)*4;
                pspaeher.maxhp+=10;

                Gamelogic.cleeren();
                Gamelogic.printkopfzeile("Nimm ein trait:");
                System.out.println("(1) " + pspaeher.atkUpgrades[pspaeher.numAtkupgrades]);
                System.out.println("(2) " + pspaeher.defUpgrades[pspaeher.numdefupgrades]);
                int input = Gamelogic.readInt("->", 2);
                Gamelogic.cleeren();
                if (input == 1) {
                    Gamelogic.printkopfzeile("Du hast gewählt " + pspaeher.atkUpgrades[pspaeher.numAtkupgrades]);
                    pspaeher.numAtkupgrades++;
                } else {
                    Gamelogic.printkopfzeile("Du hast gewählt " + pspaeher.defUpgrades[pspaeher.numdefupgrades]);
                    pspaeher.numdefupgrades++;
                }
                Gamelogic.anythingtocontinue();
            }

        }
    }
    //main menu
    public static void printMenu(){
        cleeren();
        printkopfzeile(places[place]);
        System.out.println("Wähle eine aktion");
        trenner(20);
        System.out.println("(1) Weitermachen mit dem Abenteuer");
        System.out.println("(2) Charackter info");
        System.out.println("(3) Biome wechseln");
        System.out.println("(4) Spiel beenden");
    }
    public static void playerdead(){
        if(klassenwahl==1) {
            cleeren();
            printkopfzeile("Du bist gestorben...");
            printkopfzeile("Du hast " + pmage.xp + " xp auf deiner Reise erworben");
            isRunning = false;
        }
        if(klassenwahl==2) {
            cleeren();
            printkopfzeile("Du bist gestorben...");
            printkopfzeile("Du hast " + pkrieger.xp + " xp auf deiner Reise erworben");
            isRunning = false;
        }
        if(klassenwahl==3) {
            cleeren();
            printkopfzeile("Du bist gestorben...");
            printkopfzeile("Du hast " + pspaeher.xp + " xp auf deiner Reise erworben");
            isRunning = false;
        }
    }

    public static void gameloop(){
        while(isRunning){
            printMenu();
            int input= readInt("->",4);
            if (input== 1){
                continueJourney();
            }
            else if (input== 2){
                charinfo();
            } else if (input ==3) {
                changebiome();
            } else if (input==4){
                isRunning=false;
            }
        }
    }
}


