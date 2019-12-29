package top.cocobolo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Transaction {
    private long TransactionID;
    private long CardNumber;
    private long TerminalID;
    private Date TransactionDate;
    private Time TransactionTime;
    private int TransactionType;
    private float Amount;

    public Transaction(long transactionID, long cardNumber, long terminalID, Date transactionDate, Time transactionTime, int transactionType, float amount) {
        TransactionID = transactionID;
        CardNumber = cardNumber;
        TerminalID = terminalID;
        TransactionDate = transactionDate;
        TransactionTime = transactionTime;
        TransactionType = transactionType;
        Amount = amount;
    }

    public long getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(long transactionID) {
        TransactionID = transactionID;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(long cardNumber) {
        CardNumber = cardNumber;
    }

    public long getTerminalID() {
        return TerminalID;
    }

    public void setTerminalID(long terminalID) {
        TerminalID = terminalID;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public Time getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(Time transactionTime) {
        TransactionTime = transactionTime;
    }

    public int getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(int transactionType) {
        TransactionType = transactionType;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
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
}