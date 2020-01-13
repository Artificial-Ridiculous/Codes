class Solution:


    def func(self,n2,l):
        n = n2 / 2; 
        sum = 0
        for i in range(n2):
            sum += l[i]
            i+=1

        flag=[[False for i in range(sum // 2 + 1)] for j in range(n2+1)]  
        for i in range(n2):
            for j in range(sum // 2 + 1):
                flag[i][j]=False 
          
        flag[0][0] = True  
        
        for k in range(n2):
            i = n if k>n else k
            while(i>=1):
                for j in range(sum//2 + 1):
                    if j>=l[k] and flag[i-1][j-l[k]]:
                        flag[i][j]=True
                i-=1
        i=sum//2
        while(i>=0):
            
            i-=1
        for (i = sum / 2; i >= 0; i--) {  
            if (flag[n][i]) {  
                System.out.println("sum is " + sum);  
                System.out.println("sum/2 is " + sum / 2);  
                System.out.println("i is " + i);  
                System.out.println("minimum delta is " + Math.abs(2 * i - sum));  
                break;  
            }  
        }  
    }  

import sys
solution = Solution()
l=[]
n = int(sys.stdin.readline().strip())
for i in range(n):
    k=int(sys.stdin.readline().strip())
    l = list(map(int,sys.stdin.readline().strip().split(" ")))
    ans = solution.func(k,l)
    print(ans)

