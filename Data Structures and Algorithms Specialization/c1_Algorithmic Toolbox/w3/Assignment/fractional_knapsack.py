# Uses python3
# =============================================================================
# import sys
# 
# def get_optimal_value(capacity, weights, values):
#     value = 0.
#     # write your code here
# 
#     return value
# 
# 
# if __name__ == "__main__":
#     data = list(map(int, sys.stdin.read().split()))
#     n, capacity = data[0:2]
#     values = data[2:(2 * n + 2):2]
#     weights = data[3:(2 * n + 2):2]
#     opt_value = get_optimal_value(capacity, weights, values)
#     print("{:.10f}".format(opt_value))
# =============================================================================
import sys

def get_optimal_value(capacity, weights, values):
    value_per_weit= [values[i] / weights[i] for i in range(len(values))]
    sort_value_per_weight = sorted(value_per_weit, reverse=True)
    sort_weights_by_vpw = [weights[value_per_weit.index(sort_vpw)] for sort_vpw in sort_value_per_weight]
    
    value_all = 0
    filled = 0
    i = 0
    while i < len(values) and filled < capacity:
        if filled + sort_weights_by_vpw[i] > capacity:
            return value_all + (capacity-filled)*sort_value_per_weight[i]
        else:
            filled += sort_weights_by_vpw[i]
            value_all += sort_value_per_weight[i]*sort_weights_by_vpw[i]
            i+=1

    return value_all


if __name__ == "__main__":
    data = list(map(int, sys.stdin.read().split()))
    n, capacity = data[0:2]
    values = data[2:(2 * n + 2):2]
    weights = data[3:(2 * n + 2):2]
    opt_value = get_optimal_value(capacity, weights, values)
    print("{:.10f}".format(opt_value))