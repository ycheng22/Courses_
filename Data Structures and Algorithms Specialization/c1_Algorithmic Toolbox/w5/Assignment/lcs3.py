#Uses python3

import sys
import numpy as np

def lcs3(a, b, c):
    lena = len(a)
    lenb = len(b)
    lenc = len(c)
    dp = np.zeros((lena+1, lenb+1, lenc+1)) #the 0th row and 0th column are zeros, mismatch
    
    for i, a_val in enumerate(a): #enumerate from index 0, must add 1 in dp[i+1, j+1]
        for j, b_val in enumerate(b):
            for k, c_val in enumerate(c):
                if a_val == b_val == c_val:
                    dp[i+1, j+1, k+1] = dp[i, j, k] + 1 #if match, common sequence length increases by 1
                else:
                    dp[i+1, j+1, k+1] = max(dp[i+1, j+1, k], dp[i, j+1, k+1], dp[i+1, j, k+1]) #not match, just keep the max in the calculated ijk part
    
    return int(dp[lena, lenb, lenc])

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    an = data[0]
    data = data[1:]
    a = data[:an]
    data = data[an:]
    bn = data[0]
    data = data[1:]
    b = data[:bn]
    data = data[bn:]
    cn = data[0]
    data = data[1:]
    c = data[:cn]
    print(lcs3(a, b, c))
