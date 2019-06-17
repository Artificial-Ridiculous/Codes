class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        dic = {root:None}
        stack = []
        def bfs(self,root):
            while(root or stack):
                while(root):
                    if root.left : dic[root.left]=root
                    if root.right : dic[root.right]=root
                