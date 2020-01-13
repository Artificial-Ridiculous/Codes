import sys
import re

class Solution:
    def func(self,s:str)->str:
        if s.find("%22")!=-1:
            pattern="%22"
            index = []
            start=0
            while(1):
                currentIndex = s.find(pattern,start)
                if currentIndex==-1:
                    break
                else:
                    index.append(currentIndex)
                    start+=currentIndex+3
            # print(len(index))
            # print(index[0]+3)
            # print(index[-1])
            return s[index[0]+3:index[-1]]

        else:
            indexFirstQuote = s.find("\"")
            indexSecondQuote = s.find("\"",1)
            indexBrackets = s.find("<")
            if(indexBrackets<indexSecondQuote):
                return s[indexFirstQuote+1:indexBrackets]
            else:
                return s[indexFirstQuote+1:indexSecondQuote]
    

if __name__=='__main__':
    solution = Solution()
    s = sys.stdin.readline().strip()
    ans = solution.func(s)
    print(ans)