package combattimento;

import personaggio.Charachter;

public interface IBattle {
    public void setPlayers(Charachter ch1, Charachter ch2);

    public void fight() throws InterruptedException;

    public boolean attackToScore();

    public int firstAttacker();

    public int getWinner();

    public int getDamage();

    public void reset();
}
