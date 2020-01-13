class Solution:
    def latest(self,n,alarms,takes,ddl):
        min = 0
        for t in alarms[::-1]:
            if t+takes < ddl:
                if t > min:
                    min = t
        return min

import sys
if __name__ == "__main__":
    solution = Solution()
    n = int(sys.stdin.readline().strip())
    alarms = [0 for _ in range(n)]
    for i in range(n):
        h,m = tuple(map(int,sys.stdin.readline().strip().split()))
        alarms[i] = h*60+m
    takes = int(sys.stdin.readline().strip())
    h,m = tuple(map(int,sys.stdin.readline().strip().split()))
    ddl = h*60+m
    ans = solution.latest(n,alarms,takes,ddl)
    h,m = ans // 60 ,ans % 60
    print(h,m)
    