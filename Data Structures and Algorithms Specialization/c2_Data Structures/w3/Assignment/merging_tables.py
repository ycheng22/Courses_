# python3

class DisjointSet:
    def __init__(self, n, lines):
        """
        n: num of tables
        lines: rows for each table
        """
        self.n = n
        self.lines = [0] + lines #注意这里的+0
        self.rank = [0] * (n+1)
        self.parent = list(range(n+1))
        self.max= max(self.lines)
        
    def get_parent(self, x):
        """
        Finds a set id (root of the tree) for element x and compresses path
        """
        parent_path = []
        
        #Find root
        root = x
        while root != self.parent[root]: #refer to Find(x) from lecture "Path Compression"
            parent_path.append(self.parent[root])
            root = self.parent[root] #eventually, find x's root
        for i in parent_path:
            self.parent[i] = root
            
        return root
    
    def merge(self, dest, src):
        """
        Union tables, use union by rank heuristic
        """
        dest_root = self.get_parent(dest)
        src_root = self.get_parent(src)
        
        #if the two tables haven been merged
        if dest_root == src_root:
            return
        if self.rank[src_root] >= self.rank[dest_root]: #????????????
            self.parent[src_root] = dest_root
        else:
            self.parent[dest_root] = src_root
            if self.rank[src_root] == self.rank[dest_root]:
                self.rank[src_root] += 1
                
        self.lines[dest_root] += self.lines[src_root] #copy rows from src to dest, so ...
        self.lines[src_root] = 0 #now src only has symbolic link, size is 0
        
        if self.max < self.lines[dest_root]:
            self.max = self.lines[dest_root]
                
    def get_max_lines(self):
        return self.max
        
        

def main():
    n_tables, n_queries = map(int, input().split())
    counts = list(map(int, input().split()))
    assert len(counts) == n_tables
    
    ds = DisjointSet(n_tables, counts)
    for i in range(n_queries):
        dst, src = map(int, input().split())
        ds.merge(dst, src)
        print(ds.get_max_lines())


if __name__ == "__main__":
    main()
