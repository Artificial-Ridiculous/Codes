m=7
n=3

matrix = [[None]*m]*n
matrix[0] = [1]*m
for i in range(n): matrix[i][0] = 1
print(matrix)

for y in range(1,n):
    for x in range(1,m):
        matrix[y][x] = matrix[y-1][x]+matrix[y][x-1]

print(matrix)