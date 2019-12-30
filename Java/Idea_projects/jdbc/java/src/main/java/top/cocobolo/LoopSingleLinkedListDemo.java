package top.cocobolo;

public class LoopSingleLinkedListDemo {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,4,5};
        LoopSingleLinkedList l1 = new LoopSingleLinkedList(a1);
        l1.traversal();
        l1.josephu(1,2);
    }
}

class LoopSingleLinkedList{
    Node first;
    int size;

    public LoopSingleLinkedList(int[] arr){
        int n = arr.length;
        size = n;
        Node last = null;
        for (int i = 0; i < n; i++) {
            Node current = new Node(arr[i]);
            if(i==0){
                first = current;
                last = current;
            }else{
                last.next=current;
                last=last.next;
            }
        }
        last.next=first;
    }

    public void traversal(){
        Node p = this.first;
        for (int i = 0; i < size; i++) {
            System.out.print("->"+p.val);
            p=p.next;
        }
        System.out.print("\n");
    }

    public void josephu(int k,int m){
        Node p = this.first;
        for (int i = 0; i < (k - 1); i++) {
            p = p.next;
        }
        // 此时p为第k个人   他报1
        while(size > 0){
            if(m ==1){
                for (int i = 0; i < (size - 1); i++) {
                    p = p.next;
                }
            }else {
                for (int i = 0; i < m-2; i++) {
                    p=p.next;
                }
            }
            System.out.print(p.next.val+" ");
            p.next=p.next.next;
            p=p.next;
            size--;
        }
    }


}

