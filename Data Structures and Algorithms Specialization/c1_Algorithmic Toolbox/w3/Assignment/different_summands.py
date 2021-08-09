# Uses python3
import sys
import math
# =============================================================================
# def optimal_summands(n):
#     summands = []
#     #write your code here
#     return summands
# =============================================================================
def optimal_summands(n):
    summands = []
    if n==1:
        return [1]
    else:
        m = 2 * int(math.sqrt(n)) + 1
        for i in range(1, m):
            if n > 2 * i:
                summands.append(i)
                n -= i
            else:
                summands.append(n)

    return summands

if __name__ == '__main__':
    input = sys.stdin.read()
    n = int(input)
    summands = optimal_summands(n)
    print(len(summands))
    for x in summands:
        print(x, end=' ')
