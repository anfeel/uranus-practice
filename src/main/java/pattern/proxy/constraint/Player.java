package pattern.proxy.constraint;

/**
 * 玩家类
 * @author anfeel
 * @version $ Id:Player, v 0.1 2020年08月25日 10:21 anfeel Exp $
 */
public class Player implements PlayerService {

    private String playerName = null;

    private PlayerService proxy = null;

    public Player(String name) {
        this.playerName = name;
    }

    /**
     * 强制代理
     * @return
     */
    private boolean isProxy() {
        if (this.proxy == null)
            return false;
        else
            return true;
    }

    /**
     * 强制代理模式的精华，必须要通过被代理者生产的代理去调用服务
     * @return
     */
    @Override
    public PlayerService getProxy() {
        this.proxy = new Proxy(this);
        return this.proxy;
    }

    @Override
    public void login() {
        if (this.isProxy())
            System.out.println(this.playerName + "登录");
        else
            System.out.println("请使用代理");
    }

    @Override
    public void build() {
        if (this.isProxy())
            System.out.println(this.playerName + "建造贸易市场");
        else
            System.out.println("请使用代理");
    }

    @Override
    public void produce() {
        if (this.isProxy())
            System.out.println(this.playerName + "生产物品");
        else
            System.out.println("请使用代理");
    }

    @Override
    public void sell() {
        if (this.isProxy())
            System.out.println(this.playerName + "出售物品");
        else
            System.out.println("请使用代理");
    }


}
