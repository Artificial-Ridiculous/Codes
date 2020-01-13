class Solution:
    def minMoney(self,n,nums):
        money = [100 for _ in range(n)]
        money[0] = 100
        for i in range(n-1):
            if nums[i] < nums[i+1]:
                money[i+1] = money[i]+100
            elif nums[i] < nums[i+1]:
                money[i+1] = 100
                if(money[i]<=money[i+1]):
                    k = i+1
                    while(k>=0):
                        if(nums[k-1]>nums[k] and money[k-1]<=money[k]):
                            money[k-1]+=1
                            k-=1
            else:
                money[i+1] = 100
        # print(money)

        sum = 0
        for i in money:
            sum += i
        
        return sum

import sys
if __name__ == "__main__":
    solution = Solution()

    n = int(sys.stdin.readline().strip())
    nums = list(map(int,sys.stdin.readline().strip().split()))

    res = solution.minMoney(n,nums)
    print(res)
    