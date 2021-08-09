#Uses python3

import sys

def negative_cycle(adj, cost):
    dist = [-1] * len(adj)
    prev = [-1] * len(adj)
    #start from 1st vertex
    dist[0] = 0
    #run BellmanFord V-1 times
    #if no negative cycles, then this should be the last iteration of changes
    for i in range(len(adj)): #run V times
        for j in range(len(adj)):
            for idx, k in enumerate(adj[j]):
                cost_jk = cost[j][idx]
                if dist[k] > dist[j] + cost_jk:
                    dist[k] = dist[j] + cost_jk
                    prev[k] = j
        #check at V-1 and V to see if they change
        if i == len(adj) -2 :
            dist_V_minus1 = list(dist)
        if i == len(adj) - 1:
            dist_V = list(dist)
    #if there are changes, then there is negative cycle
    if dist_V_minus1 == dist_V:
        return 0
    else:
        return 1

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(zip(data[0:(3 * m):3], data[1:(3 * m):3]), data[2:(3 * m):3]))
    data = data[3 * m:]
    adj = [[] for _ in range(n)]
    cost = [[] for _ in range(n)]
    for ((a, b), w) in edges:
        adj[a - 1].append(b - 1)
        cost[a - 1].append(w)
    print(negative_cycle(adj, cost))
