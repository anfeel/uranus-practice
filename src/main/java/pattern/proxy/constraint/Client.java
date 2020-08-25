package pattern.proxy.constraint;

/**
 * 游戏客户端
 * @author anfeel
 * @version $ Id:Client, v 0.1 2020年08月25日 11:15 anfeel Exp $
 */
public class Client {

    public static void main(String[] args) throws Exception {
//        Proxy proxy = new Proxy(new Player("时间掌控者"));
//        proxy.login();
//        proxy.build();
//        proxy.produce();
//        proxy.produce();
//        proxy.sell();

//        Player player = new Player("时间掌控者");
//        Proxy proxy = new Proxy(player);
//        player.login();
//        player.build();
//        player.produce();
//        player.produce();
//        player.sell();

        Player player = new Player("时间掌控者");
        PlayerService proxy = player.getProxy();
        player.login();
        player.build();
        player.produce();
        player.produce();
        player.sell();
    }
}
