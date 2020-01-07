package pattern.observer.multiplayer;

/**
 * 
 * @author anfeel
 * @version $Id: MultiPlayer.java, v 0.1 2020年1月7日 下午2:13:18 anfeel Exp $
 */
public class MultiPlayer {

    public static void main(String[] args) {
        AllyControlCenter acc = new ConcreteAllyControlCneter("MythKindom");

        Observer martin = new Player("Martin");
        acc.join(martin);

        Observer james = new Player("James");
        acc.join(james);

        Observer lemar = new Player("Lemar");
        acc.join(lemar);

        Observer kane = new Player("Kane");
        acc.join(kane);

        kane.beAttacked(acc);
    }
}
