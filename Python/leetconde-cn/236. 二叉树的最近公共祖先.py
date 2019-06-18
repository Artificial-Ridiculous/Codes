class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        dic = self.bfs(root)
        while(p):
            if dic.

    def bfs(self,root:TreeNode ) -> dict :
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
        print(dic)
        return dic
