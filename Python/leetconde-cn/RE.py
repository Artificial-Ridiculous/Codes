class Solution:
    def isMatch(self, text: str, pattern:str) -> bool :
        if not pattern : return not text
        firstMatch = pattern[0] in ('.',text[0])
        if len(pattern) >= 2 and pattern[1] == '*':
            return firstMatch and self.isMatch(text[1:],pattern) or self.isMatch(text,pattern[2:])
        return firstMatch and self.isMatch(text[1:],pattern[1:])

if __name__ == '__main__':
    import sys
    text,pattern = input().split()
    solution = Solution()
    res = solution.isMatch(text,pattern)
    print(res)
        
