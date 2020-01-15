package pattern.factory.abstractFactory;

public class LenovoMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Lenovo mouse clicking");
    }
}
