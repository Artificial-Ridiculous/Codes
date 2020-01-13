class Solution:
    def key(self,n,k,num):
        key = num
        ans = [0 for i in range(n+k-1)]
        for i in range(n+k-1):
            ans[i] = key[i]
            left = max(0,i-(k-1))
            for j in range(left,i):
                ans[i] ^= ans[j]
        return ans[:n]

import sys
if __name__ == "__main__":
    solution = Solution()

    n,k = list(map(int,sys.stdin.readline().strip().split()))
    num = list(map(int,sys.stdin.readline().strip()))

    res = solution.key(n,k,num)
    for bit in res:
        print(bit,end='')
    