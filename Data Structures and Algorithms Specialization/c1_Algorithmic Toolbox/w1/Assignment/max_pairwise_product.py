# python3


# =============================================================================
# def max_pairwise_product(numbers):
#     n = len(numbers)
#     max_product = 0
#     for first in range(n):
#         for second in range(first + 1, n):
#             max_product = max(max_product,
#                 numbers[first] * numbers[second])
# 
#     return max_product
# =============================================================================
def max_pairwise_product(numbers):
    n = len(numbers)
    
    maxindex1 = -1
    for i in range(n):
        if maxindex1 == -1 or numbers[i] > numbers[maxindex1]:
            maxindex1 = i
    
    maxindex2 = -1
    for j in range(n):
        if (j != maxindex1) and (maxindex2 == -1 or numbers[j] > numbers[maxindex2]):
            maxindex2 = j

    return numbers[maxindex1] * numbers[maxindex2]

if __name__ == '__main__':
    input_n = int(input())
    input_numbers = [int(x) for x in input().split()]
    print(max_pairwise_product(input_numbers))
