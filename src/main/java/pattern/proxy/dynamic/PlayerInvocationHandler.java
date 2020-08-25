package pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理Handler类
 * @author anfeel
 * @version $ Id:PlayerInvocationHandler, v 0.1 2020年08月25日 14:26 anfeel Exp $
 */
public class PlayerInvocationHandler implements InvocationHandler {


    /**
     * 被代理者
     */
    Class cls = null;

    /**
     * 被代理实例
     */
    Object object = null;

    /**
     * 指定代理
     * @param object
     */
    public PlayerInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.object, args);
        return result;
    }
}
