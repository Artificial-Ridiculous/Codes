class Solution:
    def myAtoi(self, str: str) -> int:
        if str is None : return 0
        # 👆否则后续操作报错
        s = str.lstrip()
        # 👆该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
        if s == '' or s[0] not in ['+','-','0','1','2','3','4','5','6','7','8','9'] : return 0
        # 👆假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
        if s[0] == '+':
            num = 0
            i = 1
            while (i < len(s) and s[i] in ['0','1','2','3','4','5','6','7','8','9']):
                num = num*10 + int(s[i])
                i+=1
            return min(2**31 -1 , num)
        elif s[0] == '-':
            num = 0
            i = 1
            while (i < len(s) and s[i] in ['0','1','2','3','4','5','6','7','8','9']):
                num = num*10 + int(s[i])
                i+=1
            return max(-2**31,-num)
        else:  #👈number
            num = 0
            i = 0
            while (i < len(s) and s[i] in ['0','1','2','3','4','5','6','7','8','9']):
                num = num*10 + int(s[i])
                i+=1
            return min(2**31 -1 , num)


        

def main():
    import sys
    def readlines():
        for line in sys.stdin:  # 每个line以换行符结尾
            yield line.strip('\n')  # 如果不去掉，打印的时候会打印\n。因为虽然作为换行依据，但并没消耗掉换行符。
    lines = readlines()
    while True:
        try:
            line = next(lines)
            print(line)
        except StopIteration:
            break

if __name__ == '__main__':
    s = '   b'
    solution = Solution()
    res = solution.myAtoi(s)
    print(res)