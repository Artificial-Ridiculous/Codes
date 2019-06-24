class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # rl1,rl2 = self.reverseList(l1),self.reverseList(l2)
        ll1 = self.lenOfList(l1)
        ll2 = self.lenOfList(l2)
        if ll1<ll2:
            l1,l2 = l2,l1  # l1比l2长
        p,q = l1,l2
        flag = False
        while(p):
            if flag: value = 1 + p.val+(0 if q is None else q.val)
            else: value = p.val+(0 if q is None else q.val)
            if value > 9 :
                p.val = value - 10
                flag = True
            else :
                p.val = value
                flag = False
            if p.next : p = p.next
            elif flag is True : 
                p.next = ListNode(1)
                break
            else:
                break
            if q : q=q.next
        return l1

    def lenOfList(self,head:ListNode):
        p = head
        cnt = 0
        while(p):
            cnt+=1
            p=p.next
        return cnt

    def reverseList(self,head:ListNode):
        p = head
        if p is None : return None
        if(p and p.next):
            head = self.reverseList(p.next)
            p.next.next=p
            p.next=None
        return head

    def printList(self,head:ListNode):
        p = head
        while(p):
            print(p.val,end=',')
            p = p.next
        print('\n-------')


if __name__ == '__main__':

    n5 = ListNode(5)
    n3 = ListNode(3)
    n6 = ListNode(6)
    n2 = ListNode(2)
    n4 = ListNode(4)
    n1 = ListNode(6)

    n2.next = n4
    n4.next = n3

    n5.next = n6
    n6.next = n1

    l1 = n2
    l2 = n5
    solution = Solution()
    solution.printList(l1)
    solution.printList(l2)
    res=solution.addTwoNumbers(l1,l2)
    solution.printList(res)