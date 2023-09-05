import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }
    public void openAccount(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            throw new RuntimeException("User already exists");
        }
        accounts.put(userId, amount);
    }
    public void closeAccount(String userId) {
        if (!accounts.containsKey(userId)) {
            throw new RuntimeException("User not found");
        }
        double balance = accounts.get(userId);
        if (balance == 0) {
            accounts.remove(userId);
        } else {
            throw new RuntimeException("Withdraw $$$ before closing");
        }
    }
    public double checkBalance(String userId) {
        if (!accounts.containsKey(userId)) {
            throw new RuntimeException("User not found");
        }
        return accounts.get(userId);
    }

    public double depositMoney(String userId, double amount) {
        if (!accounts.containsKey(userId)) {
            throw new RuntimeException("User not found");
        }
        accounts.put(userId, accounts.get(userId) + amount);
        return amount;
    }
}