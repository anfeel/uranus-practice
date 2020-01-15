package pattern.factory.factroyMethod;

public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger();
        logger.writeLog();
    }
}
