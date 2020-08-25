package pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;

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

        PlayerService player = new Player();
        InvocationHandler invocationHandler = new PlayerInvocationHandler(player);
        PlayerService proxy = DynamicProxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), invocationHandler);
        proxy.play();
    }
}
