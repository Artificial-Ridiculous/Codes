class Solution:
    def min(self, n, nums)-> float:
        res = 99999999
        for x in range(n-2):
            i,j,k = nums[x],nums[x+1],nums[x+2]
            dx = self.dx(i,j,k)
            if dx < res:
                res = dx
        return res

    def dx(self,i,j,k)-> float:
        avg = (i+j+k)/3
        return ((i-avg)**2 + (j-avg)**2 + (k-avg)**2)/3


import sys
if __name__ == "__main__":
    solution = Solution()
    n = int(sys.stdin.readline().strip())
    nums = list(map(int,sys.stdin.readline().strip().split()))
    ans = solution.min(n,sorted(nums))
    
    print("%.2f"%ans)
    