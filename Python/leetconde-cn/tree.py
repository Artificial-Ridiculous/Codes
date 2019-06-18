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

def bfs(root:TreeNode):
    p = root
    queue = []
    if p: queue.append(p)
    while(queue):
        p = queue.pop(0)
        print (p.val)
        if p.left: queue.append(p.left)
        if p.right:queue.append(p.right)
def dfs(root:TreeNode):
    p = root
    stack = []
    while(stack or p):
        while(p):
            print(p.val)
            stack.append(p)
            p=p.left
        p = stack.pop()
        p = p.right
def bfsdic(root:TreeNode):
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



if __name__ == '__main__':
    bfsdic(n5)
    # print('---')
    # dfs(n5)