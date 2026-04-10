import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime dateTime;
    private final String note;

    public Transaction(String type, double amount, String note) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.note = note;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "[" + dateTime.format(formatter) + "]" + type + " | Amount: " + amount + " |Note: " + note;
    }
}
