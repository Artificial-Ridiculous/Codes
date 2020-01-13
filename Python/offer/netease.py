class Solution:
    def subsets(self, nums):
        res = [[]]
        for num in nums:
            res += [i+[num] for i in res]
        return res
    
    def yesOrNo(self,l,k):
        sub = self.subsets(l)
        print(sub)
        for subl in sub:
            res = 0
            for i in range(len(subl)):
                res = res | subl[i]
            if (res == k): 
                return True
        return False

import sys
if __name__ == "__main__":
    solution = Solution()

    n = int(sys.stdin.readline().strip())
    ans = []
    l = []
    for i in range(n):

        line = sys.stdin.readline().strip()
        x,k = list(map(int, line.split()))
        if(x == 1):
            l.append(k)
        else:
            print(l)
            ans.append("YES" if solution.yesOrNo(l,k) else "NO")

    for _ in ans:
        print(_)
    