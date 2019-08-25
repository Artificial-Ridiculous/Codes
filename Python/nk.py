import random
import copy
class Solution:
    # def func(self, n:int,s:str)->int :
    #     CAPS=1
    #     caps=best=0
    #     for i in range(len(s)):
    #         if s[i].isupper(): #daxie
    #             CAPS=min(CAPS+1,caps+2)
    #             caps=min(CAPS+1,caps+2)
                
    #         elif s[i].islower():  # xiaoxie
    #             CAPS=min(CAPS+2,caps+2)
    #             caps=min(CAPS+2,caps+1)
    #         best = min(CAPS,caps)
    #     return best
    # # def func1(self,n,k)->int:
    def InversePairs(self, array):
        if not array:
            return 0
        arrCopy = copy.deepcopy(array)
        return self.InverseRecur(array, arrCopy, 0, len(array)-1)

    def InverseRecur(self, array, arrCopy, start, end):
        if start == end:
            return 0
        mid = (start + end) // 2
        left = self.InverseRecur(array, arrCopy, start, mid)
        right = self.InverseRecur(array, arrCopy, mid+1, end)
        count = 0
        i = mid
        j = end
        locCopy = end
        while i>=start and j > mid:
            if array[i] > array[j]:
                count += j - mid
                arrCopy[locCopy] = array[i]
                locCopy -= 1
                i -= 1
            else:
                arrCopy[locCopy] = array[i]
                locCopy -= 1
                i -= 1

        while i >= start:
            arrCopy[locCopy] = array[i]
            locCopy -= 1
            i -= 1
        while j > mid:
            arrCopy[locCopy] = array[j]
            locCopy -= 1
            j -= 1
        s = start
        while s <= end:
            array[s] = arrCopy[s]
            s += 1
        return left + right + count

    def func(self,n:int,l)->int:

        return n-self.InversePairs(l)


import sys
if __name__ == "__main__":
    solution = Solution()
    n = (int)(sys.stdin.readline())
    l = list(map(int,sys.stdin.readline().strip().split()))
    ans = solution.func(n,l)
    print(ans)