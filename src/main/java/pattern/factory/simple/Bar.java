package pattern.factory.simple;

public class Bar implements Chart {

    public Bar(){
        this.display();
    }
    @Override
    public void display() {
        System.out.println("Bar");
    }
}
