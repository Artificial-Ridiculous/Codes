class Solution:
    def myAtoi(self, str: str) -> int:
        while()

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
    main()