package multiThread;

public class CreateThread2 {


    public static void main(String[] args){
        /*class MyClass implements Runnable{
            @Override
            public void run() {
                System.out.println("MyClass");
            }
        }*/
        /*Runnable mc = new Runnable(){
            @Override
            public void run() {
                System.out.println("MyClass");
            }
        };*/
        Runnable r = ()-> System.out.println("MyClass");
        Thread t2 = new Thread(r);
        t2.start();

    }


}
