# Uses python3
import sys
import numpy as np

def optimal_weight(W, w):
    value = np.zeros((W+1, len(w)+1))
    
    for i in range(1, len(w)+1):
        for j in range(1, W+1):
            value[j, i] = value[j, i-1]
            if w[i-1] <= j: #index for w start with 0
                val = value[j-w[i-1], i-1] + w[i-1]
                if value[j, i] < val:
                    value[j, i] = val
    return int(value[-1,-1])
        
if __name__ == '__main__':
    input = sys.stdin.read()
    W, n, *w = list(map(int, input.split()))
    print(optimal_weight(W, w))
