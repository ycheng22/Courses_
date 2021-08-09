#python3
import sys

class StackWithMax():
    def __init__(self):
        self.stack = []
        self.mx = None #maximum

    def Push(self, a):
        if len(self.stack) == 0:
            self.mx = a
            self.stack.append(a)
        elif self.mx < a:
            self.stack.append(2*a - self.mx) #tricky, example: push 1, push 2, max, pop, max
            self.mx = a
        else:
            self.stack.append(a)

    def Pop(self):
        assert(len(self.stack))
        if self.mx >= self.stack[-1]:
            self.stack.pop()
        else:
            self.mx = 2*self.mx - self.stack[-1] #tricky
            self.stack.pop()

    def Max(self):
        assert(len(self.stack))
        return self.mx


if __name__ == '__main__':
    stack = StackWithMax()

    num_queries = int(sys.stdin.readline())
    for _ in range(num_queries):
        query = sys.stdin.readline().split()

        if query[0] == "push":
            stack.Push(int(query[1]))
        elif query[0] == "pop":
            stack.Pop()
        elif query[0] == "max":
            print(stack.Max())
        else:
            assert(0)

# =============================================================================
# 这个方法没有通过，需要多看看别的解法
# #python3
# import sys
# 
# class StackWithMax():
#     def __init__(self):
#         self.stack = []
#         self.mx = None #maximum
#         self.pre_mx = None #track the second maximun, usefull when pop was called
# 
#     def Push(self, a):
#         if len(self.stack) == 0:
#             self.mx = a
#             self.pre_mx = a
#             self.stack.append(a)
#         elif self.mx < a:
#             self.stack.append(a) #tricky, example: push 1, push 2, max, pop, max
#             self.pre_mx = self.mx
#             self.mx = a
#         else:
#             self.stack.append(a)
# 
#     def Pop(self):
#         assert(len(self.stack))
#         if self.mx > self.stack[-1]: #if poped smaller number, keep the maximum record
#             self.stack.pop()
#         else:
#             self.mx = self.pre_mx 
#             self.stack.pop()
# 
#     def Max(self):
#         assert(len(self.stack))
#         return self.mx
# 
# 
# if __name__ == '__main__':
#     stack = StackWithMax()
# 
#     num_queries = int(sys.stdin.readline())
#     for _ in range(num_queries):
#         query = sys.stdin.readline().split()
# 
#         if query[0] == "push":
#             stack.Push(int(query[1]))
#         elif query[0] == "pop":
#             stack.Pop()
#         elif query[0] == "max":
#             print(stack.Max())
#         else:
#             assert(0)
# 
# =============================================================================
