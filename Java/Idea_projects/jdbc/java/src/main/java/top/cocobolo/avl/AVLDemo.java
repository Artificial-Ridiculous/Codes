package top.cocobolo.avl;

public class AVLDemo {
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,3,2};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            ;
        }
    }

}

class AVLTree{
    private BinaryNode root;
}


class BinaryNode{
    private int val;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode() {
        ;
    }

    public BinaryNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "val=" + val +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序
    public void inOrder(){
        if(this.left!=null){
            this.left.inOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.inOrder();
        }
    }
    //后序
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }

        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public BinaryNode preOrderSearch(int val){
        BinaryNode res = null;
        if(this.val == val){
            return this;
        }
        if(this.left!=null) {
            res = this.left.preOrderSearch(val);
        }
        if(this.right!=null){
            res = this.right.preOrderSearch(val);
        }
        return res;
    }

    public void preOrderDelete(int val){
        if(this.left== null){
            ;
        }else if(this.left.val == val){
            this.left=null;
            return;
        }else{
            this.left.preOrderDelete(val);
        }
        if(this.right== null){
            ;
        }else if(this.right.val == val){
            this.right=null;
        }else{
            this.right.preOrderDelete(val);
        }
    }

    public int height(){
        return(Math.max(left==null?0:left.height(),right==null?0:right.height())+1);
    }

    public int leftHeight(){
        if(left==null){
            return 0;
        }else {
            return left.height();
        }
    }

    public int rightHeight(){
        if(right==null){
            return 0;
        }else {
            return right.height();
        }
    }

}