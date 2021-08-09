# Uses python3
import sys
from collections import namedtuple
Event = namedtuple('Event', ['coordinate', 'type', 'index'])

def fast_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    events = []
    
    for i in range(len(starts)):
        events.append(Event(starts[i], 'l', i))
        events.append(Event(ends[i], 'r', i))
    for i in range(len(points)):
        events.append(Event(points[i], 'p', i))
        
    events = sorted(events)
    num_of_seg = 0
    for event in events:
        if event.type == 'l':
            num_of_seg += 1
        elif event.type == 'p':
            cnt[event.index] = num_of_seg
        elif event.type == 'r':
            num_of_seg -= 1
    return cnt


def naive_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    for i in range(len(points)):
        for j in range(len(starts)):
            if starts[j] <= points[i] <= ends[j]:
                cnt[i] += 1
    return cnt

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    m = data[1]
    starts = data[2:2 * n + 2:2]
    ends   = data[3:2 * n + 2:2]
    points = data[2 * n + 2:]
    #use fast_count_segments
    cnt = fast_count_segments(starts, ends, points)
    for x in cnt:
        print(x, end=' ')
