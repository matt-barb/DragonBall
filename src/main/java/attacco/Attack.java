package attacco;

public class Attack {
    private final String name;
    private final int damage;
    private final double chancesOfStrike;

    public Attack(String name, int damage, double chancesOfStrike) {
        this.name = name;
        this.damage = damage;
        this.chancesOfStrike = chancesOfStrike;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getChancesOfStrike() {
        return chancesOfStrike;
    }
}
