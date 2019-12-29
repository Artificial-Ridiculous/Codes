package top.cocobolo;

public class StackDemo {
    public static void main(String[] args) {
//        int[] a1 = new int[]{1,2,3,4,5};
//        Stack stack=new Stack(a1);
        Stack stack=new Stack();
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

class Stack{
    int[] data;
    int capacity;
    int top =-1;
    static final int defaultCapacity = 100;

    public Stack(){
        data = new int[defaultCapacity];
        capacity = defaultCapacity;
    }

    public Stack(int capacity){
        data = new int[capacity];
        this.capacity=capacity;
    }

    public Stack(int [] a1){
        this();
        int n = a1.length;
        for (int i = 0; i < n; i++) {
            push(a1[i]);
        }
    }

    public void push(int nums){
        if(isFull()){
            throw new RuntimeException("stack is full");
        }else{
            data[++top]=nums;
        }
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }else{
            return data[top--];
        }
    }

    public void traversal(){
        while(top!= -1){
            System.out.print(data[top--] +" ");
        }
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==top-1;
    }



}
