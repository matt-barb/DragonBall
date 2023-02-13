package personaggio;

import attacco.Attack;

public interface ICharachter {

    public Attack getAttack();

    public Attack getBaseAttack();

    public void modifyLife(int lifePoints);

    public void resetLife();

    public boolean addAttack(Attack attack);

}
