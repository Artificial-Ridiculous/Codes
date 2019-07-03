# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def sortedArrayToBST(self, nums: [int]) -> TreeNode:
        if nums is None or nums == [] : return None
        lenn = len(nums)
        indexRoot = lenn//2
        root = TreeNode(nums[indexRoot])
        root.left=self.sortesdArrayToBST(nums[:indexRoot])
        root.right=self.sortedArrayToBST(nums[indexRoot+1:])
        return root

if __name__ == '__main__':
    l = [-10,-3,0,5,9]
    solution = Solution()
    solution.sortedArrayToBST(l)



