public  class Spaeher extends Charackter {

    public int numAtkupgrades, numdefupgrades;
    public  int agilitaet;
    public int ausdauer;

    public String[] atkUpgrades={"Gezielter Schuss","Kopfschuss","Perfekter schuss", "Tödlicher Schuss"};
    public String[] defUpgrades={"Akrobaktische abwehr", "Holzhaut", "Fellrüstung", "Dicke Haut"};

    public Spaeher(String pspname) {
        super(pspname, 100, 0,0);

        this.numAtkupgrades=0;
        this.numdefupgrades=0;
        this.gold=0;
        this.restsleft=1;
        this.pots=0;
        this.agilitaet=5;
        this.ausdauer=5;


    }
    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4 + numAtkupgrades *3 + 3) +xp/10 +numAtkupgrades*2 +numdefupgrades+1);
    }

    @Override
    public int defense() {
        return (int) (Math.random()*(xp/4 + numdefupgrades*3 +1)+xp/10+ numdefupgrades*2) ;
    }


}

