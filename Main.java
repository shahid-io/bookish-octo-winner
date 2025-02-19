public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is a log message.");
        logger.info("This is an info message.");
        logger.error("This is an error message.");

        Logger anotherLogger = Logger.getInstance();
        System.out.println("Are both instances the same? " + (logger == anotherLogger) + "\n" + logger.toString()
                + " :: " + anotherLogger);
    }
}