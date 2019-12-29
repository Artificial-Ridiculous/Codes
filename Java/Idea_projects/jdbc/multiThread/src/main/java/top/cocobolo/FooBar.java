package top.cocobolo;

/**
 * @auther lz
 * @create 2019-07-17 11:05
 */

public class FooBar{
    private int n;
    private boolean isFooed;
//    private Object lock;

    private FooBar(int n) {
        this.n = n;
        this.isFooed = false;
//        this.lock = new Object();
    }

    void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (this) {
                while (isFooed) {
                    this.wait();
                }
                printFoo.run();
                isFooed = true;
                this.notifyAll();
            }
        }
    }

    void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (this) {
                while (!isFooed) {
                    this.wait();
                }
                printBar.run();
                isFooed = false;
                this.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        FooBar fb = new FooBar(5);
        Thread t1 = new Thread(new printFoo(fb),"线程t1");
        Thread t2 = new Thread(new printBar(fb),"线程t2");
        t2.start();  // 注意不能是run()
        t1.start();  // 注意不能是run()
    }

}

class printFoo implements Runnable{

    private FooBar fb ;

    printFoo(FooBar fb) {
        this.fb = fb;
    }

    @Override
    public void run() {
        try {
            fb.foo(() -> System.out.println(Thread.currentThread().getName()+": Foo"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class printBar implements Runnable{
    private FooBar fb;

    printBar(FooBar fb) {
        this.fb = fb;
    }

    @Override
    public void run() {
        try {
            fb.bar(() -> System.out.println(Thread.currentThread().getName()+": Bar"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



