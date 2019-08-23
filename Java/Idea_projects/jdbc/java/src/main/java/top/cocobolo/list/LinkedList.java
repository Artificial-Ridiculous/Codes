package top.cocobolo.list;

/**
 * @auther lz
 * @create 2019-07-29 10:13
 */
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
//        this.head =
    }

    public void traversal(Node head) {
        if (null != head) {
            Node p = head;
            while (null != p.next) {
                System.out.println(p.val);
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
//        LinkedList linkedList = new LinkedList(node1);
//        linkedList.traversal(node1);
    }

}


