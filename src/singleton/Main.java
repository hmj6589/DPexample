package singleton;

// Singleton class
class Logger {
    // Private static instance of the same class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) { // 이 메소드가 처음 호출되며, instance가 null이므로
            instance = new Logger();
        }
        return instance; // 이후 호출되면 instance 반환
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Get the only instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        // Get the same instance of Logger
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verify that both references point to the same instance
        System.out.println(logger1 == logger2); // Output: true (출력)
    }
}