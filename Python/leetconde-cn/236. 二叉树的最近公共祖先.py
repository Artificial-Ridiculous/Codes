class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

n5 = TreeNode(5)
n3 = TreeNode(3)
n6 = TreeNode(6)
n2 = TreeNode(2)
n4 = TreeNode(4)
n1 = TreeNode(1)

n5.left = n3
n5.right = n6
n3.left = n2
n3.right = n4
n2.left = n1


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        temp = p
        dic = self.bfs(root)
        # 将链表q拼在q的末尾
        # 这样公共祖先问题就转换成了链表相交问题
        while(dic.get(temp)):
            temp=dic.get(temp)
        dic[temp] = q  

        fast=slow=p
        # 快慢指针法，将公共祖先转换成相交链表的交点
        while(dic.get(fast)):
            fast = dic.get(dic.get(fast))
            slow = dic.get(slow)
            if(fast is slow): break
        while(fast!=p):
            p=dic.get(p)
            fast = dic.get(fast)
        return fast

    def bfs(self,root:TreeNode ) -> dict :
        # 层次遍历所有节点，将所有节点的与其父节点以字典形式存下来
        p = root
        queue = []
        if p: 
            dic = {p:None}
            queue.append(p)
        while(queue):
            p = queue.pop(0)
            if p.left: 
                dic[p.left]=p
                queue.append(p.left)
            if p.right: 
                dic[p.right]=p
                queue.append(p.right)
        return dic

if __name__ is '__main__':

    n5 = TreeNode(5)
    n3 = TreeNode(3)
    n6 = TreeNode(6)
    n2 = TreeNode(2)
    n4 = TreeNode(4)
    n1 = TreeNode(1)

    n5.left = n3
    n5.right = n6
    n3.left = n2
    n3.right = n4
    n2.left = n1

    s = Solution()
    ans = s.lowestCommonAncestor(n5,n2,n4).val
    print(ans)
