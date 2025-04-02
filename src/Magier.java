import java.util.Random;

public  class Magier extends Charackter {
    public int numAtkupgrades, numdefupgrades;
    public int mana, maxmana;
    public int intelligenz;
    public int manatrank;
    public Random random= new Random();
    boolean upgradeverify=false;
    public String[] atkUpgrades={"Feuververbunden","Power","Frostkälte", "Arkane Brillianz"};
    public String[] defUpgrades={"Manarüstung", "Eisenhaut", "Eisrüstung", "Manaschild"};

    public Magier(String pmname){
        super(pmname, 100,0,0);

        this.numAtkupgrades=0;
        this.numdefupgrades=0;
        this.gold=0;
        this.restsleft=1;
        this.pots=0;
        this.maxmana=50;
        this.mana=maxmana;
        this.intelligenz=8;
        this.manatrank=0;

    }

    @Override
    public int attack() {
        return (int) (Math.random()*(intelligenz/0.5 + numAtkupgrades *3 ) +numAtkupgrades*2);
    }

    @Override
    public int defense() {
        return (int) (Math.random()*(xp/4 + numdefupgrades*3 +1)+xp/10+ numdefupgrades*2) ;
    }



}
