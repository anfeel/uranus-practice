package pattern.proxy.constraint;

/**
 * 玩家接口
 * @author anfeel
 * @version $ Id:PlayerService, v 0.1 2020年08月25日 10:18 anfeel Exp $
 */
public interface PlayerService {

    public void login();

    public void build();

    public void produce();

    public void sell();

    public PlayerService getProxy();

}
