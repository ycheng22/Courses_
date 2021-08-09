# Uses python3
# =============================================================================
# import sys
# 
# def get_fibonacci_huge_naive(n, m):
#     if n <= 1:
#         return n
# 
#     previous = 0
#     current  = 1
# 
#     for _ in range(n - 1):
#         previous, current = current, previous + current
# 
#     return current % m
# 
# if __name__ == '__main__':
#     input = sys.stdin.read();
#     n, m = map(int, input.split())
#     print(get_fibonacci_huge_naive(n, m))
# =============================================================================


def get_fibonacci_huge_naive(n, m):
    #get pisano period of given m, remember the period start to repeat with 01
    prev = 0
    curr = 1
    for i in range(m*m+1):
        prev, curr = curr, (prev + curr) % m
        if (prev, curr) == (0, 1):
            len_pasino = i + 1
            break
    
    remain_index = n % len_pasino
    if remain_index < 1:
        return remain_index
    prev, curr = 0, 1
    for i in range(2, remain_index+1):
        prev, curr = curr, (prev + curr) % m

    return curr

if __name__ == '__main__':
    n, m = map(int, input().split())
    print(get_fibonacci_huge_naive(n, m))