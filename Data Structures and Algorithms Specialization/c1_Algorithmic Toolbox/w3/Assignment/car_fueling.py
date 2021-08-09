# python3
# =============================================================================
# import sys
# 
# 
# def compute_min_refills(distance, tank, stops):
#     # write your code here
#     return -1
# 
# if __name__ == '__main__':
#     d, m, _, *stops = map(int, sys.stdin.read().split())
#     print(compute_min_refills(d, m, stops))
# =============================================================================
import sys


def compute_min_refills(distance, tank, stops):
    if tank > distance:
        return 0
    stops.append(distance)
    stops.insert(0, 0)
    curr_fuel = tank
    num_stops = 0
    for i in range(len(stops)-1):
        if stops[i+1]-stops[i] > tank:
            return -1
        elif stops[i+1]-stops[i] > curr_fuel: #can't reach nect stop
            curr_fuel = tank #refill at current stop i
            curr_fuel -= (stops[i+1] - stops[i]) #fuel at stop i+1, used in next loop elif
            num_stops += 1
        else:
            curr_fuel -= (stops[i+1] - stops[i])
    
    return num_stops

if __name__ == '__main__':
    d, m, _, *stops = map(int, sys.stdin.read().split())
    print(compute_min_refills(d, m, stops))