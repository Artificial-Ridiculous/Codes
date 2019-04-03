# -*- coding:utf-8 -*-
#https://blog.csdn.net/XiaoYi_Eric/article/details/81452014
'''
#2替换空格
class Solution:
    def replaceSpace(self,str,replacement):
        return str.replace(' ',replacement)

if __name__ == '__main__':
    str='i love sprk'
    solution = Solution()
    result = solution.replaceSpace(str,'%20')
    print(result)

#3.从尾到头打印链表
class ListNode:
    def __init__(self,x):
        self.val=x
        self.next = None

class Solution:
    def printListFromTailToHead(self,listNode):
        l = []
        while listNode:
            l.append(listNode.val)
            listNode = listNode.next
        return l[::-1]

if __name__ == '__main__':
    A1 = ListNode(1)
    A2 = ListNode(2)
    A3 = ListNode(3)
    A4 = ListNode(4)
    A1.next=A2
    A2.next=A3
    A3.next=A4
    solution = Solution()
    ans = solution.printListFromTailToHead(A1)
    print(ans)


#4重建二叉树

class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None

class Solution():
    def reConstractBinaryTree(self,preod,inod):
        if len(preod) == 0:
            return None
        if len(preod) == 1:
            return TreeNode(preod[0])
        else:
            root = TreeNode(preod[0])
            root.left = self.reConstractBinaryTree(preod[1:inod.index(preod[0])+1],inod[:inod.index(preod[0])])
            root.right = self.reConstractBinaryTree(preod[inod.index(preod[0])+1:],inod[inod.index(preod[0])+1:])

        return root

if __name__ == '__main__':
    solution = Solution()
    preod = list(map(int,input("input a preorder binary tree result:").split(',')))
    print(preod)
    inod = list(map(int, input("input a inorder binary tree result:").split(',')))
    print(inod)
    ans = solution.reConstractBinaryTree(preod,inod)
    print(ans.val)

#用两个栈实现队列

class Solution:
    def __init__(self):
        self.Stack1=[]
        self.Stack2=[]

    def push(self,node):
        self.Stack1.append(node)

    def pop(self):
        if self.Stack2 == []:
            while self.Stack1:
                self.Stack2.append(self.Stack1.pop())
            return self.Stack2.pop()
        return self.Stack2.pop()


if __name__ == '__main__':
    solution = Solution()
    solution.push(1)
    solution.push(2)
    solution.push(3)
    solution.push(4)
    print(solution.Stack1)
    print(solution.pop())
    print(solution.pop())'''


#旋转数组的最小数字
'''class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        minnum=999999
        for i in range(0,len(rotateArray)):
            if minnum>rotateArray[i]:
                minnum=rotateArray[i]
        if minnum:
            return minnum
        else:
            return 0

if __name__=='__main__':
    solution=Solution()
    rotateArray=list(map(int,input().split(',')))
    ans=solution.minNumberInRotateArray(rotateArray)
    print(ans)'''

#递归二分查找
'''class Solution:
    def binarySearch(self,l,key,head = 0,tail = None):
        tail = len(l) if tail is None else tail
        mid = (tail-head)//2+head
        if head<=tail:
            if key > l[mid]:
                return self.binarySearch(l,key,head=mid+1,tail=tail)
            elif key < l[mid]:
                return self.binarySearch(l,key,head=head,tail=mid-1)
            else:
                return mid
        else: return -1

if __name__=='__main__':
    solution=Solution()
    rotateArray=list(map(int,input('输入一串递增数字  用逗号隔开：').split(',')))
    ans=solution.binarySearch(rotateArray,int(input("输入想查找的数字:")))
    print(ans)'''

#寻找旋转排序数组中的最小值
'''class Solution:
    def findMin(self,l):
        left, right = 0, len(l) - 1
        while left < right and l[left] > l[right]:#为了让循环中left始终指向second中的元素
            mid = (left + right) // 2
            # mid指在second中
            if l[left] <= l[mid]:
                left = mid + 1
            # mid指在first中
            else:
                right = mid
        return l[left]

if __name__=='__main__':
    solution=Solution()
    rotateArray=list(map(int,input('输入一串递增数字  用逗号隔开：').split(',')))
    ans=solution.findMin(rotateArray)
    print(ans)'''

