class Solution:
    def test1(self,a,b,c):
        print(a,b,c)

    def test2(self,d,e,f):
        print(d,e,f)

    def test3(self,*args):
        print(args)

    def test4(self,**kwargs):
        print(kwargs)

if __name__ == '__main__':
    solution = Solution()

    args=(1,2,3)
    solution.test1(*args)

    kwargs = {'d':4,'e':5,'f':6}
    solution.test2(**kwargs)

    solution.test3(7,8,9)

    solution.test4(g=10,h=11,i=12)

