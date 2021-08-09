#Uses python3
import sys
import math

def distance(v1, v2, x, y):
    return math.sqrt((x[v1]-x[v2])**2 + (y[v1]-y[v2])**2)

def minimum_distance(x, y):
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
            MST.append(edge)
            min_dist += edge[2]
            #set the value at new added vertex equal to its parent
            group = list(map(lambda x: group[edge[0]] if x==group[edge[1]] else x, group))
            
    return min_dist


if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    x = data[1::2]
    y = data[2::2]
    print("{0:.9f}".format(minimum_distance(x, y)))
