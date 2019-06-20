

class Solution:
    def threeSumClosest(self, nums, target: int) -> int:
        l = sorted(nums)
        lenl = len(l)
        nearest = l[0]+l[1]+l[-1]
        i = 0
        while(i < lenl - 2):
            flag = False
            j = i + 1
            k = lenl - 1
            while(j < k):
                ijk = l[i]+l[j]+l[k]
                if ijk == target :
                    flag = True
                    break
                if (abs(ijk-target) < abs(nearest-target)):
                    nearest = ijk
                if ijk < target:  # j++
                    j+=1
                else:  # ijk > target,k--
                    k-=1
            if flag is True: break
            i+=1
        return target if flag is True else nearest


                

if __name__ == '__main__':
    nums = [1,1,-1,-1,3]
    target = -1
    # 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

    solution = Solution()
    ans = solution.threeSumClosest(nums,target)
    print(ans)