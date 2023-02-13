import attacco.Attack;
import combattimento.Battle;
import combattimento.IBattle;
import personaggio.Charachter;
import personaggio.CharachterType;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Charachter goku = new Charachter("Goku",1000, CharachterType.Sayan,0.85, 0.70);
        goku.addAttack(new Attack("Onda Energetica", 90, 0.70));
        goku.addAttack(new Attack("Pugno del Drago", 60, 0.90));
        goku.addAttack(new Attack("Kamehameha ", 130, 0.75));
        goku.addAttack(new Attack("Genkidama", 1000, 0.35));

        Charachter majinbu = new Charachter("Majin Bu", 1000, CharachterType.Demon, 0.90, 0.55);
        majinbu.addAttack(new Attack("Kamehameha", 130, 0.75));
        majinbu.addAttack(new Attack("Masenko", 110, 0.65));
        majinbu.addAttack(new Attack("Cannone Speciale", 80, 0.85));
        majinbu.addAttack(new Attack("Finger Beam", 60, 0.90));

        IBattle battle = new Battle();
        battle.setPlayers(goku, majinbu);
        battle.fight();
    }
}
