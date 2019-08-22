class Solution:
    def func(self, s) :
        res = []
        for word in s:
            if len(word) & 1:
                res.append(word[::-1])
            else:
                res.append(word)
        return res


import sys
if __name__ == "__main__":
    solution = Solution()
    s = sys.stdin.readline().strip().split()
    # print(s)
    ans = solution.func(s)
    # print(ans)
    lens = len(s)
    for i in range(lens):
        if i < lens-1:
            print(ans[i],end=" ")
        else:
            print(ans[i])