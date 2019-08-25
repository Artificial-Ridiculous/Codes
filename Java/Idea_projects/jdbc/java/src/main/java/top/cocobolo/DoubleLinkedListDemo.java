package top.cocobolo;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,4,5};
        int[] a2 = new int[]{2,4,6,8,10};
        DoubleLinkedList l1 = new DoubleLinkedList(a1);
        DoubleLinkedList l2 = new DoubleLinkedList(a2);
        l1.traversal();
        l2.traversal();
    }
}

class DoubleLinkedList{
    DoubleLinkedNode head = new DoubleLinkedNode();
    DoubleLinkedNode tail = new DoubleLinkedNode();

    public DoubleLinkedList(){
        head.next = tail;
        tail.pre = head;
    }

    public DoubleLinkedList(int[] arr){
        this();
        int n = arr.length;
        DoubleLinkedNode p = this.head;
        for (int i = 0; i < n; i++) {
            add(new DoubleLinkedNode(arr[i]));
        }
    }

    public void add(DoubleLinkedNode node){
        node.next = tail;
        node.pre = tail.pre;
        node.pre.next=node;
        tail.pre = node;
    }

    public void traversal(){
        DoubleLinkedNode p= this.head.next;
        while(true){
            if(p!= null){
                if(p.next == null){ // p其实是tail
                    break;
                }else{ // p还没到tail
                    System.out.print("->"+p.val);
                    p=p.next;
                }
            }else{
                break;
            }
        }
        System.out.print("\n");
    }

}


class DoubleLinkedNode{
    int val;
    DoubleLinkedNode pre;
    DoubleLinkedNode next;

    public DoubleLinkedNode(){
        ;
    }

    public DoubleLinkedNode(int val){
        this.val = val;
    }
}
