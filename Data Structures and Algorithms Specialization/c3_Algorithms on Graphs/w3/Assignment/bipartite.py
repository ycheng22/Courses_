# =============================================================================
# #Uses python3
# 
# import sys
# import queue
# 
# def bipartite(adj):
#     """
#     at each layer, mark node as 1
#     next layers, mark node as 2
#     if biparties, marker of two connected nodes should be different
#     """
#     marker = [0] * len(adj)
#     q = queue.Queue()
#     #mark 1st vertex as 1, add to queue
#     marker[0] = 1
#     q.put(0)
#     while not q.empty():
#         u = q.get()
#         for v in adj[u]:
#             if marker[v] == marker[u]:
#                 return 0
#             elif marker[v] == 0:
#                 q.put(v)
#                 if marker[u] == 1:
#                     marker[v] = 2
#                 else:
#                     marker[v] = 1
#     return 1
#     
# 
# if __name__ == '__main__':
#     input = sys.stdin.read()
#     data = list(map(int, input.split()))
#     n, m = data[0:2]
#     data = data[2:]
#     edges = list(zip(data[0:(2 * m):2], data[1:(2 * m):2]))
#     adj = [[] for _ in range(n)]
#     for (a, b) in edges:
#         adj[a - 1].append(b - 1)
#         adj[b - 1].append(a - 1)
#     print(bipartite(adj))
# 
# =============================================================================
import sys
import queue

def bipartite(adj):
    '''perform breadth first search.initialize to zeros to inidicate undiscovered. At each level, tag each discovered element 
    with alternating tag of one or two to mark the two regions, if It's biparite,  we shouldn't see connected nodes of the 
    same tag as the source'''

    q = queue.Queue()    #to process from one point and outerwards from that point
    #initialize all vertices to zero (undiscovered)
    tag = len(adj) * [0]
    #initialize first vertex with tag 1 and add to Queue
    tag[0] = 1
    q.put(0)
    while not q.empty():
        u = q.get()
        for i in adj[u]:    #process all immediate neighbors
            #check if tag is the same as u, if it is, the graph is not bipartite
            if tag[i] == tag[u]:
                return 0  #tag is not bipartite since tag(u) = tag(i)
            elif tag[i] == 0:
                q.put(i)  #if undiscovered, add to queue for processing and give it a tag of alternating number
                if tag[u] == 1:
                    tag[i] = 2
                else:
                    tag[i] = 1

    return 1

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(data[0:(2 * m):2], data[1:(2 * m):2]))
    adj = [[] for _ in range(n)]
    for (a, b) in edges:
        adj[a - 1].append(b - 1)
        adj[b - 1].append(a - 1)
    print(bipartite(adj))