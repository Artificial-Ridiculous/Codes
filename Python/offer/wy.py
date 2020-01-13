class Solution:
    def func(self,l):
        lenl = len(l)
        max = 0
        for i in range(lenl//2):
            if(l[i]+l[lenl-1-i] > max):
                max = l[i]+l[lenl-1-i]
        return max
import sys
solution = Solution()
l=[]
n = int(sys.stdin.readline().strip())
for i in range(n):
    a,b = list(map(int,sys.stdin.readline().strip().split(" ")))
    for j in range(a):
        l.append(b)
l.sort()
ans = solution.func(l)
print(ans)

