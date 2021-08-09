# Uses python3
# =============================================================================
# import sys
# 
# def fibonacci_sum_naive(n):
#     if n <= 1:
#         return n
# 
#     previous = 0
#     current  = 1
#     sum      = 1
# 
#     for _ in range(n - 1):
#         previous, current = current, previous + current
#         sum += current
# 
#     return sum % 10
# 
# if __name__ == '__main__':
#     input = sys.stdin.read()
#     n = int(input)
#     print(fibonacci_sum_naive(n))
# =============================================================================
# F_n MOD 10 = F_(n mod 60) MOD 10
def fibonacci_sum_naive(n):
    remain_index = n % 60
    if remain_index < 1:
        return remain_index
    prev, curr = 0, 1
    sum_digit = 1
    for i in range(2, remain_index+1):
        prev, curr = curr, (prev + curr) % 10
        sum_digit = (sum_digit + curr) % 10
    return sum_digit

n = int(input())
print(fibonacci_sum_naive(n))