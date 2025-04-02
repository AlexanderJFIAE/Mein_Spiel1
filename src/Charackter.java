public abstract  class Charackter {
    public  String name;
    public int maxhp, hp;
   public int xp, level;
    int gold,restsleft, pots;

    public Charackter(String name, int maxhp, int xp, int level) {
        this.name = name;
        this.maxhp = maxhp;
        this.hp = maxhp;
        this.xp = xp;
        this.level=level;
    }

    public abstract int attack();
    public abstract  int defense();
}
