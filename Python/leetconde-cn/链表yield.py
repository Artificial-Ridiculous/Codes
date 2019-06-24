class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

n5 = ListNode(5)
n3 = ListNode(3)
n6 = ListNode(6)
n2 = ListNode(2)
n4 = ListNode(4)
n1 = ListNode(1)

n1.next=n2
n2.next=n3
n3.next=n4
n4.next=n5
n5.next=n6

# def fun(head:ListNode):
#     p = head
#     while(p):
#         yield p.val
#         p = p.next

# for i in fun(n1):
#     print(i)

def reverseList(head:ListNode):
    p = head
    if p is None : return None
    if(p and p.next):
        yield from reverseList(p.next)
        p.next.next=p
        p.next=None
    return head

def printList(head:ListNode):
    p = head
    while(p):
        print(p.val,end=',')
        p = p.next

# printList(n1)
# print('\n---')
for i in reverseList(n1): print (i.val)

        

