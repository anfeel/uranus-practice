package pattern.factory.factroyMethod;

public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("File writing");
    }
}
