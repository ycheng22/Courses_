# Uses python3
def evalt(a, b, op):
    if op == '+':
        return a + b
    elif op == '-':
        return a - b
    elif op == '*':
        return a * b
    else:
        assert False

def min_and_max(i, j, mins, maxs, operations):
    import math
    min_val = math.inf
    max_val = -math.inf
    for k in range(i, j):
        a = evalt(maxs[i][k], maxs[k+1][j], operations[k])
        b = evalt(maxs[i][k], mins[k+1][j], operations[k])
        c = evalt(mins[i][k], maxs[k+1][j], operations[k])
        d = evalt(mins[i][k], mins[k+1][j], operations[k])
        min_val = min(min_val, a, b, c, d)
        max_val = max(max_val, a, b, c, d)
    return min_val, max_val
    

def get_maximum_value(dataset):
    numbers = list(map(int, dataset[::2]))
    operations = dataset[1::2]
    n = len(numbers)
    
    mins = [[None] * n for _ in range(n)]
    maxs = [[None] * n for _ in range(n)]
    for i in range(n):
        mins[i][i] = numbers[i]
        maxs[i][i] = numbers[i]
        
    for s in range(1, n):
        for i in range(n-s):
            j = i + s
            mins[i][j], maxs[i][j] = min_and_max(i, j, mins, maxs, operations)
    
    return maxs[0][-1]


if __name__ == "__main__":
    print(get_maximum_value(input()))
