class Solution:
    def search(self, nums, target: int) -> int:
        lenl = len(nums)
        left = 0
        right = lenl-1
        res = -1
        while(left <= right):
            mid = (left+right)//2
            if nums[mid] == target :  # 找到
                res = mid
                break
            elif nums[mid] >= nums[left]:  # mid在左侧的较大数组中
                if nums[left] <= target < nums[mid]:  # target在mid和left中间
                    right = mid-1
                else :  # target不在mid和left中间
                    left = mid+1
            elif nums[mid] < nums[right]:  # mid在右侧的较小数组中
                if nums[mid]<target<=nums[right]:  # target在mid和right之间
                    left = mid+1
                else:  # target不在mid和right之间
                    right = mid-1
        return res

if __name__ == '__main__':
    solution = Solution()
    # l = [1,5,7,8,13,22,56,77,90]
    l = [77,90,1,5,7,8,13,22,56]
    target =77
    res = solution.search(l,target)
    print(res)