# Uses python3
# =============================================================================
# import sys
# 
# def get_fibonacci_last_digit_naive(n):
#     if n <= 1:
#         return n
# 
#     previous = 0
#     current  = 1
# 
#     for _ in range(n - 1):
#         previous, current = current, previous + current
# 
#     return current % 10
# 
# if __name__ == '__main__':
#     input = sys.stdin.read()
#     n = int(input)
#     print(get_fibonacci_last_digit_naive(n))
# =============================================================================

#only keep the last digit for every Fib numbers
import sys

def get_fibonacci_last_digit_naive(n):
    if n <= 1:
        lastdigit =  n
    else: 
        pre_lastdigit = 0
        cur_lastdigit = 1
        for _ in range(n - 1):
            pre_lastdigit, cur_lastdigit = cur_lastdigit, \
                (pre_lastdigit + cur_lastdigit) % 10
        lastdigit = cur_lastdigit
    return lastdigit

n = int(input())
print(get_fibonacci_last_digit_naive(n))