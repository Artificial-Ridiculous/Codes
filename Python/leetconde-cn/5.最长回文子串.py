class Solution:
    # def longestPalindrome(self,s):
    #     # 中心扩散法
    #     if s is None or len(s) < 2 : return s
    #     l = self.addStar(s)
    #     print(l)
    #     lenl = len(l)
    #     maxStep = 0
    #     targetIndex = None
    #     for index in range(lenl):
    #         limit = min(index,lenl-index-1)  # -1深坑！
    #         currentStep = 0
    #         for step in range(1,limit+1):  # +1还行
    #             if l[index-step]==l[index+step]:
    #                 currentStep+=1
    #             else:
    #                 break
    #         if currentStep>maxStep:
    #             maxStep = currentStep
    #             targetIndex = index
    #     print('s=%s'%s)
    #     print('step = %d'%maxStep)
    #     print('index = %d'%targetIndex)
    #     return str(s[(targetIndex//2 - (maxStep)//2 ) : (targetIndex//2 + (maxStep+1)//2)])  # 数组下标深坑！

    def longestPalindrome(self,s):
        # DP
        if s is None or len(s) < 2 : return s
        lens = len(s)
        matrix = [[False for _ in range(lens)] for _ in range(lens)]
        for i in range(lens): matrix[i][i] = True
        for i in range(lens):
            for j in range(i+1,lens):
                matrix[j][i] = (
                    s(i) == s(j)
                    and
                    j-i <=2 or matrix[i+1][j-1]
                )


    def addStar(self,s):
        l = ['*']
        for char in s:
            a = char
            l.append(a)  # !!!!!!!写成[]debug了我半天
            l.append('*')  # TypeError: 'builtin_function_or_method' object is not subscriptable
        return l


if __name__ == '__main__':
    s = 'bb'
    solution = Solution()  # 不带括号就不启动实例
    ans = solution.longestPalindrome(s)
    print(ans)
    # print(solution.addStar(s))