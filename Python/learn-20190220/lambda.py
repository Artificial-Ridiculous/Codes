def fn(x):

return lambda y: x + y



a = fn(2)

print a(3)
