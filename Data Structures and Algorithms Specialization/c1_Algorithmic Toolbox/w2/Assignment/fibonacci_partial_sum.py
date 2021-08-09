# Uses python3
#error: exceed time limit

import sys

def fibonacci_partial_sum_naive(from_, to):
    sum_digit = 0

    current = 0
    nex  = 1

    for i in range(to + 1):
        if i >= from_:
            sum_digit = (sum_digit + current) % 10

        current, nex = nex, (current + nex) % 10

    return sum_digit
if __name__ == '__main__':
    from_, to = map(int, input().split())
    print(fibonacci_partial_sum_naive(from_, to))
