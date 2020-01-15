package pattern.factory.simple;

public class Line implements Chart {
    public Line(){
        this.display();
    }
    @Override
    public void display() {
        System.out.println("Line");
    }
}
