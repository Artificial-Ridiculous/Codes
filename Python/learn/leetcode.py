import time


'''class Solution:
    def generateMatrix(self, n: int):
        if n == 1: return [[1]]
        matrix = [[0 for j in range(n)] for i in range(n)]
        loops = (n + 1) // 2
        for i in range(loops):
            self.generateLoop(n,i,matrix)
        return matrix
    def generateLoop(self,n,current_loop,matrix):
        # right
        start = 4 * current_loop * (n - current_loop) + 1
        end = start +(n+1-2*(1+current_loop))
        temp = [i for i in range(start,end)[::-1]]
        print(temp)
        for j in range(current_loop,n-1-current_loop):
            matrix[current_loop][j] = temp.pop()
        # down
        start = end
        end = start +(n+1-2*(1+current_loop))
        temp = [i for i in range(start, end)[::-1]]
        print(temp)
        for j in range(current_loop, n - 1 - current_loop):
            matrix[j][n-1-current_loop] = temp.pop()
        # left
        start = end
        end = start +(n+1-2*(1+current_loop))
        temp = [i for i in range(start, end)[::-1]]
        print(temp)
        for j in range(current_loop+1, n - current_loop)[::-1]:
            matrix[n-1-current_loop][j] = temp.pop()
        # up
        start = end
        end = start +(n+1-2*(1+current_loop))
        temp = [i for i in range(start, end)[::-1]]
        print(temp)
        for j in range(current_loop+1 , n - current_loop)[::-1]:
            matrix[j][current_loop] = temp.pop()
        if n%2 == 1 :
            matrix[n//2][n//2] = n*n'''

class Solution :
    def generateMatrix(self, m, n): # m行 n列
        res = [[0]*n for i in range(m)]
        value = 1
        startX = 0
        startY = 0
        endX = n-1 #下标
        endY = m-1 #下标
        while startX<=endX and startY<=endY :
            #如果只有一列
            if startX==endX :
                for i in range(startY,endY+1):
                    res[i][endX] = value
                    value+=1
                return res
            #如果只有一行
            if startY==endY :
                for i in range(startX,endX+1):
                    res[endY][i] = value
                    value+=1
                return res
            #遍历StartX->endX
            for i in range(startX,endX):
                res[startY][i] = value
                value += 1
            #遍历startY->endY
            for i in range(startY,endY):
                res[i][endX] = value
                value += 1
            #遍历endX->startX
            for i in range(startX+1,endX+1)[::-1]:
                res[endY][i]=value
                value+=1
            #遍历endY->startY
            for i in range(startY+1,endY+1)[::-1]:
                res[i][startX]=value
                value+=1
            startX+=1
            startY+=1
            endX-=1
            endY-=1
        return res

if __name__ == "__main__":
    solution = Solution()
    m = 5
    n = 6
    start = time.perf_counter()
    res = solution.generateMatrix(m,n)
    end = time.perf_counter()

    for l in res:
        print (l)
    #print("%s%s%s" % ("time used: ", (end - start), "s"))
