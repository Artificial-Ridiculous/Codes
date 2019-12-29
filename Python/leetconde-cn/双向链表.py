class DLinkedListNode:
    def __init__(self,val):
        self.pre = None
        self.next = None
        self.val = val

n1 = DLinkedListNode(1)
n2 = DLinkedListNode(2)
n3 = DLinkedListNode(3)

n1.next = n2
n2.next = n3

n2.pre = n1
n3.pre = n2


def printDLinkedListNode(head:DLinkedListNode):
    p = head
    while(p):
        print(p.val,end=' ')
        p = p.next
    print('\n---')

def deleteDLinkedListNode(target:DLinkedListNode):
    target.pre.next = target.next
    target.next.pre = target.pre
    target.pre = None
    target.next = None

def addDLinkedListNode(after:DLinkedListNode,target:DLinkedListNode):
    target.next = after.next
    target.pre = after
    after.next = target
    target.next.pre = target

printDLinkedListNode(n1)
deleteDLinkedListNode(n2)
printDLinkedListNode(n1)
addDLinkedListNode(n1,n2)
printDLinkedListNode(n1)
