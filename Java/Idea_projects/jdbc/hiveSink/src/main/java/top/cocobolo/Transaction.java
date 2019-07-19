package top.cocobolo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;

public class Transaction {
    private Integer transaction_id;
    private Integer card_number;
    private Integer terminal_id;
    private Timestamp transaction_time;
    private Integer transaction_type;
    private Float amount;

    public Transaction(Integer transaction_id, Integer card_number, Integer terminal_id, Timestamp transaction_time, Integer transaction_type, Float amount) {
        this.transaction_id = transaction_id;
        this.card_number = card_number;
        this.terminal_id = terminal_id;
        this.transaction_time = transaction_time;
        this.transaction_type = transaction_type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", card_number=" + card_number +
                ", terminal_id=" + terminal_id +
                ", transaction_time=" + transaction_time +
                ", transaction_type=" + transaction_type +
                ", amount=" + amount +
                '}';
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getCard_number() {
        return card_number;
    }

    public void setCard_number(Integer card_number) {
        this.card_number = card_number;
    }

    public Integer getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(Integer terminal_id) {
        this.terminal_id = terminal_id;
    }

    public Timestamp getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(Timestamp transaction_time) {
        this.transaction_time = transaction_time;
    }

    public Integer getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(Integer transaction_type) {
        this.transaction_type = transaction_type;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public static Transaction getRandomTransaction(){
        Integer transaction_id = (int)(1+Math.random()*(1000000000-100000000+1));
        Integer card_number = (int)(1+Math.random()*(100000000-10000000+1));
        Integer terminal_id = (int)(1+Math.random()*(10000000-1000000+1));
        Timestamp transaction_time = new Timestamp(System.currentTimeMillis());
        Integer transaction_type = (int)(1+Math.random()*(8-1+1));
        Float amount = new Random().nextFloat()*10000;

        Transaction transaction = new Transaction(transaction_id,card_number,terminal_id,transaction_time,transaction_type,amount);
        return transaction;
    }
}


