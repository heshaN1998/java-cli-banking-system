import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime dateTme;
    private final String note;

    public Transaction(String type,double amount,String note){
        this.type=type;
        this.amount=amount;
        this.dateTme=LocalDateTime.now();
        this.note=note;
    }

    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public String getNote(){
        return note;
    }
    public  LocalDateTime getDateTime(){
        return dateTme;
    }

    @Override
    public String toString(){
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    return "[" + dateTme.format(formatter) + "]" + type+" | Amount: "+ amount + " |Note: "+ note;
}
}
