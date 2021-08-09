# python3
import collections

def max_sliding_window_naive(sequence, m):
    d = collections.deque()
    out = []
    for i, n in enumerate(sequence):
        while d and sequence[d[-1]] < n: 
            d.pop()
        d.append(i)
        if d[0] == i-m:
            d.popleft() #Popped left from d because it's outside the window's leftmost (i-m)
        if i >= m-1: #start to output after index>=m
            out.append(sequence[d[0]])
    return out

if __name__ == '__main__':
    n = int(input())
    input_sequence = [int(i) for i in input().split()]
    assert len(input_sequence) == n
    window_size = int(input())

    print(*max_sliding_window_naive(input_sequence, window_size))

