package pattern.factory.abstractFactory;

public class LenovoKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Lenovo keyboard typing");
    }
}
