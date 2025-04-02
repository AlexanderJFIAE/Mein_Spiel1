public class Enemies extends Charackter {
    int playerxp;
    public Enemies(String name, int playerxp) {
        super(name, (int) (Math.random()*playerxp +playerxp/3 + 10), (int)(Math.random()*(playerxp/4+2)+1),0);
        this.playerxp=playerxp;

    }


    @Override
    public int attack() {

        return (int) (Math.random()*10+(playerxp/10+1));

    }

    @Override
    public int defense() {
        return (int) (Math.random()*2+(playerxp/10+ 1));
    }
}
