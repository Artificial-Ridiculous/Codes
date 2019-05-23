class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

'''class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not (head and head.next): return head
        pre, slow, fast = None, head, head
        while fast and fast.next: pre, slow, fast = slow, slow.next, fast.next.next
        pre.next = None
        return self.mergeTwoLists(*map(self.sortList, (head, slow)))
    
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if l1.val > l2.val: l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1 or l2'''

class Solution:
    def merge2SortedLists(self,l1,l2):
        if l1 is None: return l2
        if l2 is None: return l1
        if l1.val >= l2.val: l1,l2 = l2,l1
        l1.next = self.merge2SortedLists(l1.next,l2)
        return l1 or l2

    def sortList(self,l):
        if not (l and l.next) : return l
        pre,fast,slow = None,l,l
        while (fast and fast.next):
            pre,fast,slow = slow,fast.next.next,slow.next
        pre.next = None
        return self.merge2SortedLists(*map(self.sortList,(l,slow)))



if __name__ == '__main__':
    solution = Solution()
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    n1.next=n3
    n2.next=n4
    ans = solution.merge2SortedLists(n1,n2)
    print(ans.val)
    print(ans.next.val)
    print(ans.next.next.val)
    print(ans.next.next.next.val)