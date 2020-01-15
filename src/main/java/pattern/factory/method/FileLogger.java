package pattern.factory.method;

public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("File writing");
    }
}
