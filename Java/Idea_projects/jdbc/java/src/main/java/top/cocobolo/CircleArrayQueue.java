package top.cocobolo;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());



    }


}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        array = new int[maxSize];
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public int get() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("emptyyyyyyyy");
        }else{
            int element = array[front];
            front = (front+1)%maxSize;
            return element;
        }
    }

    public void add(int num){
        if(isFull()){
            System.out.println("fullllllll");
        }else{
            array[rear] = num;
            rear = (rear+1)%maxSize;
        }
    }

}

