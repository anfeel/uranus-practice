package pattern.factory.simpleFactory;

public class Pie implements Chart {
    public Pie() {
        this.display();
    }

    @Override
    public void display() {
        System.out.println("Pie");
    }
}
