package pattern.factory.simpleFactory;

public class ChartFactory {
    public static Chart getChart(String type) {
        Chart chart = null;
        switch (type) {
            case "Pie":
                chart = new Pie();
                break;
            case "Bar":
                return new Bar();
            case "Line":
                return new Line();
            default:
                return null;

        }
        return chart;
    }

    public static void main(String[] args) {
        ChartFactory.getChart("Pie");
    }
}
