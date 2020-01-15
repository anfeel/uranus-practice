package pattern.factory.simpleFactory;

public class Line implements Chart {
    public Line() {
        this.display();
    }

    @Override
    public void display() {
        System.out.println("Line");
    }
}
