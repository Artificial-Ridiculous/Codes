package top.cocobolo.avl;

public class AVLDemo {
    public static void main(String[] args) {
        int[] arr = {10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new BinaryNode(arr[i]));
        }

//        System.out.println("中序遍历");
        avlTree.inOrder();
//        System.out.println("平衡前");
//        System.out.println("avlTree.getRoot().getHeight() = " + avlTree.getRoot().getHeight());
//        System.out.println("avlTree.getRoot().leftHeight() = " + avlTree.getRoot().leftHeight());
//        System.out.println("avlTree.getRoot().rightHeight() = " + avlTree.getRoot().rightHeight());
//        System.out.println("平衡后");
//        avlTree.getRoot().leftSpin();
        System.out.println("avlTree.getRoot().getHeight() = " + avlTree.getRoot().getHeight());
        System.out.println("avlTree.getRoot().leftHeight() = " + avlTree.getRoot().leftHeight());
        System.out.println("avlTree.getRoot().rightHeight() = " + avlTree.getRoot().rightHeight());


    }

}

class AVLTree {
    private BinaryNode root;

    public BinaryNode getRoot() {
        return root;
    }

    public void add(BinaryNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
//            if (node.getVal() < root.getVal()) {
//                if (root.getLeft() == null) {
//                    root.setLeft(node);
//                } else {
//                    root.getLeft().add(node);
//                }
//            } else {
//                if (root.getRight() == null) {
//                    root.setRight(node);
//                } else {
//                    root.getRight().add(node);
//                }
//            }
        }
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("bst为空 无法遍历");
        } else {
            if (root.getLeft() != null) {
                root.getLeft().inOrder();
            }
            System.out.println(root);
            if (root.getRight() != null) {
                root.getRight().inOrder();
            }
        }
    }

    public BinaryNode findParent(int val) {
        if (root == null) {
            return null;
        } else if (root.getVal() == val) {
            //注意 由于根节点没有parent  所以即使在根节点找到了 也返回null
            //所以当返回null时记得检测根节点是不是要找的节点
            return null;
        } else if (val < root.getVal()) {
            if (root.getLeft() == null) {
                return null;
            } else if (root.getLeft().getVal() == val) {
                return root;
            } else {
                return root.getLeft().findParent(val);
            }
        } else {
            if (root.getRight() == null) {
                return null;
            } else if (root.getRight().getVal() == val) {
                return root;
            } else {
                return root.getRight().findParent(val);
            }
        }
    }

    public BinaryNode findNode(int val) {
        if (root == null) {
            return null;
        } else {
            return root.findNode(val);
        }
    }

    public BinaryNode deleteNode(int val) {
        //空树
        if (root == null) {
            return null;
        }
        //没有该val对应的节点
        BinaryNode target = findNode(val);
        BinaryNode parent = findParent(val);
        if (target == null) {
            return null;
        } else {
            //找到了该节点
            if (target.getRight() == null && target.getLeft() == null) {
                //待删除节点没有子树  直接删除
                if (parent == null) {
                    //没有子树 也没有父节点  说明这棵树里只有这唯一的节点
                    root = null;
                    return target;
                } else {
                    //有父节点  但没有子树  直接干掉
                    //待删除节点是其父节点的左节点
                    if (parent.getLeft() != null && parent.getLeft().getVal() == val) {
                        parent.setLeft(null);
                        return target;
                    } else {
                        //待删除节点是其父节点的右节点
                        //不用判断右节点是否为null
                        // 因为上一个if不满足,那么target100%是parent的右节点
                        parent.setRight(null);
                        return target;

                    }
                }
            } else if (target.getLeft() == null || target.getRight() == null) {
                //待删除节点有且仅有一颗子树
                //特别注意待删除节点是root节点 且只有一个左子树和一个右子树的情况
                if (target.getLeft() == null) {
                    //待删除节点仅有右子树
                    if (parent == null) {
                        //待删除节点是root节点  且只有一个右子树
                        root = target.getRight();
                        return target;
                    }
                    if (parent.getLeft() != null && parent.getLeft().getVal() == val) {
                        //待删除节点是其父节点的左节点
                        //则父节点的左节点替换为target的右子树
                        parent.setLeft(target.getRight());
                        return target;
                    } else {
                        //待删除节点是其父节点的右节点
                        //则父节点的右节点替换为target的右子树
                        parent.setRight(target.getRight());
                        return target;
                    }
                } else {
                    //待删除节点仅有左子树
                    if (parent == null) {
                        //待删除节点是root节点  且只有一个左子树
                        root = target.getLeft();
                        return target;
                    }
                    if (parent.getLeft() != null && parent.getLeft().getVal() == val) {
                        //待删除节点是其父节点的左节点
                        //则父节点的左节点替换为target的右子树
                        parent.setLeft(target.getLeft());
                        return target;
                    } else {
                        //待删除节点是其父节点的右节点
                        //则父节点的右节点替换为target的右子树
                        parent.setRight(target.getLeft());
                        return target;
                    }
                }
            } else { // 重要 待删除节点既有左子树又有右子树
                BinaryNode leftleft = leftLeft(target.getRight());
                int tmp = leftleft.getVal();
                deleteNode(tmp);
                target.setVal(tmp);
            }

        }
        return null;
    }

    public BinaryNode leftLeft(BinaryNode node) {
        BinaryNode p = node;
        while (p.getLeft() != null) {
            p = p.getLeft();
        }
        return p;
    }


}


