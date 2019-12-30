class Solution:
    def func(self,n:int,nums:list)->list:
        for i in

import sys
if __name__ == "__main__":
    solution = Solution()
    n = int(sys.stdin.readline().strip())
    nums = list(map(int,sys.stdin.readline().strip().split()))
    print(n)
    print(nums)
    ans = solution.func(0,nums)
    for i in nums:
        print(i,end=" ")