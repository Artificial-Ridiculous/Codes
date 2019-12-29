class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        p = head
        if head is None or head and head.next is None : return head
        # l = [head.val,head.next.val,head.next.next.val,head.next.next.next.val,head.next.next.next.next.val]
        lenl = self.lenOfList(head)
        steps = k%lenl
        for i in range(steps):
            head = self.rotateOneStep(head)
        return head

    def rotateOneStep(self, head: ListNode) -> ListNode:
        if head is None or head and head.next is None : return head
        first = tolast = head
        while(tolast and tolast.next and tolast.next.next):
            tolast = tolast.next
        head = tolast.next
        head.next = first
        tolast.next=None
        return head        

    def lenOfList(self,head: ListNode) -> int:
        cnt = 0
        while(head):
            cnt+=1
            head = head.next
        return cnt

    def printList(self,head: ListNode):
        while(head):
            print(head.val)
            head = head.next
        return 

if __name__ == '__main__':
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    n5 = ListNode(5)

    n1.next=n2
    n2.next=n3
    # n3.next=n4
    # n4.next=n5

    solution = Solution()
    solution.printList(n1)
    ans = solution.rotateRight(n1,4)
    print('---')
    solution.printList(ans)