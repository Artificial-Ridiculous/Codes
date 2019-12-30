class Solution:
    def unzip(self,s:str)->str:
        while(True):
            flag = False
            for i in range(len(s)):
                if s[i] == '[':
                    left = i
                    continue;
                elif s[i] == '|':
                    mid = i
                elif s[i] == ']':
                    right = i
                    flag = True
                    break
            if(flag): 
                s = s[0:left]+s[left+3:right]*(int)(s[left+1])+s[right+1:]
            else:
                break
        

        # left = s.find('[');
        # mid = s.find('|')
        # right = -(s[::-1].find(']'))-1
        # print(s[left],s[mid],s[right])
        # s = s[0:left]+s[left+3:right]*(int)(s[left+1])+s[right+1:]
        return s
import sys
if __name__ == "__main__":
    s = sys.stdin.readline().strip()
    solution = Solution();
    ans = solution.unzip(s);
    print(ans)