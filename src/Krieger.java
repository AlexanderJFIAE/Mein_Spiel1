public  class Krieger extends Charackter {
    int staerke;
    int ruestung;
    public int numAtkupgrades, numdefupgrades;
    public String[] atkUpgrades = {"Stärker Schlag ", "Übermenschliche Stärke", "Titanische Macht", "Göttliche Stärke"};
    public String[] defUpgrades = {"Dick gepanzert", "Perferkt gerüstet", "Plattenrüstung", "Heilige Rüstung"};

    private static int BASE_ATTACK_RANDOM = 3;  // base weapon scaling
    private static int BASE_DEFENSE_RANDOM = 1; // anfagns wert für def scaling
    public Krieger(String pkname) {
        super(pkname, 100, 0,0);

        this.numAtkupgrades = 0;
        this.numdefupgrades = 0;
        this.gold = 0;
        this.restsleft = 1;
        this.pots = 0;
        this.staerke=8;
        this.ruestung=10;

    }

    @Override
    public int attack() {
        // angriffswert
        double attackValue =  (numAtkupgrades * 2) + (staerke * 0.5) + BASE_ATTACK_RANDOM;
        attackValue += Math.random() * (xp / 4 + numAtkupgrades * 3 + BASE_ATTACK_RANDOM);
        return (int) attackValue;
    }

    @Override
    public int defense() {
        // def wert
        double defenseValue = (ruestung / 10) + (numdefupgrades * 2) + (ruestung / 3);
        defenseValue += Math.random() * (ruestung / 2 + numdefupgrades * 3 + BASE_DEFENSE_RANDOM);
        return (int) defenseValue;
    }



}

