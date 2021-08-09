# python3

class HeapBuilder:
    
    def __init__(self, data):
        self.data = data
        self.swaps = []
        self.size = len(data)
        
    def shift_down(self, i):
        """
        shift i-th node down to construct binary min_heap, 
        which means children is higher than parent
        0-based indices
        """
        min_index = i
        l_idx = 2 * i + 1 #index of left child
        r_idx = 2 * i + 2
        
        if l_idx <= self.size-1 and self.data[l_idx] < self.data[min_index]:
            min_index = l_idx
        if r_idx <= self.size-1 and self.data[r_idx] < self.data[min_index]:
            min_index = r_idx
        if i != min_index:
            self.swaps.append((i, min_index))
            self.data[i], self.data[min_index] = self.data[min_index], self.data[i]
            self.shift_down(min_index)
        
    def build_heap(self):
        
        for i in range((self.size-1) // 2, -1, -1):
            self.shift_down(i)

def main():
    n = int(input())
    data = list(map(int, input().split()))
    assert len(data) == n

    heap_builder  = HeapBuilder(data)
    heap_builder.build_heap()
    
    print(len(heap_builder.swaps))
    for i, j in heap_builder.swaps:
        print(i, j)


if __name__ == "__main__":
    main()
