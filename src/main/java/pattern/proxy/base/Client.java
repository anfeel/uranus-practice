package pattern.proxy.base;

/**
 * 游戏客户端
 * @author anfeel
 * @version $ Id:Client, v 0.1 2020年08月25日 11:15 anfeel Exp $
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Proxy proxy = new Proxy("法外狂徒");
        proxy.login();
        proxy.build();
        proxy.produce();
        proxy.produce();
        proxy.sell();
    }
}