#斐波那契数列
'''class Solution:
    def Fibonacci(self,n):#递归   重复计算
        if n == 0: return 0
        elif n == 1: return 1
        else: return self.Fibonacci(n-1)+self.Fibonacci(n-2)

    def Fibonacci1(self, n):# 保存计算过的值  非递归
        # write code here
        if n == 0:return 0
        elif n == 1: return 1
        fibList = [0 for i in range(0,n+1)]
        fibList[0] = 0
        fibList[1] = 1
        for i in range(2,n+1):
            fibList[i] = fibList[i-1]+fibList[i-2]
        return fibList[n]

solution = Solution()
ans=solution.Fibonacci1(int(input("输入n:")))
print(ans)'''

#8 跳台阶
'''class Solution:
    def jumpFloor(self,n):#自己写
        if n==1:return 1
        elif n==2:return 2
        waysList = [0 for i in range(0,n+1)]
        waysList[1],waysList[2] = 1,2
        assert n >= 3
        for j in range(3,n+1):
            waysList[j] = waysList[j-1]+waysList[j-2]
        return waysList[n]

    def jumpFloor1(self, number):#答案
        # write code here
        if number == 0:
            return 0
        if number == 1:
            return 1
        if number == 2:
            return 2
        ans = [0 for i in range(0, number + 1)]
        ans[1], ans[2] = 1, 2
        for i in range(3, number + 1):
            ans[i] = ans[i - 1] + ans[i - 2]
        return ans[number]


solution = Solution()
ans=solution.jumpFloor(int(input("输入台阶数:")))
print(ans)'''

#9变态跳台阶
'''class Solution:
    def jumpFloorII(self, floors):
        # write code here
        if floors==1:
            return 1
        if floors==2:
            return 2
        return 2*self.jumpFloorII(floors-1)

if __name__=='__main__':
    solution=Solution()
    n=int(input())
    ans=solution.jumpFloorII(n)
    print(ans)'''


#10我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
# 请问用number个2*1的小矩形无重叠地覆盖一个2*number的大矩形，总共有多少种方法？
#f(n)=f(n-1)+f(n-2)


#11二进制中1的个数


'''class Solution:
    def NumberOf1(self,n):
        count = 0
        for i in range(32):
            if (1<<i)&n: count+=1
        return count

if __name__ =='__main__':
    solution = Solution()
    ans = solution.NumberOf1(int(input('输入一个整数')))
    print(ans)'''


######实现pow()
'''class Solution():
    def intPow(self,base,exponent):
        if base == 0 and exponent == 0 : return 0
        else:
            result = 1
            unsignedExponent = -exponent if exponent< 0 else exponent
            result = self.PowerWithUnsignedExponent(base,unsignedExponent)
            return result if exponent >= 0 else 1/result

    def PowerWithUnsignedExponent(self,base,exponent):
        if exponent == 0 : return 1 #一般为一开始就是0   在递归时不会出现
        if exponent == 1 : return base #一般为递归出口
        result = 1
        result = self.PowerWithUnsignedExponent(base,exponent>>1)
        result *= result
        if exponent & 1 : result *= base
        return result

if __name__ =='__main__':
    solution = Solution()
    ans = solution.intPow(0,0)
    print(ans)'''



'''class Solution():
    def Print1ToMaxOfNDigits(self,n):
        if n < 0: return
        numberList = [0 for i in range(0,n)]
        while(not ):
            self.PrintNumber()
    
    def Increment(self):
        
        
    def PrintNumber(self):'''

#13.调整数组顺序使奇数位于偶数前面
'''class Solution:

    def reOrderArray(self,originArray):
        odd = []
        even = []
        result = []
        for i in originArray:
            if i & 1: odd.append(i)
            else: even.append(i)
        result = odd + even
        return result


if __name__ =='__main__':
    solution = Solution()
    originArray = list(map(int,input().split(',')))
    ans = solution.reOrderArray(originArray)
    print(ans)'''

#14.链表中倒数第K个节点
#15 反转链表
'''class ListNode():
    def __init__(self,n):
        self.val = n
        self.next = None

class Solution():
    def reverseList(self,head):
        if head == None or head.next == None : return head
        result = self.reverseList(head.next)#可以返回头指针
        head.next.next = head
        head.next = None
        return result
    def findKthFromTail(self,head,k):
        temp = head
        lenth = 0
        while(temp):
            lenth+=1
            temp = temp.next
        if k>lenth or k <= 0: return 'beyond'
        else:
            revHead = self.reverseList(head)
            for i in range(k-1):revHead = revHead.next
            return revHead.val

if __name__ =='__main__':
    solution = Solution()
    a=ListNode(1)
    b=ListNode(2)
    c=ListNode(3)
    d=ListNode(4)
    a.next = b
    b.next = c
    c.next = d
    ans = solution.findKthFromTail(a,7)
    print(ans)'''

