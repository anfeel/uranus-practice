package pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * @author anfeel
 * @version $ Id:DynamicProxy, v 0.1 2020年08月25日 16:11 anfeel Exp $
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        if (true) {
            (new BeforeAdvice()).exec();
        }

        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}
