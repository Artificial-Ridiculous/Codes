from functools import reduce

list1 = [1,2,3,4,1,1]

list2 = [1,3,5,7]

list3 = list(map(lambda x,y:x+y,list1,list2))

print(list3)

list4 = reduce(lambda x,y:x+y,list3)

print(list4)


