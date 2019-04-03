import random
import time

class Solution:
    def sumChar(self,str):
        res = [0 for i in range(4)]
        for char in str:
            if ord(char)>=ord('A') and ord(char)<=ord('Z') or ord(char)>=ord('a') and ord(char)<=ord('z'):
                res[0]+=1
            elif ord(char)>=ord('0') and ord(char)<=ord('9'):
                res[1]+=1
            elif char == ' ':
                res[2]+=1
            else:
                res[3]+=1
        return res

if __name__ == "__main__":
    solution = Solution()
    str = "7s6G *3$ sa786332gh$%&^"
    ans = solution.sumChar(str)
    print("%s%d"%("字母: ",ans[0]))
    print("%s%d"%("数字: ",ans[1]))
    print("%s%d" % ("空格: ", ans[2]))
    print("%s%d" % ("其他: ", ans[3]))