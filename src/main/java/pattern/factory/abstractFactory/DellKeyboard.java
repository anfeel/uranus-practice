package pattern.factory.abstractFactory;

public class DellKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Dell keyboard typing");
    }
}
