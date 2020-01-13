class Solution:
    def func(self,s1,s2)-> bool:
        lena,lenb = len(s1),len(s2)
        ans = []
        if lena == lenb*4:
            for i in range(lenb):
                ans = ans+s1[4*i:4*(i+1)]+[s2[i]]
        elif lena < lenb*4:
            for i in range(lena//4):
                ans = ans+s1[4*i:4*(i+1)]+[s2[i]]
            ans += s1[lena//4 * 4:]
            ans += s2[lena//4:]
        else:
            for i in range(lenb):
                ans = ans+s1[4*i:4*(i+1)]+[s2[i]]
            ans += s1[4*lenb:]
        return ans
        

import sys
if __name__ == "__main__":
    solution = Solution()
    s1 = sys.stdin.readline().strip().split(" ")
    s2 = sys.stdin.readline().strip().split(" ")
    ans = solution.func(s1,s2)
    for i in ans:
        print(i,end = " ")
    