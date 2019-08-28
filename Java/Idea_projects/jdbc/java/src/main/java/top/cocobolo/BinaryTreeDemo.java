package top.cocobolo;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryNode root = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        //先手动创建 后面递归创建二叉树
        root.setLeft(node2);
        node2.setLeft(node5);
        node2.setRight(node6);
        root.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(root);
        System.out.println("前序");
        binaryTree.preOrder();
//        System.out.println("中序");
//        binaryTree.inOrder();
//        System.out.println("后序");
//        binaryTree.postOrder();
//        System.out.println("查找val为5的node:");
//        BinaryNode res = binaryTree.preOrderSearch(5);
//        if(res == null){
//            System.out.println("未找到");
//        }else {
//            System.out.println("res = " + res);
//        }
        System.out.println("-----------");
        binaryTree.preOrderDelete(6);
        binaryTree.preOrder();

    }
}

class BinaryTree{
    private BinaryNode root;

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(root!= null){
            root.preOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }
    //中序
    public void inOrder(){
        if(root!= null){
            root.inOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }
    //后序
    public void postOrder(){
        if(root!= null){
            root.postOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

    public BinaryNode preOrderSearch(int val){
        return root.preOrderSearch(val);
    }

//    public BinaryNode preOrderSearch(int val){
//        if(root == null){
//            return null;
//        }else if(root.getVal() == val){
//            return root;
//        }else if(root.getLeft()!=null){
//            root.getLeft().
//        }
//
//    }

    public void preOrderDelete(int val){
        if(root==null){
            System.out.println("空树,无法删除节点");
        }else if(root.getVal()==val){
            root = null;
        }
        if(root.getLeft()==null){
            ;
        }else if(root.getLeft().getVal()==val){
            root.getLeft().setLeft(null);
        }else{
            root.getLeft().preOrderDelete(val);
        }
        if(root.getRight()==null){
            ;
        }else if(root.getRight().getVal()==val){
            root.getRight().setLeft(null);
        }else{
            root.getRight().preOrderDelete(val);
        }
    }
}


class BinaryNode{
    private int val;
    private BinaryNode left;
    private BinaryNode right;

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
}
