package combattimento;

import attacco.Attack;
import personaggio.Charachter;

import java.sql.SQLOutput;
import java.util.Random;

public class Battle implements IBattle{
    private Charachter[] players = new Charachter[2];
    private int attacker = -1;
    private int defender = -1;
    private int winner = -1;
    private Attack attackUsed;

    @Override
    public void setPlayers(Charachter ch1, Charachter ch2) {
        players[0] = ch1;
        players[1] = ch2;
    }

    @Override
    public void fight() throws InterruptedException {
        System.out.println(players[0].getName() + " \uD83C\uDD9A " + players[1].getName());
        Thread.sleep(1000);
        System.out.println("START!!!");
        Thread.sleep(1000);

        attacker = firstAttacker();
        defender = getDefender();
        while (true) {
            winner = getWinner();
            if (winner != -1) break;
            attackUsed = players[attacker].getAttack();
            //GAME PRINT 1
            System.out.println("======================================");
            System.out.println(players[attacker].getName() + ": " + attackUsed.getName().toUpperCase() + "!!");
            Thread.sleep(1000);
            if (attackToScore()) {
                int damage = getDamage();
                players[defender].modifyLife(damage);
                //GAME PRINT 2
                System.out.println(players[defender].getName() + ": Ahhrg! Mi hai preso!\uD83D\uDCA2" + "\n" + players[defender].getName() +"❌ -" + damage + " ==> " + players[defender].getLifePoints() + "\uD83D\uDD0B↯");
            } else System.out.println(players[defender].getName() + ": Non mi hai fatto niente!\uD83D\uDE24"); //GAME PRINT 3
            Thread.sleep(1000);
            switchRole();
        }
        //GAME PRINT 4
        System.out.println("\n" + players[winner ^ 1].getName() + ": Hai vinto questa battaglia...ma non è finita qui!"); //GAME PRINT
        System.out.println("The Winner is");
        Thread.sleep(1000);
        System.out.println("捷\uD83C\uDF8A" + players[winner].getName() + "\uD83C\uDF8A捷");
        reset();
    }

    @Override
    public boolean attackToScore() {
        int percentage = (int) (attackUsed.getChancesOfStrike() * players[defender].getChancesOfDodging() * 100);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        return rand.nextInt(100) < percentage;
    }

    @Override
    public int firstAttacker() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(players.length);
    }

    @Override
    public int getWinner() {
        //ritorna il vincitore;
        int lifeCh1 = players[0].getLifePoints();
        int lifeCh2 = players[1].getLifePoints();

        if (lifeCh1 <= 0) return 1;
        if (lifeCh2 <= 0) return 0;
        return -1;
    }

    @Override
    public int getDamage() {
        return (int) (attackUsed.getDamage() * players[defender].getStrength());
    }

    @Override
    public void reset() {
        players[0].resetLife();
        players[1].resetLife();
    }

    public int getDefender() {
        if (attacker != -1) {
            if (attacker == 0) return 1;
            else return 0;
        } else return -1;
    }

    public void switchRole() {
        int tmp = attacker;
        attacker = defender;
        defender = tmp;
    }
}
