package pattern.proxy.dynamic;

/**
 * 玩家类
 * @author anfeel
 * @version $ Id:Player, v 0.1 2020年08月25日 10:21 anfeel Exp $
 */
public class Player implements PlayerService {

    @Override
    public void play() {
        System.out.println("play banished");
    }
}
