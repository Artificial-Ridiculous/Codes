class Solution:
    def func(self,a:str,b:str)-> bool:
        ans = True
        la = list(map(int,a.split(".")))
        lb = list(map(int,b.split(".")))
        if(len(la)==1):
            la = la+[0,0,0]
        elif(len(la)==2):
            la = la+[0,0]
        elif len(la) == 3:
            la = la+[0]
        if(len(lb)==1):
            lb = lb+[0,0,0]
        elif(len(lb)==2):
            lb = lb+[0,0]
        elif len(lb) == 3:
            lb = lb+[0]
        vala=valb = 0
        for i in range(4)[::-1]:
            vala=la[i]+vala*10
            valb=lb[i]+valb*10



        return valb>vala

    def back_fill(self, v_parts, max_length):
        if max_length > len(v_parts):
            return v_parts + ['0'] * (max_length - len(v_parts))
        return v_parts

    def compareVersion(self, version1: str, version2: str) -> int:
        v1_parts = version1.split('.')
        v2_parts = version2.split('.')
        
        max_length = max(len(v1_parts), len(v2_parts))
        v1_parts = self.back_fill(v1_parts, max_length)
        v2_parts = self.back_fill(v2_parts, max_length)
        
        for i in range(max_length):
            a = int(v1_parts[i])
            b = int(v2_parts[i])
            
            if a == b:
                continue
            if a > b:
                return 1
            if a < b:
                return -1
        return 0

import sys
if __name__ == "__main__":
    solution = Solution()
    n = int(sys.stdin.readline().strip())
    for i in range(n):
        a,b = sys.stdin.readline().strip().split(" ")
        print("true" if solution.compareVersion(a,b) else "false")
    