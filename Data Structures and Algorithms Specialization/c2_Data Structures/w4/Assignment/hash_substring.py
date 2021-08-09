# python3
import random

def read_input():
    return (input().rstrip(), input().rstrip())

def print_occurrences(output):
    print(' '.join(map(str, output)))

def poly_hash(s, prime, x):
    ans = 0
    for c in reversed(s):
        ans = (ans * x + ord(c)) % prime
    return ans

def precompute_hashes(text, len_pattern, prime, x):
    H = [0] * (len(text) - len_pattern + 1)
    s = text[-len_pattern:]
    H[len(text) - len_pattern] = poly_hash(s, prime, x)
    y = 1
    for i in range(1, len_pattern+1):
        y = (y * x) % prime
    for i in range(len(text) - len_pattern -1, -1, -1):
        pre_hash = x * H[i+1] + ord(text[i]) - y * ord(text[i + len_pattern])
        while pre_hash < 0:
            pre_hash += prime
        H[i] = pre_hash % prime
    return H

def get_occurrences(pattern, text):
    prime = 1000000007
    x = random.randint(1, prime)
    len_pattern = len(pattern)
    phash = poly_hash(pattern, prime, x)
    H = precompute_hashes(text, len_pattern, prime, x)
    
    return [
        i 
        for i in range(len(text) - len(pattern) + 1) 
        if phash == H[i] and text[i:i+len_pattern] == pattern
    ]

if __name__ == '__main__':
    print_occurrences(get_occurrences(*read_input()))

