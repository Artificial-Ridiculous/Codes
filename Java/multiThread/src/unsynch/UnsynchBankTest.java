package unsynch;

public class UnsynchBankTest {
    public static final int NAACOUNTS = 100;
    public static final double INITIAL_BANLANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String args[]){
        Bank bank = new Bank(NAACOUNTS,INITIAL_BANLANCE);
        for(int j = 0 ;j < NAACOUNTS; j++){  //100线程
            int fromAccount = j;
            Runnable r = ()->{
                try{
                    while (true){
                        //int fromAccount = (int)(Math.random()*NAACOUNTS);
                        int toAccount = (int)(Math.random()*NAACOUNTS);
                        double amount = Math.random()*MAX_AMOUNT;
                            bank.transfer(fromAccount,toAccount,amount);
                    }
                }catch (InterruptedException e) {
                    System.out.println(e);
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
