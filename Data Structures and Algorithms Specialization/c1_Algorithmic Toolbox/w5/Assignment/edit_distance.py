# Uses python3
import numpy as np
def edit_distance(s, t):
    len1 = len(s)
    len2 = len(t)
    D = np.zeros((len1+1, len2+1))
    
    for i in range(len1+1):
        D[i,0] = i
    for j in range(len2+1):
        D[0,j] = j
        
    for i in range(1, len1+1):
        for j in range(1, len2+1):
            insertion = D[i,j-1] + 1
            deletion = D[i-1,j] + 1
            match = D[i-1,j-1]
            mismatch = D[i-1,j-1] + 1
            if s[i-1] == t[j-1]: #D's 0th row,column is mismatch, string has element form 0th index
                D[i,j]=min(insertion, deletion, match)
            else:
                D[i,j]=min(insertion, deletion, mismatch)

    return int(D[len1,len2])

if __name__ == "__main__":
    print(edit_distance(input(), input()))
