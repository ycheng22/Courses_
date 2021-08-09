#Uses python3

import sys

def explore(v, adj, visited):   
    for w in adj[v]:
        if not visited[w]:
            visited[w] = True
            explore(w, adj, visited)
            
def acyclic(adj):
    result = 0
    for i in range(len(adj)):
        visited = [0]*len(adj)
        explore(i, adj, visited)
        #in explore, only set i-th vertex's descendents to 1
        #if visited[i] = 1, it's a cycle
        if visited[i]: 
            result = 1
            break
    return result

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(data[0:(2 * m):2], data[1:(2 * m):2]))
    adj = [[] for _ in range(n)]
    for (a, b) in edges:
        adj[a - 1].append(b - 1)
    print(acyclic(adj))
