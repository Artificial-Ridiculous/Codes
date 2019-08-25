package top.cocobolo;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        SingleNode hero1 = new SingleNode(1, "宋江", "及时雨");
        SingleNode hero2 = new SingleNode(2, "卢俊义", "玉麒麟");
        SingleNode hero3 = new SingleNode(3, "吴用", "智多星");
        SingleNode hero4 = new SingleNode(4, "林冲", "豹子头");
        list.smartAdd(hero2);
        list.smartAdd(hero1);
        list.smartAdd(hero4);
        list.smartAdd(hero3);
        list.traversal();
        list.update(new SingleNode(3, "如果你看见我", "代表update成功"));
        list.traversal();
//        list.update(new SingleNode(5, "冲林", "头豹子"));
//        list.traversal();
        list.delete(3);
        list.traversal();
//        list.delete(5);
        System.out.println("list.countNodes = " + list.countNodes());
        list.reverse();
        list.traversal();
        list.findKth(4);
    }

}

//管理一个链表  带有头结点
class SingleLinkedList {
    private SingleNode head = new SingleNode(0, "", "");

    //向链表中添加节点  永远在末尾添加
    public void add(SingleNode node) {
        SingleNode p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        node.next = null;
    }


    //向链表中添加节点  按照no的大小插入到链表中合适的位置
    public void smartAdd(SingleNode node) throws RuntimeException {
        int no = node.no;
        SingleNode p = this.head;
        while (true) {
            if (p.next == null) {
                break;
            } else if (p.next.no == no) {
                throw new RuntimeException("id冲突  添加失败");
            } else if (p.next.no > no) {
                break;
            }
            p = p.next;
        }
        SingleNode temp = p.next;
        p.next = node;
        node.next = temp;
    }

    public void update(SingleNode node) {
        SingleNode target = foundThis(node.no);
        target.name = node.name;
        target.nickName = node.nickName;

    }

    //打印链表中所有节点
    public void traversal() {
        SingleNode p = this.head;
        while (p.next != null) {
            p = p.next;
            System.out.println("p = " + p);

        }
        System.out.println("---------------------------------");
    }

    public void delete(int no) {
        SingleNode prior = foundPrior(no);
        prior.next = prior.next.next;

    }

    public SingleNode foundThis(int no) throws RuntimeException {
        SingleNode p = this.head;
        boolean found = false;
        while (true) {
            p = p.next;
            if (p == null) {  // 到头了  没找到
                break;
            } else if (no == p.no) {  // 找到
                found = true;
                break;
            } else if (no > p.no) {  // 还没找完  继续往下找
                ;
            } else {  // 上一个不是 这一个已经过了
                break;
            }
        }
        if (found) {
            return p;
        } else {
            throw new RuntimeException("not found");
        }
    }

    public SingleNode foundPrior(int no) throws RuntimeException {
        SingleNode p = this.head;
        boolean found = false;
        while (true) {
            if (p.next == null) {
                break;
            } else if (no == p.next.no) {
                found = true;
                break;
            } else if (no > p.next.no) {
                p = p.next;
            } else {
                break;
            }
        }
        if (found) {
            return p;
        } else {
            throw new RuntimeException("not found");
        }
    }

    public int countNodes() {
        SingleNode p = this.head.next;
        int res = 0;
        while (true) {
            if (p != null) {
                res += 1;
                p = p.next;
            } else {
                break;
            }
        }
        return res;
    }

    public void reverse(){
        SingleNode p = this.head;
        p.next = reverseWithoutHead(head.next);
    }

    private SingleNode reverseWithoutHead(SingleNode node){
        if (node == null || node.next==null){
            return node;
        }
        SingleNode res = reverseWithoutHead(node.next);
        node.next.next=node;
        node.next=null;
        return res;
    }

    public SingleNode findKth(int k){
        boolean found = false;
        int count = 0;
        SingleNode p = this.head;
        while(count < k && p!= null){
            p = p.next;
            count++;
        }
        if(p==null){
            throw new RuntimeException("don't have "+k+"th element");
        }else{
            return p;
        }
    }



}

//单链表节点定义
class SingleNode {
    int no;
    String name;
    String nickName;
    SingleNode next;

    public SingleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        next = null;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
//                ", next=" + next +
                '}';
    }
}