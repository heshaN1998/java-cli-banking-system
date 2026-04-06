import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String,BankAccount> accounts;
    private int accuntCounter;

    public Bank(){
        this.accounts= new HashMap<>();
        this.accuntCounter-=1001;
    }
}
