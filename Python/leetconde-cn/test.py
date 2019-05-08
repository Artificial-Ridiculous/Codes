class Solution:
    def product_without_self(self,nums):
        lennums = len(nums)
        res = [None] * lennums
        l = [nums[0]] * lennums
        r = [nums[-1]] * lennums
        for i in range(1,lennums-1):
            l[i] = l[i-1] * nums[i]
            r[-i-1] = r[-i] * nums[-i-1]
        res[0] = r[1]
        res[-1] = l[-2]
        for j in range(1,lennums-1):
            res[j] = l[j-1]*r[j+1]
        return res

if __name__ == '__main__':
    solution = Solution()
    nums = [1,2,3,4]
    ans = solution.product_without_self(nums)
    print(ans)