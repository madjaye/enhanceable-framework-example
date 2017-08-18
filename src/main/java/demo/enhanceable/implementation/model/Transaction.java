package demo.enhanceable.implementation.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by michael on 17/08/2017.
 * Class representing a transaction with a TransactionType
 */
public class Transaction {

    private TransactionType transactionType;
    private Date date;
    private BigDecimal amount;
    private String from;
    private String to;

    public Transaction(TransactionType transactionType, Date date, BigDecimal amount, String from, String to) {
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
