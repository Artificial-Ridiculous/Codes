class Solution:
    def minIncrementForUnique(self, A):
        A.sort()
        cnt = 0
        B = [A[0]]
        for i in range(1,len(A)):
            if A[i] <= B[-1]:
                cnt += B[-1]+1-A[i]
                B.append(B[-1]+1)
            else: B.append(A[i])
        return cnt

if __name__ == '__main__':
    solution = Solution()
    A = [3,2,1,2,1,7]
    #A = [1,2,2]
    ans = solution.minIncrementForUnique(A)
    print(ans)
    
