import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Logger implements Serializable {
    private static volatile Logger instance;
    private BufferedWriter writer;

    private Logger() {
        try {
            writer = new BufferedWriter(new FileWriter("app.log", true)); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        try {
            writer.write("[LOG] " + message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info(String message) {
        try {
            writer.write("[INFO] " + message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void error(String message) {
        try {
            writer.write("[ERROR] " + message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance cannot be cloned.");
    }

    protected Object readResolve() {
        return getInstance();
    }
}