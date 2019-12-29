class Solution:
    def search(self, nums, target: int) -> int:
        lenl = len(nums)
        left = 0
        right = lenl-1
        res = -1
        while(left <= right):
            mid = (left+right)//2
            if nums[mid] == target :
                res = mid
                break
            elif nums[mid] > target:
                right = mid-1  # 防止mid==right  死循环
            else:
                left = mid+1  # 防止mid==left  死循环
        return res

if __name__ == '__main__':
    solution = Solution()
    l = [1,5,7,8,13,22,56,77,90]
    target = 91
    res = solution.search(l,target)
    print(res)
