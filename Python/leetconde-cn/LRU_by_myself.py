class DLinkedListNode:
    def __init__(self,val):
        self.key = None
        self.val = val
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.dic = {}  # 字典 保证get为O(1)
        self.head = DLinkedListNode(0)  # 双向链表
        self.tail = DLinkedListNode(0)  # 保证Put为O(1)
        self.head.next=self.tail
        self.tail.prev=self.head
        self.capacity = capacity
        self.len = 0

    def add_node(self,node:DLinkedListNode):
        node.next = self.head.next
        node.prev = self.head

        self.head.next = node
        node.next.prev = node  # 之前这里写错 写成self.head

        # self.cache[node.val] = node

    def move_to_head(self,node:DLinkedListNode):
        self.remove_node(node)
        self.add_node(node)

    def remove_node(self,node:DLinkedListNode):
        node.prev.next = node.next
        node.next.prev = node.prev

        # node.next = None
        # node.prev = None

    def get(self, key: int) -> int:
        node = self.dic.get(key)
        if node:
            self.move_to_head(node)
            return self.head.next.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        node = self.dic.get(key)
        if node:  # 已经有这个key 更新value 更新链表位置
            self.dic[key].val = value
            self.move_to_head(node)
        elif self.len < self.capacity:  # 没有key 新增
            node = DLinkedListNode(value)
            node.key = key
            self.add_node(node)
            self.dic[key] = node
            self.len+=1
        else:  # 没有key 但是LRU已满  需要新增并移除最后一个节点
            node = DLinkedListNode(value)
            node.key = key
            self.add_node(node)
            self.dic[key] = node

            del self.dic[self.tail.prev.key]
            self.remove_node(self.tail.prev)


        # if self.len < self.capacity:
        #     newnode = DLinkedListNode(value)
        #     self.cache[key] = newnode
        #     self.add_node(newnode)
        #     self.len+=1 # 独有
        # else:    
        #     # 移除尾部节点👇
        #     self.remove_node(self.tail.prev)  # 独有
        #     self.cache.pop(key)
        #     # 添加新节点👇
        #     newnode = DLinkedListNode(value)
        #     self.cache[key] = newnode
        #     self.add_node(newnode)
        
    def printDLinkedList(self):
        p = self.head.next
        while(p and p.next):
            print(p.val,end=' ')
            p = p.next
        print('\n ------')
print('-----')
# cache = LRUCache(1)
# cache.put(2,1)
# cache.get(1)


cache = LRUCache( 2 )

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       # 返回  1
cache.put(3, 3);    # 该操作会使得密钥 2 作废
cache.get(2);       # 返回 -1 (未找到)
cache.put(4, 4);    # 该操作会使得密钥 1 作废
cache.get(1);       # 返回 -1 (未找到)
cache.get(3);       # 返回  3
cache.get(4);       # 返回  4










