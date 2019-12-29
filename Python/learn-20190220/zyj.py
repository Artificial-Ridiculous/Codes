class Solution:
    def func(self,height):
# height = [5,7,3,8,6,3,2,5,1]
            dp = [1 for i in range(len(height))]
            stack = []
            for i in range(len(height)-1):
                stack = [height[i+1]]
                for j in range(i+2,len(height)):
                    if height[j]>=stack[-1]:
                        stack.append(height[j])
                dp[i]+=len(stack)
            for i in range(len(height)-1,0,-1):
                stack = [height[i-1]]
                for j in range(i-2,-1,-1):
                    if height[j]>=stack[-1]:
                        stack.append(height[j])
                dp[i]+=len(stack)
            return(dp)

import sys
if __name__ == "__main__":
    solution = Solution()
    n = int(sys.stdin.readline().strip())
    nums = list(map(int,sys.stdin.readline().strip().split()))
    ans = solution.func(nums)
    for i in ans:
        print(i,end=" ")