#合并两个排序的列表
'''class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution():
    def merge2List(self,l1,l2):
        if l1.val<=l2.val:
            firstNum = l1.val
            l1 = l1.next
        else:
            firstNum = l2.val
            l2 = l2.next
        head = ListNode(firstNum)
        #print("head.val = %d" % head.val)
        pre = head
        while(l1 and l2):
            if l1.val<=l2.val:
                node=ListNode(l1.val)
                l1 = l1.next
            else:
                node=ListNode(l2.val)
                l2 = l2.next
            pre.next = node
            pre = pre.next
        print("head.next.val = %d" % head.next.val)
        print("head.next.next.val = %d" % head.next.next.val)
        print("head.next.next.next.val = %d" % head.next.next.next.val)
        print("head.next.next.next.next.val = %d" % head.next.next.next.next.val)
        print("head.next.next.next.next.next.val = %d" % head.next.next.next.next.next.val)
        #self.printList(l1)
        #self.printList(l2)
        if (l1):
            while(l1):
                node=ListNode(l1.val)
                l2=l1.next
                pre.next = node
                pre = pre.next
        elif (l2):
            while(l2):
                node=ListNode(l2.val)
                l2=l2.next
                pre.next = node
                pre = pre.next
        #self.printList(head)
        return head

    def merge2ListV2(self, l1, l2):#递归
        if l1 is None : return l2
        if l2 is None : return l1
        if(l1.val >= l2.val):#只要进到了这里 就可以断定l1和l2都不空
            head = ListNode(l2.val)#创造一个新链表的头节点
            l2 = l2.next#l2的第一个元素最小  当作新链表头节点  自身头节点后移
            head.next = self.merge2ListV2(l1,l2)#递归 将头结点指向“排好序”的新链表的头结点
        else:
            head = ListNode(l1.val)
            l1 = l1.next
            head.next = self.merge2ListV2(l1, l2)
        return head

    def printList(self,l):
        while(l):
            print(l.val,end = ' ')
            l = l.next
        print('')
    def inputToALinkedList(self,str):
        if str == '' : return None
        numList = list(map(int,str.split(' ')))
        head = ListNode(numList[0])
        pre = head
        for i in range(1,len(numList)):
            node = ListNode(numList[i])
            pre.next = node
            pre = pre.next
        return head



if __name__ =='__main__':
    solution = Solution()
    a1=ListNode(1)
    a2=ListNode(4)
    a3=ListNode(5)
    a4=ListNode(9)
    a1.next = a2
    a2.next = a3
    a3.next = a4
    b1 = ListNode(2)
    b2 = ListNode(3)
    b3 = ListNode(10)
    b1.next=b2
    b2.next=b3
    #b1 = None
    l1 = solution.inputToALinkedList(input('依次输入l1链表的各个节点值 以单个空格隔开：'))
    solution.printList(l1)
    l2 = solution.inputToALinkedList(input('依次输入l2链表的各个节点值 以单个空格隔开：'))
    solution.printList(l2)
    ans = solution.merge2ListV2(l1,l2)
    solution.printList(ans)'''


