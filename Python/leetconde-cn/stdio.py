if __name__ == '__main__':
    import sys
    n = int(input())
    for i in range(n):
        line = input()
        res = sum(map(int,line.split()))
        print(res)