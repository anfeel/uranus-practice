package pattern.proxy.base;

/**
 * 玩家类
 * @author anfeel
 * @version $ Id:Player, v 0.1 2020年08月25日 10:21 anfeel Exp $
 */
public class Player implements PlayerService {

    private String playerName = null;

    public Player(PlayerService playerService, String name) throws Exception {
        if (playerService == null)
            throw new Exception("不能创建角色");
        else
            this.playerName = name;
    }

    @Override
    public void login() {
        System.out.println(this.playerName + "登录");
    }

    @Override
    public void build() {
        System.out.println(this.playerName + "建造贸易市场");
    }

    @Override
    public void produce() {
        System.out.println(this.playerName + "生产物品");
    }

    @Override
    public void sell() {
        System.out.println(this.playerName + "出售物品");
    }
}
