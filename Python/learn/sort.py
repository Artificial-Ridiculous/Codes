class Sort:

    def chooseSort(self,l,start = 0):#start为无序数组的起始下标  每轮循环找到一个最小值放到无序数组的第一个   然后无序下标++
        '''
        选择排序
        '''
        if l is None or len(l) in [0, 1]: return l
        if start+1 == len(l) : return l
        minNum = l[start]
        minIndex = start
        i = start
        while(i < len(l)):
            if l[i] < minNum :
                minNum = l[i]
                minIndex = i
            i+=1
        l[start],l[minIndex] = l[minIndex],l[start]
        self.chooseSort(l,start+1)
        return l

    def insertSort(self,l,start = 1):#start为无序数组的第一位 第0位默认有序
        '''
        插入排序
        '''
        if l is None or len(l) in [0, 1]: return l
        if start == len(l): return l
        i = 0
        if l[start] < l[start-1] :#start要做插入  自己不是最大的
            temp = l[start]  # 插入之前 保存自己
            while(l[start] > l[i] ):#最后哪怕跟自己换
                i += 1
            for j in range(start-1,i-1,-1):#前面的
                l[j+1] = l[j]#统统往后挪一位
            l[i] = temp#最后插入

        self.insertSort(l,start+1)
        return l

    def bubbleSort(self,l,end = None):
        '''
        冒泡排序
        '''
        if l is None or len(l) in [0, 1]: return l
        end = len(l)-1 if end == None else end#  学到了!!!假如调用有缺省  但是递归又要用到一个参数
        if end == 0 : return l
        i = 0
        while (i <= end-1):
            if (l[i] > l[i+1]):#前面比后面大
                l[i],l[i+1] = l[i+1],l[i]#就交换
            i+=1#无论如何i+1
        #print(l)
        #print(i)
        self.bubbleSort(l,end-1)
        return l

    def merge2SortedList(self,l1,l2,result = None):
        '''
        归并两个有序且同序的列表
        '''
        result = [] if result is None else result
        if l1 is None and l2 is None: return None
        if l1 == [] or l1 is None:
            result.extend(l2)
            return result  # 注意return  如果不return 下面数组越界了
        if l2 == [] or l2 is None:
            result.extend(l1)
            return result
        result.append(l1[0] if l1[0] <= l2[0] else l2[0])  # 访问了数组 特别注意l1是None或者l1是空
        if result[-1] == l1[0]:
            l1 = l1[1:]
        else:
            l2 = l2[1:]
        # print(result)
        self.merge2SortedList(l1, l2, result)
        return result

    def  mergeSort(self,l):
        '''
        归并排序
        '''
        if l is None or len(l) in [0,1] : return l
        #if len(l) in [0,1] : return l
        return self.merge2SortedList(self.mergeSort(l[:len(l) // 2]) , self.mergeSort(l[len(l) // 2:]))

    def fastSort(self,l,start = None,end = None):
        '''
        快速排序
        '''
        if l is None or len(l) in [0,1] : return l
        start = 0 if start == None else start
        end = len(l) -1 if end == None else end
        #if (end - start) in [0,1] : return
        split = l[start]
        i,j = start,end
        while(i != j ):
            while(i != j and l[j] >= split):# 内循环也要带上外循环的条件
                j-=1
            #self.swap(l,i,j)
            while(i != j and l[i] <= split):
                i+=1
            #self.swap(l,i,j)
            l[i],l[j] = l[j],l[i]
        l[start],l[i] = l[i],l[start]
        if i-start >= 2:  # 1也可以  但是单个元素自然有序 没必要排
            self.fastSort(l,start,i-1)
        if end - i >= 2:  # 1也可以  但是单个元素自然有序 没必要排
            self.fastSort(l,i+1,end)
        return l

    def shellSort(self,l,step = None):
        '''
        希尔排序
        '''
        if l is None or len(l) in [0,1] : return l
        step = len(l)//2 if step is None else step
        for i in range(step):
            listToInsertSort = [l[j] for j in range(i ,len(l) , step)]
            listSorted = self.insertSort(listToInsertSort)
            indexOflistSorted = 0
            for k in range(i ,len(l) , step):
                l[k] = listSorted[indexOflistSorted]
                indexOflistSorted += 1
        if step >= 2:
            self.shellSort(l,step//2)
        return l

    def adjustHeap(self,l,i,limit):
        lchild = 2*i +1
        rchild = 2*i +2
        #if lchild <= len(l)+1:
        max = i
        if lchild < limit and l[lchild] > l[max]: max = lchild
        if rchild < limit and l[rchild] > l[max]: max = rchild
        if max != i:
            l[max], l[i] = l[i], l[max]
            self.adjustHeap(l, max, limit)


    def buildHeap(self,l):
        for i in range((len(l))//2)[::-1]:#从最后一个有子结点的标号到0
            self.adjustHeap(l,i,len(l))

    def heapSort(self,l):
        '''
        堆排序
        '''
        if l is None or len(l) in [0, 1]: return l
        self.buildHeap(l)
        last = len(l)-1
        while last > 0 :
            l[0],l[last] = l[last],l[0]
            self.adjustHeap(l, 0, last)#
            last -= 1#这里不能反
        return l


    def getPositiveBit(self,num):
        if num == 0 : return 1
        bit = 0
        while(num != 0):
            bit += 1
            num //= 10
        return bit

    def sliceListToPosAndNeg(self,l):
        posList = []
        negList = []
        for num in l:
            if num >= 0: posList.append(num)
            else: negList.append(num)
        return posList,negList

    def radixSort(self,l):
        if l is None or len(l) in [0, 1]: return l
        posList, negList = self.sliceListToPosAndNeg(l)
        sortedPos = self.posRadixSort(posList)
        #先对负值列表的每个元素取相反数，当作正数正常排
        #排完之后  逆序再取相反数   再拼上正值排序后的列表
        sortedNeg = [-j for j in self.posRadixSort([-i for i in negList])[::-1]]
        return sortedNeg+sortedPos

    def posRadixSort(self,l):
        '''
        基数排序
        '''
        max = l[0]
        for num in l:
            if num > max: max = num
        times = self.getPositiveBit(max)
        for i in range(times):#桶bit次
            buckets = [[] for j in range(10)]#初始化桶
            #result = []
            for num in l:#塞桶
                bit = (num // 10**i) % 10
                buckets[bit].append(num)
            flatmappedbuckets = []
            for bucket in buckets:#拍扁桶们
                flatmappedbuckets.extend(bucket)
            l = flatmappedbuckets
        return l

if __name__ == '__main__':
    l  = [73, -22, 93, -43, 55, -14, 28, -22, 65, -39, 0]
    l1=l2=l3=l4=l5=l6=l7=l8= l
    print('未排序  :\t', l)
    print('-----------------------------------------------------------')
    solution = Sort()
    choose = solution.chooseSort(l1)
    insert = solution.insertSort(l2)
    bubble = solution.bubbleSort(l3)
    merge = solution.mergeSort(l4)
    fast = solution.fastSort(l5)
    shell = solution.shellSort(l6)
    heap = solution.heapSort(l7)
    radix = solution.radixSort(l8)
    print('选择排序:\t', choose)
    print('插入排序:\t', insert)
    print('冒泡排序:\t', bubble)
    print('归并排序:\t', merge)
    print('快速排序:\t', fast)
    print('希尔排序:\t', shell)
    print('堆排序  :\t', heap)
    print('基数排序:\t', radix)