#17.树的子结构
'''class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution():
    def hasSubTree(self,treeA,treeB):
        result = False
        if treeA != None and treeB != None:#只要有一个是None  就直接False
            if(treeA.val == treeB.val):
                result = self.doesTreeAHasTreeB(treeA,treeB)
            if(not result):
                result = self.hasSubTree(treeA.left,treeB)
            if(not result):
                result = self.hasSubTree(treeA.right, treeB)
        return result

    def doesTreeAHasTreeB(self,treeA,treeB):
        if treeB is None : return True #递归出口
        if treeA is None : return False #treeB非空  但是treeA空
        if treeA.val == treeB.val:
            return self.doesTreeAHasTreeB(treeA.left,treeB.left) and self.doesTreeAHasTreeB(treeA.right,treeB.right)
    def inorderTraversal(self,root,inorderList = None):
        #print(inorderList)
        if root is None : return
        if inorderList is None: inorderList = []
        self.inorderTraversal((root.left),inorderList)
        inorderList.append(root.val)
        self.inorderTraversal((root.right),inorderList)
        #print(inorderList)
        return inorderList
    #要么递归返回节点值  要么不返回值  递归传入列表



if __name__=='__main__':
    solution=Solution()
    pRootA1 = TreeNode(1)
    pRootA2 = TreeNode(2)
    pRootA3 = TreeNode(3)
    pRootA4 = TreeNode(4)
    pRootA5 = TreeNode(5)
    pRootA1.left=pRootA2
    pRootA1.right=pRootA3
    pRootA2.left=pRootA4
    pRootA2.right=pRootA5

    pRootB2 = TreeNode(2)
    pRootB4 = TreeNode(4)
    pRootB5 = TreeNode(5)
    pRootB2.left=pRootB4
    pRootB2.right = pRootB5
    #ans=solution.hasSubTree(pRootA1,pRootB2)
    #print(ans)
    l1 = solution.inorderTraversal(pRootA1)
    print(l1)
    print('--------------------')
    l2 = solution.inorderTraversal(pRootB2)
    print(l2)'''

#二叉树镜像
'''class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution():
    def mirrorOfBinaryTree(self,root):
        if root is None: return root
        root.left,root.right = root.right,root.left
        self.mirrorOfBinaryTree(root.left)
        self.mirrorOfBinaryTree(root.right)
        return root

    def inorderTraversal(self, root, inorderList=None):
        # print(inorderList)
        if root is None : return None
        if inorderList is None: inorderList = []
        self.inorderTraversal((root.left), inorderList)
        inorderList.append(root.val)
        self.inorderTraversal((root.right), inorderList)
        # print(inorderList)
        return inorderList

    def preorderTraversal(self,root,preorderList=None):
        if root is None : return None
        if preorderList is None : preorderList = []
        preorderList.append(root.val)
        self.preorderTraversal(root.left,preorderList)
        self.preorderTraversal(root.right,preorderList)
        return preorderList

    def postorderTraversal(self, root, postorderList=None):
        if root is None : return None
        if postorderList is None : postorderList = []
        self.postorderTraversal(root.left, postorderList)
        self.postorderTraversal(root.right, postorderList)
        postorderList.append(root.val)
        return postorderList


if __name__=='__main__':
    solution = Solution()
    pRootA1 = TreeNode(1)
    pRootA2 = TreeNode(2)
    pRootA3 = TreeNode(3)
    pRootA4 = TreeNode(4)
    pRootA5 = TreeNode(5)
    pRootA1.left = pRootA2
    pRootA1.right = pRootA3
    pRootA2.left = pRootA4
    pRootA2.right = pRootA5

    pRootB2 = TreeNode(2)
    pRootB4 = TreeNode(4)
    pRootB5 = TreeNode(5)
    pRootB2.left = pRootB4
    pRootB2.right = pRootB5

    solution = Solution()
    print('inorder:', end = '\t')
    print(solution.inorderTraversal(pRootA1))
    print('preorder:', end='\t')
    print(solution.preorderTraversal(pRootA1))
    print('postorder:', end='\t')
    print(solution.postorderTraversal(pRootA1))
    print('None:', end='\t')
    print(solution.postorderTraversal(None))
    #print(solution.inorderTraversal(solution.mirrorOfBinaryTree(pRootA1)))'''



#19.顺时针打印矩阵
'''class Solution():
    def printMatrixClockWise(self,matrix,row,column):
        if matrix is None or row <= 0 or column <= 0 : return
        start = 0
        while row > 2*start and column > 2*start :
            self.printACircleClockWise(matrix,row,column,start)
            start += 1

    def printACircleClockWise(self,matrix,row,column,start):
        for i in range(start,column-start):#yes
            print(matrix[start][i],end = ' ')#
        if(row -2*start >=2):
            for j in range(start+1,row - start):#yes
                print(matrix[j][column-1-start],end = ' ')#
            if(column - 2*start >=2):
                for k in range(column-start-2,start-1,-1):#
                    print(matrix[row-1-start][k],end = ' ')#
                if(row -2*start >=3):
                    for l in range (row-start-2,start,-1):#
                        print(matrix[l][start],end = ' ')

if __name__ == '__main__':
    matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
    for i in matrix : print(i)
    print('matrix is %d x %d'%(len(matrix),len(matrix[0])))
    solution = Solution()
    solution.printMatrixClockWise(matrix,len(matrix),len(matrix[0]))'''



