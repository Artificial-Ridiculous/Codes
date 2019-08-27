import random
import copy
class Solution:
    def func(self,n:int,s:str)->str:
        i = 0
        nStack = []
        oStack = []
        num = []
        isOp = False
        yxj = []
        for i in oStack:
            if oStack[i] == '+':
                yxj.append(0)
            if oStack[i] == '-':
                yxj.append(1)
            if oStack[i] == '*':
                yxj.append(2)
            if oStack[i] == '/':
                yxj.append(3)
        while(i<len(s)):
            if ord('0')<=ord(s[i])<=ord('9'):
                isOp = False;
                num.append(s[i])
                i+=1
            elif s[i] in ('+','*','/'):
                isOp = True
                nStack.append("".join(num))
                oStack.append(s[i])
                num = []
                i+=1
            elif s[i] == '-':
                if isOp:#前面是符号 代表这是一个-
                    isOp = False;
                    num.append(s[i])
                    i+=1
                else:#前面是数字数字 代表这是一个运算符
                    isOp = True;
                    nStack.append("".join(num))
                    oStack.append(s[i])
                    num = []
                    i+=1
        if num:
            nStack.append("".join(num))
        
        nStack = list(map(int,nStack))
        print(nStack)
        print(oStack)
        return ""

        # j = 0
        # last = yxj[j]
        # while(j < len(yxj)-1):
        #     if(yxj[j] == last):
        #         if yxj[j] < yxj[j+1]:
        #              # 0~j可以sort
        #     else:
        #         j++

            


import sys
if __name__ == "__main__":
    solution = Solution()
    n = (int)(sys.stdin.readline().strip())
    s = "".join(sys.stdin.readline().strip().split())
    ans = solution.func(n,s)
    print(ans)