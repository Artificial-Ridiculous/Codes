class Solution:
    def fastSort(self,l,start = None,end = None):
        lenl = len(l)
        if l is None or lenl in [0,1] : return l
        start = 0 if start is None else start
        end = lenl - 1 if end is None else end
        i,j = start,end
        middle = l[start]
        while(j != i):
            while(j != i and l[j] >= middle):
                j -=1
            while(i != j and l[i] <= middle):
                i+=1
            l[i],l[j] = l[j],l[i]
        l[i],l[start] = l[start],l[i]
        if i - start >= 2:
            self.fastSort(l, start, i - 1)
        if end - i >= 2:
            self.fastSort(l, i + 1, end)
        return l

if __name__ == '__main__':
    solution = Solution()
    l = [73, -22, 93, -43, 55, -14, 28, -22, 65, -39, 0]
    ans = solution.fastSort(l)
    print(ans)