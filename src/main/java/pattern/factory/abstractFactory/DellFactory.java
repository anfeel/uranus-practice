package pattern.factory.abstractFactory;

public class DellFactory implements PcFactory {
    @Override
    public Mouse produceMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard produceKeyboard() {
        return new DellKeyboard();
    }
}
