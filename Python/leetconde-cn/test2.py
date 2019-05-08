class Solution:
    def test1(self,*args):
        print(args)

    def test2(self,**kwargs):
        print(args)

    def test3(self,*args):
        print(args)

    def test4(self,**kwargs):
        print(args)

if __name__ == '__main__':
    solution = Solution()
    solution.test1(a=1,b=2,c=3)
    solution.test2(a=1,b=2,c=3)
    solution.test3(a=1,b=2,c=3)
    solution.test4(a=1,b=2,c=3)