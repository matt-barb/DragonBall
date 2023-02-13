package personaggio;

import attacco.Attack;

public enum CharachterType {
    Uman(5, 0.10),
    Sayan(100, 0.90),
    Nameccian(70, 0.60),
    Cyborg(95, 0.70),
    Demon(110, 0.90),
    Alien(90, 0.65);

    private final int baseDamage;
    private final double chancesOfStrike;
    private final Attack baseAttack;

    private CharachterType(int baseDamage, double chancesOfStrike) {
        this.baseDamage = baseDamage;
        this.chancesOfStrike = chancesOfStrike;
        this.baseAttack = new Attack("Attacco Fisico", this.baseDamage, this.chancesOfStrike);
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public double getChanceOfStrike() {
        return chancesOfStrike;
    }

    public Attack getBaseAttack() {
        return baseAttack;
    }
}
