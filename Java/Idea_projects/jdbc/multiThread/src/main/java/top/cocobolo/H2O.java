package top.cocobolo;

class H2O {
    private Object lock;
    private int h;
    private int o;
    private int O;
    private int H;
    // private boolean twoH;

    public H2O() {
        lock = new Object();
        h = 0;
        o = 0;
        H = 2;
        O = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        synchronized(lock){
            h += 1;
            while(O < 1 || (h < 2 || o < 1)){
                System.out.println("h is waiting");
                lock.wait();
            }
            if(H == 0){
                releaseHydrogen.run();
                H += 1;  // 告诉别人打印了1个H
                lock.notifyAll();
            }
            if(H == 1){
                releaseHydrogen.run();
                h -= 2;  // 花费一个h
                o -= 1;
                H += 1;  // 告诉别人打印了2个H
                O -= 1;
                lock.notifyAll();
            }
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        synchronized(lock){
            o += 1;
            while(H < 2 || (h < 2 || o < 1)){
                System.out.println("o is waiting");
                lock.wait();
            }
            releaseOxygen.run();
            O += 1;
            H -= 2;
            lock.notifyAll();
        }

    }

    public static void main(String[] args) {
        H2O h2o = new H2O();
        Thread tH1 = new Thread(new releaseHydrogen(h2o),"h1");
        Thread tH2 = new Thread(new releaseHydrogen(h2o),"h2");
        Thread tH3 = new Thread(new releaseHydrogen(h2o),"h3");
        Thread tH4 = new Thread(new releaseHydrogen(h2o),"h4");
        Thread tO1 = new Thread(new releaseOxygen(h2o),"o1");
        Thread tO2 = new Thread(new releaseOxygen(h2o),"o2");
        tO1.start();
        tO2.start();
        tH1.start();
        tH2.start();
        tH3.start();
        tH4.start();
    }

}

class releaseHydrogen implements Runnable{

    private H2O h2o;

    public releaseHydrogen(H2O h2o) {
        this.h2o = h2o;
    }

    @Override
    public void run() {
        try {
            h2o.hydrogen(() -> System.out.println("H"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class releaseOxygen implements Runnable{

    private H2O h2o;

    public releaseOxygen(H2O h2o) {
        this.h2o = h2o;
    }

    @Override
    public void run() {
        try {
            h2o.oxygen(() -> System.out.println("O"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}