class Solution():
    def merge2List(self,l1,l2,result = None):
        if l1 is None and l2 is None : return None
        result = [] if result is None else result
        if l1 == [] or l1 is None:
            result.extend(l2)
            return result# 注意return  如果不return 下面数组越界了
        if l2 == [] or l2 is None:
            result.extend(l1)
            return result
        result.append(l1[0] if l1[0] <= l2[0] else l2[0])  # 访问了数组 特别注意l1是None或者l1是空
        if result[-1] == l1[0]:
            l1 = l1[1:]
        else:
            l2 = l2[1:]
        # print(result)
        self.merge2List(l1, l2, result)
        return result

    def mergeSort(self,l):
        if l is None or len(l) in [0,1] : return l
        return self.merge2List(self.mergeSort(l[:len(l)//2]),self.mergeSort(l[len(l)//2:]))

if __name__ == "__main__":
    solution = Solution()
    l = [73,-22,93,-43,55,-14,28,-22,65,-39,0]
    ans = solution.mergeSort(l)
    print(ans)