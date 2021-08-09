#Uses python3
import sys
import math

def distance(v1, v2, x, y):
    return math.sqrt((x[v1]-x[v2])**2 + (y[v1]-y[v2])**2)

def clustering(x, y, k):
    
    #create edges
    edges = []
    for i in range(n):
        for j in range(i, n):
            if i != j:
                edges.append([i, j, distance(i, j, x, y)])
    sorted_edges = sorted(edges, key = lambda x: x[2])
    
    #initialize disjoint data structure
    group = range(n)
    #Kruskal's algorithm
    MST = [] #min spanning tree
    min_dist = 0
    for edge in sorted_edges:
        #if the vertices haven't been added
        if group[edge[0]] != group[edge[1]]:
            
            #check if num of partitions equal k, stop 
            #take current edge, which start to connect two clusters 
            #rather than within current cluster
            if len(set(group)) == k:
                next_edge = edge
                break
            
            MST.append(edge)
            min_dist += edge[2]
            #in group, set the value at new added vertex equal to its parent's value
            group = list(map(lambda x: group[edge[0]] if x==group[edge[1]] else x, group))
            
    return next_edge[2]

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    data = data[1:]
    x = data[0:2 * n:2]
    y = data[1:2 * n:2]
    data = data[2 * n:]
    k = data[0]
    print("{0:.9f}".format(clustering(x, y, k)))
