package pattern.proxy.constraint;

/**
 * 玩家代理类
 * @author anfeel
 * @version $ Id:Proxy, v 0.1 2020年08月25日 10:21 anfeel Exp $
 */
public class Proxy implements PlayerService {

    private PlayerService player = null;

    public Proxy(PlayerService player) {
        this.player = player;
    }

    @Override
    public void login() {
        this.player.login();
    }

    @Override
    public void build() {
        this.player.build();
    }

    @Override
    public void produce() {
        this.player.produce();
    }

    @Override
    public void sell() {
        this.player.sell();
    }

    @Override
    public PlayerService getProxy() {
        return this;
    }

}
