import java.util.HashMap;  
import java.util.Map;

public class Logger {
    private Map<Integer, String> logs;

    public Logger() {
        logs = new HashMap<>();
    }

    public void log(String message) {
        logs.put(logs.size() + 1, message);
    }

    public void displayLogs() {
        System.out.println("Log Transaksi:");
        for (Map.Entry<Integer, String> entry : logs.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
}