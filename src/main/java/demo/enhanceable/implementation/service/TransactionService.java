package demo.enhanceable.implementation.service;

import demo.enhanceable.implementation.model.Transaction;
import demo.enhanceable.implementation.model.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by michael on 17/08/2017.
 */
@Service
public class TransactionService {

    /**
     *
     * @param client
     * @return Returns a list of Transactions for the passed client
     */
    public List<Transaction> getTransactions(String client) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(TransactionType.FASTER_PAYMENTS, new Date(), BigDecimal.ONE, "John", "James"));
        transactions.add(new Transaction(TransactionType.BACS, new Date(), BigDecimal.TEN, "John", "Sarah"));
        transactions.add(new Transaction(TransactionType.ACCOUNT_TRANSFERS, new Date(), BigDecimal.TEN, "John", "Steph"));
        transactions.add(new Transaction(TransactionType.ACCOUNT_TRANSFERS, new Date(), BigDecimal.ONE, "John", "James"));
        transactions.add(new Transaction(TransactionType.BACS, new Date(), BigDecimal.ONE, "John", "Mark"));
        return transactions;
    }

}
