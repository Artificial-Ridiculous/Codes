package unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    /*private Lock bankLock ;
    private Condition sufficientFunds;*/

    public Bank(int n ,double initialBanlance) {
        accounts = new double[n];
        /*bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();*/
        Arrays.fill(accounts,initialBanlance);
    }

    public synchronized double getTotalBanlance(){
        //bankLock.lock();
        try{
            double totalBanlance = 0.0;
            for(double account : accounts){
                totalBanlance += account;
            }
            return totalBanlance;
        }finally {
            //bankLock.unlock();
        }
    }

    public synchronized int getUnder0(){
        int result = 0;
        for(double account : accounts){
            if (account < 0){
                result += 1;
            }
        }
        return result;
    }

    public synchronized double getBanlance(int i){
        return accounts[i];
    }


    /*public void transfer(int from , int to ,double amount) throws InterruptedException{
        bankLock.lock();
        try{
            while (accounts[from] < amount){
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d." ,amount,from,to);
            accounts[to] += amount;
            System.out.printf(" banlance: %10.2f", getTotalBanlance());
            System.out.printf(" Under0: "+ getUnder0()+"%n");
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }*/

    public synchronized void transfer(int from , int to ,double amount) throws InterruptedException{
        //bankLock.lock();
        try{
            while (accounts[from] < amount){
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d." ,amount,from,to);
            accounts[to] += amount;
            System.out.printf(" banlance: %10.2f", getTotalBanlance());
            System.out.printf(" Under0: "+ getUnder0()+"%n");
            //sufficientFunds.signalAll();
        }finally {
            notifyAll();
        }

    }

    public int size(){
        return accounts.length;
    }

}
