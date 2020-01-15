package pattern.factory.abstractFactory;

public class Client {
    public static void main(String[] args) {
        PcFactory factory = new DellFactory();
        Mouse mouse = factory.produceMouse();
        mouse.click();
    }
}
