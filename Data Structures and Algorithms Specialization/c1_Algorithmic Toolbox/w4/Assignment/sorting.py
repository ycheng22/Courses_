# =============================================================================
# # Uses python3
# import sys
# import random
# 
# def partition3(a, l, r):
#     #write your code here
#     pass
# 
# def partition2(a, l, r):
#     x = a[l]
#     j = l
#     for i in range(l + 1, r + 1):
#         if a[i] <= x:
#             j += 1
#             a[i], a[j] = a[j], a[i]
#     a[l], a[j] = a[j], a[l]
#     return j
# 
# 
# def randomized_quick_sort(a, l, r):
#     if l >= r:
#         return
#     k = random.randint(l, r)
#     a[l], a[k] = a[k], a[l]
#     #use partition3
#     m = partition2(a, l, r)
#     randomized_quick_sort(a, l, m - 1);
#     randomized_quick_sort(a, m + 1, r);
# 
# 
# if __name__ == '__main__':
#     input = sys.stdin.read()
#     n, *a = list(map(int, input.split()))
#     randomized_quick_sort(a, 0, n - 1)
#     for x in a:
#         print(x, end=' ')
# 
# =============================================================================
# Uses python3
import sys
import random

def partition3(a, l, r):
    x = a[l]
    i_less = l
    i_less_equal = l
    i_high = r
    while i_less_equal <= i_high:
        if a[i_less_equal] < x:
            a[i_less_equal], a[i_less] = a[i_less], a[i_less_equal]
            i_less += 1
            i_less_equal += 1
        elif a[i_less_equal] == x:
            i_less_equal += 1
        else:
            a[i_less_equal], a[i_high] = a[i_high], a[i_less_equal]
            i_high -= 1
    m12 = [i_less, i_high]
    return m12

def partition2(a, l, r):
    x = a[l]
    j = l
    for i in range(l + 1, r + 1):
        if a[i] <= x:
            j += 1
            a[i], a[j] = a[j], a[i]
    a[l], a[j] = a[j], a[l]
    return j


def randomized_quick_sort(a, l, r):
    if l >= r:
        return
    k = random.randint(l, r)
    a[l], a[k] = a[k], a[l]
    #use partition3
    m = partition3(a, l, r)
    randomized_quick_sort(a, l, m[0] - 1);
    randomized_quick_sort(a, m[1] + 1, r);


if __name__ == '__main__':
    input = sys.stdin.read()
    n, *a = list(map(int, input.split()))
    randomized_quick_sort(a, 0, n - 1)
    for x in a:
        print(x, end=' ')
