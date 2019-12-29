package top.cocobolo;

/**
 * @auther lz
 * @create 2019-07-29 10:13
 */
class Node {
    int val;
    Node next;

    Node(){}
    Node(int val) {
        this.val = val;
    }
}

public class LinkedList {
    private Node head = new Node();

    public LinkedList() {

    }

    public LinkedList(int[] l){
        this();
        int n = l.length;
        Node p = this.head;
        for (int i = 0; i < n; i++) {
            p.next=new Node(l[i]);
            p=p.next;
        }
    }

    public void traversal() {
        Node p= this.head.next;
        while(p!=null){
            System.out.print("->"+p.val);
            p = p.next;

        }
        System.out.print("\n");
    }

    public boolean isEmpty(){
        return this.head.next == null;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,3,5,7};
        int[] a2 = new int[]{2,4,6,8};
        LinkedList l1 = new LinkedList(a1);
        LinkedList l2 = new LinkedList(a2);
        l1.traversal();
        l2.traversal();
        LinkedList res = merge2SortedList(l1,l2);
        res.traversal();

    }

    public static LinkedList merge2SortedList(LinkedList l1, LinkedList l2){
        LinkedList res = new LinkedList();
        Node p1 = l1.head.next;
        Node p2 = l2.head.next;
        Node p = res.head;
        while(p1!=null || p2!=null){
            if(p1 == null){  // p2一定非空
                p.next = p2;
                break;
            }else if(p2 == null){  // p1一定非空
                p.next = p1;
                break;
            }else{  // 都不空
                if(p1.val <= p2.val){
                    p.next = p1;
                    p = p.next;
                    p1 = p1.next;
                }else{
                    p.next = p2;
                    p = p.next;
                    p2=p2.next;
                }
            }
        }
        return res;
    }

}


