f=open('scores.txt',encoding='utf-8-sig')
lines=f.readlines()
f.close()
results=[]
for line in lines:
    sum=0
    array=line.split(' ')
    for score in array[1:]:
        sum+=int(score)
    result='%s\'s score is %d\n'%(array[0],sum)
    results.append(result)
    print(result,end='')
#print(results)
output=open('results6.txt','w',encoding='utf-8-sig')
output.writelines(results)
output.close()