#包含Min函数的栈
'''class Solution():
    def __init__(self):
        self.stackWithMin = []
    def pop(self):
         
    def push(self):

    def min(self):

        return minElem'''




#二叉树的后续遍历序列
'''class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution():
    def isPostOrderTraversal(self,l):
        if l is None or l==[] : return False
        root = l[-1]
        i = 0
        while i<=len(l)-2:
            if l[i]>root : break
            i+=1
        for j in range(i,len(l)-1):
            if l[j] < root : return False
            j+=1
        left = True
        if(i>0): left = self.isPostOrderTraversal(l[:i])
        right = True
        if(i<len(l)-1): right = self.isPostOrderTraversal((l[i:len(l)-1]))
        return left and right

    def numSmallerThanWholeList(self,num,l):
        for i in num:
            if num > i :return False
        return True

    def numBiggherThanWholeList(self, num, l):
        for i in num:
            if num < i: return False
        return True

if __name__=='__main__':
    solution = Solution()
    l = list(map(int,input("输入后续遍历序列，以逗号隔开：").split(',')))
    ans = solution.isPostOrderTraversal(l)
    print(ans)'''


#全排列
'''class Solution():
    def swap(self,strList,i,j):
        temp = strList[i]
        strList[i] = strList[j]
        strList[j] = temp

    def permutation(self,strList,start):
        if strList is None : return
        if start == len(strList) - 1 : print(''.join(strList),end = ' ')
        else:
            for i in range(start,len(strList)):#！！！之前start写成start+1 a自己当第一个时 和自己交换相当于直接后面的全排列  不能漏
                self.swap(strList,start,i)
                self.permutation(strList,start+1)
                self.swap(strList,i,start)

if __name__ == '__main__':
    solution = Solution()
    strList = list(input('enter a str:'))
    solution.permutation(strList,0)'''


#判断两个字符串是否为换位字符串
'''class Solution():
    def compare(self,str1,str2):
        if len(str1) != len(str2) : return False
        strLength = len(str1)
        compareList = [0 for i in range(256)]
        for i in range(strLength):
            compareList[ord(str1[i])]+=1
        for j in range(strLength):
            compareList[ord(str2[j])]-=1
        result = True
        for k in compareList:
            if k!=0:
                return False
        return result
    def isStr1IncludeStr2(self,str1,str2):
        if len(str2) == 0 : return True
        compareList = [0 for i in range(256)]
        for i in range(len(str1)):
            compareList[ord(str1[i])]+=1
        for j in range(len(str2)):
            compareList[ord(str2[j])]-=1
        for k in compareList:
            if k<0:
                return False
        return True
    def removeNestedBrackets(self,str):
        if str is None : return False,None
        numList = []
        countOfBrackets = 0
        for i in range(len(str)):
            #print(str[i])
            if str[i] not in ['(',')',',','1','2','3','4','5','6','7','8','9','0'] : return False,None
            if str[i] in ['1','2','3','4','5','6','7','8','9','0'] : numList.append(str[i])
            if str[i] == '(' :
                countOfBrackets += 1
                #print('after ( countOfBrackets = %d' % countOfBrackets)
            if str[i] == ')' :
                if countOfBrackets >= 1:
                    countOfBrackets -= 1
                    #print('after ) countOfBrackets = %d' % countOfBrackets)
                else : return False,None
        #print('')
        #print(countOfBrackets)
        if countOfBrackets == 0 : return True,'('+(','.join(numList))+')'
        else : return False,None

if __name__ == '__main__':
    solution = Solution()
    str1 = input('input a math expression:')
    #print(str1)
    #str2 = input()
    flag,ans = solution.removeNestedBrackets(str1)
    if flag == False: print('invalid input')
    else : print(ans)'''



