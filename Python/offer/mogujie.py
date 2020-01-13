class Solution:
    def func(self,n,k)-> int:
        cnt=0
        for i in range(20,2021):
            if i % 20 == 1 or i % 19 ==1:
                cnt+=1
        print(cnt)

    def magic(self,s,k)->int:
        if k == 1 :
            return 0
        a = self.diff(s,self.gen(k,1))
        b = self.diff(s,self.gen(k,2))
        c = self.diff(s,self.gen(k,3))
        return min(a,b,c)

    def gen(self,k,flag) -> str:
        loop = k // 3
        tail = k %  3
        if flag == 1:
            t = ["","A","AB"]
            return "ABC"*loop + t[tail]
        elif flag ==2:
            t = ["","B","BC"]
            return "BCA"*loop + t[tail]
        else:
            t = ["","C","CA"]
            return "CAB"*loop + t[tail]
    
    def diff(self,a,b):
        lena = len(a)
        count = 0
        for i in range(lena):
            if a[i] != b[i]:
                count +=1
        return count

import sys
if __name__ == "__main__":
    solution = Solution()
    n,k=20,2020
    solution.func(n,k)
    