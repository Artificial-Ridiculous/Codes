class Solution:
    def spiralOrder(self, matrix):
        lenX = len(matrix[0])
        lenY = len(matrix)
        startX = 0
        endX = lenX-1
        startY = 0
        endY = lenY-1
        l = []
        while (startX <= endX and startY <= endY):
            while(startY <= endY):
                for i in range(startX,endX):
                    l.append(matrix[startY][i])
                for i in range(startY,endY):
                    l.append(matrix[i][endX])
                for i in range(startX+1,endX+1)[::-1]:
                    l.append(matrix[endY][i])
                for i in range(startY+1,endY+1)[::-1]:
                    l.append(matrix[i][startX])
                startX+=1
                endX-=1
                startY+=1
                endY-=1
        return l


if __name__ == '__main__':
    matrix = [
    [ 1, 2, 3 ,4,5,6],
    [ 7,8,9,10,11,12],
    [ 13,14,15,16,17,18 ],
    [19,20,21,22,23,24]
    ]
    solution = Solution()
    solution.spiralOrder(matrix)

    