'''class Solution():
    def match(self,longStr,shortStr):
        llen,slen = len(longStr),len(shortStr)
        if slen > llen : return -1
        i,j = 0,0
        while(i < llen and j < slen):
            if longStr[i] == shortStr[j] :  #匹配
                i+=1
                j+=1
            else:                           #不匹配
                i = i-j+1#i退回开头的下一个
                j=0#j退回0
        if j == slen : return i - slen #如果退出循环时j=slen 说明循环内完整匹配了
        else: return -1 #如果退出循环时 j！=slen  说明全程无匹配

    def matchWithKMP(self,primeStr,patternStr):
        llen, slen = len(longStr), len(shortStr)
        if slen > llen: return -1
        next = self.getNext(patternStr)
        i, j = 0, 0
        while (i < llen and j < slen):
            if j == -1 or longStr[i] == shortStr[j]:  # 匹配  当第一位就不匹配时让它像普通算法一样j回到0，i++
                i += 1
                j += 1
            else :  # 不匹配
                #i =
                j = next[j]#比过 后面不匹配回到next[j]  但如果第一个就不匹配  需要回到0并让i+1
        if j == slen:
            return i - slen
        else:
            return -1


    def getNext(self,str):#获得pmt数组 进而挪位获得next数组
        pmt = []
        for i in range(len(str)):
            pmt.append(self.getMaxPrefixAndSuffix(str[:i+1]))
        next = [-1 for j in range(len(pmt))]
        for k in range(1,len(pmt)):
            next[k] = pmt[k-1]
        return next

    def getMaxPrefixAndSuffix(self,str):#获得相同前后缀的最大长度
        if str is None : return None
        max = 0
        for i in range (1,len(str)):
            if str[:i] == str [-i:]: max = i
        return max

if __name__ == '__main__':
    solution = Solution()
    longStr = input('longStr:')
    shortStr = input('shortStr:')
    ans = solution.matchWithKMP(longStr,shortStr)
    print(ans)'''


#栈  push  pop top isEmpty
'''class MyStackByList():
    def __init__(self):
        self.stack = []

    def isEmpty(self):
        if len(self.stack) == 0 : return True
        else : return False

    def pop(self):
        if not self.isEmpty():
            return self.stack.pop()
        else: print('stack is empty')

    def push(self,item):
        self.stack.append(item)

    def top(self):
        if not self.isEmpty():
            return self.stack[-1]
        else: return None

class linkedListNode():
    def __init__(self,val = None):
        self.val = val
        self.next = None

class MyStackByLinkedList():
    def __init__(self):
        self.head = linkedListNode()

    def isEmpty(self):
        if self.head.next is None: return True
        else : return False

    def top(self):
        if not self.isEmpty():
            return self.head.next.val

    def push(self,item):
        newNode = linkedListNode(item)
        newNode.next = self.head.next
        self.head.next = newNode

    def pop(self):
        if not self.isEmpty():
            val = self.head.next.val
            self.head.next = self.head.next.next
            return val
        else: print('stack is empty')



if __name__ == '__main__':
    stack = MyStackByLinkedList()
    #stack.pop()
    #stack.top()
    stack.push(1)
    stack.push(2)
    print(stack.pop())
    print(stack.pop())
    print(stack.isEmpty())'''


class Sort():


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
        if l1 ==[] : return result.extend(l2) # 注意return  如果不return 下面数组越界了
        if l2 ==[] : return result.extend(l1)
        result = [] if result is None else result
        result.append(l1[0] if l1[0] <= l2[0] else l2[0])#访问了数组 特别注意l1是None或者l1是空
        if result[-1] == l1[0] : l1 = l1[1:]
        else : l2 = l2[1:]
        #print(result)
        self.merge2SortedList(l1,l2,result)
        return result

    def  mergeSort(self,l):
        '''
        归并排序
        '''
        if l is None or len(l) in [0,1] : return l
        if len(l) in [0,1] : return l
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
        if i-start >= 2:
            self.fastSort(l,start,i-1)
        if end - i >= 2:
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
        if lchild < limit:
            if lchild < limit and l[lchild] > l[max] : max = lchild
            if rchild < limit and l[rchild] > l[max] : max = rchild
            if max != i :
                l[max],l[i] = l[i],l[max]
                self.adjustHeap(l,max,limit)

    def buildHeap(self,l):
        for i in range((len(l)+1)//2)[::-1]:#从最后一个有子结点的标号到0
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
        if l is None or len(l) in [0,1] : return l
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
    l  = [73,-22,93,-43,55,-14,28,-22,65,-39,0,]
    l1=l2=l3=l4=l5=l6=l7=l8= [num for num in l]
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

