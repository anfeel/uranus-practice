package pattern.factory.abstractFactory;

public class LenovoFactory implements PcFactory {
    @Override
    public Mouse produceMouse() {
        return new LenovoMouse();
    }

    @Override
    public Keyboard produceKeyboard() {
        return new LenovoKeyboard();
    }
}
