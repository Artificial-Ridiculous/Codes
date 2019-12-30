class Solution:
    def func(self,n,work,muscle):
        if (work[0] or muscle[0]): best =1
        else: best = 0
        if(work[0]): chooseWork=0
        else: chooseWork=1
        if(muscle[0]): chooseMuscle=0
        else: chooseMuscle=1
        chooseRest=1
        for i in range(1,n):
            chooseRest = min(chooseRest+1,chooseWork+1 if work[i-1] else 999999,chooseMuscle+1  if muscle[i-1] else 999999)
            if work[i] == 1:
                chooseWork = min(chooseRest+1,chooseMuscle if muscle[i-1] else 999999)
            else:
                chooseWork = 999999
            if muscle[i] == 1:
                chooseMuscle = min(chooseRest+1,chooseWork if work[i-1] else 999999)
            else:
                chooseMuscle = 999999
            best = min(chooseRest,chooseWork if work[i] else 999999,chooseMuscle if muscle[i] else 999999)
        return best
        


import sys
if __name__ == "__main__":
        n = int(sys.stdin.readline().strip())
        work = list(map(int,sys.stdin.readline().strip().split()))
        muscle = list(map(int,sys.stdin.readline().strip().split()))
        solution = Solution()
        res = solution.func(n,work,muscle)
        print(res)