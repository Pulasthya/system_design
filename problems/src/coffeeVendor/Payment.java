package coffeeVendor;

import java.util.HashMap;
import java.time.*;

public class Payment {
    private static Payment instance = null;
    private Integer amount = 100;
    private HashMap<LocalDateTime, HashMap<String, Integer>> transactions = new HashMap<>();
    private Payment() {}

    public synchronized static Payment getInstance() {
        if (instance == null) {
            instance = new Payment();
        }

        return instance;
    }

    public synchronized Integer getAmount() {
        return amount;
    }

    public synchronized Integer depositAmount(Integer price, Integer depositValue) {
        if (depositValue < price) {
            return -1;
        }
        amount += price;
        HashMap<String, Integer> curTrans = new HashMap<>();
        curTrans.put("amount", amount);
        curTrans.put("price", price);
        curTrans.put("depositValue", depositValue);
        curTrans.put("change", depositValue - price);
        LocalDateTime curTimeStamp = LocalDateTime.now();
        transactions.put(curTimeStamp, curTrans);
        return  depositValue - price;
    }

    public synchronized HashMap<LocalDateTime, HashMap<String, Integer>> getTransactions() {
        return transactions;
    }
}
