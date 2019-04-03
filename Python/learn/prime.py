import time
class Solution:
    def getPrimeList(self,m,n) -> list:
        result = []
        for i in range(m+1,n):
            if self.isOrNotPrime(i) :result.append(i)
        return result

    def isOrNotPrime(self,n) -> bool:
        if n ==2 : return True
        i = 2
        while(i*i <= n):
            if n % i == 0 :return False
            i+=1
        return True


if __name__ == "__main__":
    solution = Solution()
    m = 2
    n = 100

    start = time.perf_counter()

    ans = solution.getPrimeList(m, n)

    end = time.perf_counter()

    print(start)
    print(end)

    print("%s%s%s"%("time used: ",(end - start),"s"))

    #print("质数" if ans is True else "合数")
    print(ans)
