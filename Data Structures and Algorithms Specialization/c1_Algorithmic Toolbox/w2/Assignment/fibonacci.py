# Uses python3
# =============================================================================
# def calc_fib(n):
#     if (n <= 1):
#         return n
# 
#     return calc_fib(n - 1) + calc_fib(n - 2)
# 
# n = int(input())
# print(calc_fib(n))
# =============================================================================


def calc_fib(n):
    if n <= 1:
        fib_n = n
    else:
        fib_list = [0] * (n + 1)
        fib_list[1] = 1
        for i in range(2, n+1):
            fib_list[i] = fib_list[i - 1] + fib_list[i - 2]
        fib_n = fib_list[-1]

    return fib_n

n = int(input())
print(calc_fib(n))