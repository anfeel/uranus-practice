package pattern.proxy.dynamic;

/**
 *
 * @author anfeel
 * @version $ Id:BeforeAdvice, v 0.1 2020年08月25日 16:14 anfeel Exp $
 */
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("save game every 5minutes");
    }
}
