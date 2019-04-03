import math

def getRoots(a ,b, c):
    b24ac = b**2-4*a*c
    if(b24ac >= 0):
        x1 = (-b+math.sqrt(b24ac))/(2*a)
        x2 = (-b-math.sqrt(b24ac))/(2*a)
        if(x1 == x2):
            print('x1=x2=%.2f' % x1)
        else:
            print('x1=%.2f\nx2=%.2f'%(x1,x2))
    else:
        print('no root')
