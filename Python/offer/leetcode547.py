class Solution:
    def findCircleNum(self, M) -> int:
        n = len(M)
        count=0
        visited = [False for j in range(n)]
        #外层循环保证把每个节点都访问一遍
        #i代表n个顶点中的第i个顶点
        for i in range(n):
            if visited[i]:
                continue
            else:
                visited[i]=True
                count+=1
                for j in range(n):
                    if M[i][j]==1 and visited[j] is False:
                        self.dfs(M,j,visited,n)
        return count

    def dfs(self,M,i,visited,n):
        visited[i]=True
        for j in range(n):
            if M[i][j]==1 and visited[j] is False:
                self.dfs(M,j,visited,n)
            
if __name__ == '__main__':
    solution = Solution()
    M = [[1,1,0],[1,1,0],[0,0,1]]
    res = solution.findCircleNum(M)
    print(res)