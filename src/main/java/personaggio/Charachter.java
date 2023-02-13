package personaggio;

import attacco.Attack;

import java.util.Random;

public class Charachter implements ICharachter{
    private static final int TOTAL_ATTACKS = 5;
    private static final int BASE_ATTACK = 0;
    private static final int MAX_LIFE = 100;

    private final String name;
    private int lifePoints;
    private final CharachterType type;
    private final int physicalPower;        //forza fisica
    private final double strength;          //resistenza
    private final double chancesOfDodging;  //probabilità di schivare
    private Attack[] attacks = new Attack[TOTAL_ATTACKS];

    public Charachter(String name, int lifePoints, CharachterType type, double strength, double chancesOfDodging) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.type = type;
        this.physicalPower = type.getBaseDamage();
        this.strength = strength;
        this.chancesOfDodging = chancesOfDodging;
        this.attacks[BASE_ATTACK] = type.getBaseAttack();
    }

    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public double getStrength() {
        return strength;
    }

    public double getChancesOfDodging() {
        return chancesOfDodging;
    }

    @Override
    public Attack getAttack() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return attacks[random.nextInt(TOTAL_ATTACKS)];
    }

    @Override
    public Attack getBaseAttack() {
        return attacks[BASE_ATTACK];
    }

    @Override
    public void modifyLife(int lifePoints) {
        this.lifePoints -= lifePoints;
        if (this.lifePoints < 0) this.lifePoints = 0;
    }

    @Override
    public void resetLife() {
        this.lifePoints = MAX_LIFE;
    }

    @Override
    public boolean addAttack(Attack attack) {
        int i = 1;
        while (i < TOTAL_ATTACKS) {
            if (attacks[i] == null) {
                attacks[i] = attack;
                return true;
            }
            else i++;
        }
        return false;
    }
}
