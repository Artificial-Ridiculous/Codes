class Solution:
    def func(self,a:int)-> str:
        ans = self.isOne(a)
        if ans :return "true"
        else: return "false"

    def isOne(self, n):

        hs = [n]
        c = n
        while(c != 1):
            s = str(c)
            temp = 0
            for i in range(len(s)):
                temp += (int(s[i])*(int(s[i])))
            if(temp in hs):
                return False
            c = temp
            hs.append(c)
        return True 

import sys
if __name__ == "__main__":
    solution = Solution()
    n = int(sys.stdin.readline().strip())
    for i in range(n):
        num = int(sys.stdin.readline().strip())
        print(solution.func(num))