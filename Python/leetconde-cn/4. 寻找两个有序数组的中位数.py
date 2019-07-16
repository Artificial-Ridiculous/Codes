import sys

class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        len1,len2 = len(nums1),len(nums2)
        if len1 > len2 : return self.findMedianSortedArrays(nums2,nums1)
        left1,right1 = 0,len1*2
        while(left1 <= right1):
            c1 = (left1+right1) // 2
            c2 = len1 + len2 - c1

            LMax1 = -sys.maxsize-1 if c1 == 0 else nums1[(c1-1)//2]
            RMin1 = sys.maxsize if c1 == 2*len1 else nums1[(c1)//2]
            LMax2 = -sys.maxsize-1 if c2 == 0 else nums2[(c2-1)//2]
            RMin2 = sys.maxsize if c2 == 2*len2 else nums2[(c2)//2]

            if LMax1 > RMin2:
                right1 = c1-1
            elif LMax2 > RMin1:
                left1 = c1+1
            else : break

        return (max(LMax1,LMax2)+min(RMin1,RMin2))/2.0
                


if __name__ == '__main__':
    # nums1 = [1, 3]
    # nums2 = [2]

    nums1 = [1, 2]
    nums2 = [3, 4]

    solution = Solution()
    ans = solution.findMedianSortedArrays(nums1, nums2)
    print(ans)
        