class Solution:
    def maxMin(self,)

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
    