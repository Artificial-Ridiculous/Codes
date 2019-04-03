class Solution:
    def adjustHeap(self,l,target = None,limit = None):
        lchild = 2*target+1
        rchild = 2*target+2
        max = target
        if(lchild<limit):
            if (l[target] < l[lchild]): max = lchild
        if (rchild < limit):
            if(l[max] < l[rchild]): max = rchild
        if max != target:
            l[target],l[max] = l[max],l[target]
            self.adjustHeap(l,max,limit)

    def buildHeap(self,l):
        lenl = len(l)
        for i in range((lenl-1)//2)[::-1]:
            self.adjustHeap(l,i,lenl)

    def heapSort(self,l):
        if l is None or len(l) in [0, 1]: return l
        lenl=len(l)
        self.buildHeap(l)
        for i in range(lenl)[::-1]:
            l[0],l[i] = l[i],l[0]
            self.adjustHeap(l,0,i)
        return l

if __name__ == '__main__':
    solution = Solution()
    l = [73, -22, 93, -43, 55, -14, 28, -22, 65, -39, 0]
    ans = solution.heapSort(l)
    print(ans)