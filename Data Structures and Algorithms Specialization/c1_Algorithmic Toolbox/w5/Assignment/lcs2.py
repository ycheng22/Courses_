#Uses python3

import sys
import numpy as np

def lcs2(a, b):
    lena = len(a)
    lenb = len(b)
    dp = np.zeros((lena+1, lenb+1)) #the 0th row and 0th column are zeros, mismatch
    
    for i, a_val in enumerate(a): #enumerate from index 0, must add 1 in dp[i+1, j+1]
        for j, b_val in enumerate(b):
            if a_val == b_val:
                dp[i+1, j+1] = dp[i, j] + 1 #if match, common sequence length increases by 1
            else:
                dp[i+1, j+1] = max(dp[i+1, j], dp[i, j+1]) #not match, just keep the max in the left upper part
    
    return int(dp[lena, lenb])

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))

    n = data[0]
    data = data[1:]
    a = data[:n]

    data = data[n:]
    m = data[0]
    data = data[1:]
    b = data[:m]

    print(lcs2(a, b))
