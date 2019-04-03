import random
import time

class Solution:
    def getThreeToSeven(self,n):
        return (n // 1000)%100000



if __name__ == "__main__":
    solution = Solution()

    r = random.randint(10**9,10**10-1)

    start = time.perf_counter()

    ans = solution.getThreeToSeven(r)

    end = time.perf_counter()


    print("%s%s%s"%("time used: ",(end - start),"s"))
    print(r)
    print(ans)