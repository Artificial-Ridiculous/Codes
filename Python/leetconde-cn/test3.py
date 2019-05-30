class Solution:
    def minIncrementForUnique(self, A: List[int]) -> int:
        B = sorted(A)
        cnt = 0
        for i in range(1,len(B)):
            while (B[i] <= B[i-1]):
                cnt+=1
        return cnt

if __name__ == '__main__':
    '''solution = Solution()
    A = [1,2,2]
    ans = solution.minIncrementForUnique(A)
    print(ans)'''
    print(0)
