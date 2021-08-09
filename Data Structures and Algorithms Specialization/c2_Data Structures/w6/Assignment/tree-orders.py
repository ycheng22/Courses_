# python3

import sys, threading
sys.setrecursionlimit(10**6) # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size

class TreeOrders:
  def read(self):
    self.n = int(sys.stdin.readline())
    self.key = [0 for i in range(self.n)]
    self.left = [0 for i in range(self.n)]
    self.right = [0 for i in range(self.n)]
    for i in range(self.n):
      [a, b, c] = map(int, sys.stdin.readline().split())
      self.key[i] = a
      self.left[i] = b
      self.right[i] = c

  def inOrder(self):
    idx = 0
    stack = []
    while True:
        if idx != -1:
            stack.append(idx)
            idx = self.left[idx]
        elif stack:
            idx = stack.pop()
            yield self.key[idx]
            idx = self.right[idx]
        else:
            break

  def preOrder(self):
    idx = 0
    stack = []
    while True:
        if idx != -1:
            yield self.key[idx]
            stack.append(idx)
            idx = self.left[idx]
        elif stack:
            idx = stack.pop()
            idx = self.right[idx]
        else:
            break

  def postOrder(self):
      stack1 = [0]
      stack2 = []
      
      while stack1:
          idx = stack1.pop()
          stack2.append(self.key[idx])
          left_idx = self.left[idx]
          right_idx = self.right[idx]
          if left_idx != -1:
              stack1.append(left_idx)
          if right_idx != -1:
              stack1.append(right_idx)
      while stack2:
          yield stack2.pop()
    
def main():
	tree = TreeOrders()
	tree.read()
	print(" ".join(str(x) for x in tree.inOrder()))
	print(" ".join(str(x) for x in tree.preOrder()))
	print(" ".join(str(x) for x in tree.postOrder()))

threading.Thread(target=main).start()
