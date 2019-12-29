# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    

class Solution:
    def stringToTreeNode(self,input:str) -> TreeNode:
        input = input.strip()
        input = input[1:-1]
        if not input:
            return None

        inputValues = [s.strip() for s in input.split(',')]
        root = TreeNode(int(inputValues[0]))
        nodeQueue = [root]
        front = 0
        index = 1
        while index < len(inputValues):
            node = nodeQueue[front]
            front = front + 1

            item = inputValues[index]
            index = index + 1
            if item != "None":
                leftNumber = int(item)
                node.left = TreeNode(leftNumber)
                nodeQueue.append(node.left)

            if index >= len(inputValues):
                break

            item = inputValues[index]
            index = index + 1
            if item != "None":
                rightNumber = int(item)
                node.right = TreeNode(rightNumber)
                nodeQueue.append(node.right)
        return root
    
    def prettyPrintTree(self,node, prefix="", isLeft=True):
        if not node:
            print("Empty Tree")
            return

        if node.right:
            self.prettyPrintTree(node.right, prefix + ("│   " if isLeft else "    "), False)

        print(prefix + ("└── " if isLeft else "┌── ") + str(node.val))

        if node.left:
            self.prettyPrintTree(node.left, prefix + ("    " if isLeft else "│   "), True)


    def maxPathSum(self, root: TreeNode) -> int:
        p = root
        self.max = -100000000
        self.helper(p)
        return self.max


    def helper(self,root: TreeNode) -> int:
        p = root
        if root is None : return 0
        left = self.helper(p.left)
        right = self.helper(p.right)

        self.max = max(self.max , p.val + left + right)

        single_path = max(left,right) + p.val
        return single_path if single_path > 0 else 0


    # def maxPathSum(self, root: TreeNode) -> int:
    #     self.max = float('-inf')
    #     self.max_path(root)
    #     return self.max
        
    # def max_path(self, root):
    #     if not root: return 0
    #     left = self.max_path(root.left)
    #     right = self.max_path(root.right)
    #     self.max = max(left + right + root.val, self.max)
    #     tmp = max(left, right) + root.val
    #     return tmp if tmp > 0 else 0


        



if __name__ == '__main__' :
    listExp = [-10,9,20,None,None,15,7]
    solution = Solution()
    root = solution.stringToTreeNode(str(listExp)) 
    solution.prettyPrintTree(root)
    res = solution.maxPathSum(root)
    print(res)


    