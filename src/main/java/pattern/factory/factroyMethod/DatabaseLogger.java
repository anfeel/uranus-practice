package pattern.factory.factroyMethod;

public class DatabaseLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("Database Writing");
    }
}
