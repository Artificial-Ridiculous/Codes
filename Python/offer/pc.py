class Solution:
    def func(self,l1,l2)->int:
        

    def back_fill(self, v_parts, max_length):
        if max_length > len(v_parts):
            return v_parts + ['0'] * (max_length - len(v_parts))
        return v_parts

    def compareVersion(self, version1: str, version2: str) -> int:
        v1_parts = version1.split('.')
        v2_parts = version2.split('.')
        
        max_length = max(len(v1_parts), len(v2_parts))
        v1_parts = self.back_fill(v1_parts, max_length)
        v2_parts = self.back_fill(v2_parts, max_length)
        
        for i in range(max_length):
            a = int(v1_parts[i])
            b = int(v2_parts[i])
            
            if a == b:
                continue
            if a > b:
                return 1
            if a < b:
                return -1
        return 0

import sys
if __name__ == "__main__":
    solution = Solution()
    ans = solution.func(10)
    print(ans)
    