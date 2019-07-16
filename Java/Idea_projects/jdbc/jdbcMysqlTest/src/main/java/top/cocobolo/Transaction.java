package top.cocobolo;

/**
 * @auther lz
 * @create 2019-07-16 15:54
 */

import java.sql.Date;
import java.sql.Time;

public class Transaction {
    private long TransactionID;
    private long CardNumber;
    private long TerminalID;
    private Date TransactionDate;
    private Time TransactionTime;
    private int TransactionType;
    private Double Amount;

    public Transaction(long transactionID, long cardNumber, long terminalID, Date transactionDate, Time transactionTime, int transactionType, Double amount) {
        TransactionID = transactionID;
        CardNumber = cardNumber;
        TerminalID = terminalID;
        TransactionDate = transactionDate;
        TransactionTime = transactionTime;
        TransactionType = transactionType;
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "TransactionID=" + TransactionID +
                ", CardNumber=" + CardNumber +
                ", TerminalID=" + TerminalID +
                ", TransactionDate=" + TransactionDate +
                ", TransactionTime=" + TransactionTime +
                ", TransactionType=" + TransactionType +
                ", Amount=" + Amount +
                '}';
    }

    public long getTransactionID() {
        return TransactionID;
    }


    public long getCardNumber() {
        return CardNumber;
    }

    public long getTerminalID() {
        return TerminalID;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public Time getTransactionTime() {
        return TransactionTime;
    }

    public int getTransactionType() {
        return TransactionType;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setTransactionID(long transactionID) {
        TransactionID = transactionID;
    }

    public void setCardNumber(long cardNumber) {
        CardNumber = cardNumber;
    }

    public void setTerminalID(long terminalID) {
        TerminalID = terminalID;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public void setTransactionTime(Time transactionTime) {
        TransactionTime = transactionTime;
    }

    public void setTransactionType(int transactionType) {
        TransactionType = transactionType;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

}