class BinaryNode {
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

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.getHeight();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.getHeight();
        }
    }

    //返回以该节点为根节点的树的高度
    public int getHeight() {
        return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
    }


    public void add(BinaryNode node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //!!!重要 新增判断 添加完节点之后是否平衡
        // 若右子树高度-左子树高度>1   =>  左旋转
        if (rightHeight() - leftHeight() > 1) {
            leftSpin();
        }

        if (leftHeight() - rightHeight() > 1) {
            rightSpin();
        }
    }

    private void leftSpin() {
        System.out.println("左旋");
        //创建新节点(代替当前节点) 值为当前节点的值
        BinaryNode newNode = new BinaryNode(this.val);
        //新节点左子树设为当前节点左子树
        newNode.left = this.left;
        //新节点右子树设为当前节点右子树的左子树
        newNode.right = this.right.left;
        //当前节点copy右节点的值(代替右节点)
        this.val = this.right.val;
        //当前节点的右子树指向右子树的右子树
        this.right = this.right.right;
        //当前节点的左子树指向新节点
        this.left = newNode;
    }

    private void rightSpin() {
        System.out.println("右旋");
        //创建新节点(代替当前节点) 值为当前节点的值
        BinaryNode newNode = new BinaryNode(this.val);
        //新节点右子树设为当前节点右子树
        newNode.right = this.right;
        //新节点左子树设为当前节点左子树的右子树
        newNode.left = this.left.right;
        //当前节点copy左节点的值(代替左节点)
        this.val = this.left.val;
        //当前节点的左子树指向左子树的左子树
        this.left = this.left.left;
        //当前节点的右子树指向新节点
        this.right = newNode;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    //后序
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public BinaryNode preOrderSearch(int val) {
        BinaryNode res = null;
        if (this.val == val) {
            return this;
        }
        if (this.left != null) {
            res = this.left.preOrderSearch(val);
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(val);
        }
        return res;
    }

    //找到节点直接删除 不考虑其是否有子树
    public void preOrderDelete(int val) {
        if (this.left == null) {
            ;
        } else if (this.left.val == val) {
            this.left = null;
            return;
        } else {
            this.left.preOrderDelete(val);
        }
        if (this.right == null) {
            ;
        } else if (this.right.val == val) {
            this.right = null;
        } else {
            this.right.preOrderDelete(val);
        }
    }

    //找到某个节点的父节点
    public BinaryNode findParent(int val) {
        if (val < this.val) {
            if (this.left == null) {
                return null;
            } else if (this.left.val == val) {
                return this;
            } else {
                return this.left.findParent(val);
            }
        } else {
            if (this.right == null) {
                return null;
            } else if (this.right.val == val) {
                return this;
            } else {
                return this.right.findParent(val);
            }
        }
    }

    public BinaryNode findNode(int val) {
        if (this.val == val) {
            return this;
        } else if (val < this.val) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.findNode(val);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.findNode(val);
            }
        }
    }


}