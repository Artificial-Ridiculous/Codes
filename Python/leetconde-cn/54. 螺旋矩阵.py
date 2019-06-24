class Solution:
    def spiralOrder(self, matrix):
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0 : return []
        # lenX = len(matrix[0])
        # lenY = len(matrix)
        # startX = 0
        # endX = lenX
        # startY = 0
        # endY = lenY
        # l = []
        # while (startX <= endX and startY <= endY):
        #     if (startY<endY):
        #         for i in range(startX,endX):
        #             l.append(matrix[startY][i])
        #     startY+=1
        #     if (startX<endX):
        #         for i in range(startY,endY):
        #             l.append(matrix[i][endX-1])
        #     endX-=1
        #     if (startY<endY):
        #         for i in range(startX,endX)[::-1]:
        #             l.append(matrix[endY-1][i])
        #     endY-=1
        #     if (startX<endX):
        #         for i in range(startY,endY)[::-1]:
        #             l.append(matrix[i][startX])
        #     startX+=1
        l,x,y,dx,dy = [],0,0,1,0
        for _ in range(len(matrix)*len(matrix[0])):
            l.append(matrix[y][x])
            matrix[y][x] = None
            if matrix[(y+dy)%len(matrix)][(x+dx)%len(matrix[0])] is None:
                dx,dy = -dy,dx
            x+=dx
            y+=dy
        return l


if __name__ == '__main__':
    
    m0 = []
    m00 = [[],[]]
    m1 = [[1]]
    m3 = [[1,2,3]]
    m33 = [
        [1],
        [2],
        [3]
    ]
    m4 = [
        [1,2],
        [3,4]
    ]
    m6 = [
        [1,2],
        [3,4],
        [5,6]
    ]
    m12=[
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12]
    ]
    m9 = [
        [1,2,3],
        [4,5,6],
        [7,8,9]
    ]
    m16 = [
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12],
        [13,14,15,16]
    ]
    m10 = [
        [1,2,3,4,5],
        [6,7,8,9,10]
    ]


    solution = Solution()
    ans = solution.spiralOrder(m10)
    print(ans)

    