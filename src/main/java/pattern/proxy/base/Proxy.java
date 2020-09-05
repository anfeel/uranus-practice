package pattern.proxy.base;

/**
 * 玩家代理类
 * @author anfeel
 * @version $ Id:Proxy, v 0.1 2020年08月25日 10:21 anfeel Exp $
 */
public class Proxy implements PlayerService {

    private PlayerService player = null;


    /**
     * 代理模式的精华，在代理者构造方法里创建被代理的实例
     * @param name
     * @throws Exception
     */
    public Proxy(String name) throws Exception {
        player = new Player(this, name);
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
}
