package top.cocobolo;

import java.util.function.IntConsumer;

/**
 * @auther lz
 * @create 2019-07-17 11:05
 */

public class FooBar{
    private int n;
    private boolean isFooed;
    private Object lock;

    public FooBar(int n) {
        this.n = n;
        this.isFooed = false;
        this.lock = new Object();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                while (isFooed) {
                    lock.wait();
                }
                printFoo.run();
                isFooed = true;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock) {
                while (!isFooed) {
                    lock.wait();
                }
                printBar.run();
                isFooed = false;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        FooBar fb = new FooBar(5);
        Thread t1 = new Thread(new printFoo(fb));
        Thread t2 = new Thread(new printBar(fb));
        t2.start();  // 注意不能是run()
        t1.start();  // 注意不能是run()
    }

}

class printFoo implements Runnable{

    FooBar fb ;

    public printFoo(FooBar fb) {
        this.fb = fb;
    }

    @Override
    public void run() {
        try {
            fb.foo(() -> System.out.print("Foo"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class printBar implements Runnable{
    FooBar fb;

    public printBar(FooBar fb) {
        this.fb = fb;
    }

    @Override
    public void run() {
        try {
            fb.bar(() -> System.out.print("Bar"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



