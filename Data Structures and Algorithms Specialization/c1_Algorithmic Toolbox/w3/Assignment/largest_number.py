#Uses python3

import sys

# =============================================================================
# def largest_number(a):
#     #write your code here
#     res = ""
#     for x in a:
#         res += x
#     return res
# =============================================================================
def IsGreaterOrEqual(digit, max_digit):
    return int(digit + max_digit) >= int(max_digit + digit) #string addition, then int

def largest_number(a):
    result = []
    
    while a:
        max_digit = "0"
        for digit in a: #every loop, find the largest digit in the remaining values in a
            if IsGreaterOrEqual(digit, max_digit):
                max_digit = digit
        result.append(max_digit)
        a.remove(max_digit)
    
    res = ""
    for x in result:
        res += x #x is string
    return res

if __name__ == '__main__':
    input = sys.stdin.read()
    data = input.split() #inputs are string
    a = data[1:]
    print(largest_number(a))
    
