class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == '0' or num2 == '0' : return '0'
        ans = 0
        len1 = len(num1)
        len2 = len(num2)
        for i in range(len1):
            for j in range(len2):
                current = int(num1[-i-1])*int(num2[-j-1])*int(10**(i+j))
                ans += current
        return str(ans)

if __name__ == '__main__':
    solution = Solution()
    ans = solution.multiply('123','456')
    print(ans)