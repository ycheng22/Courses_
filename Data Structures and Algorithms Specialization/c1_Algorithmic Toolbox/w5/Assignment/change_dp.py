# Uses python3
import sys

def get_change(m):
    denominations = [1, 3, 4]
    min_num_coins = [0] +  [-1] * m
    
    for money in range(1, m+1):
        for coin in denominations:
            if coin <= money:
                num_coin = min_num_coins[money-coin] + 1
                if num_coin < min_num_coins[money] or min_num_coins[money] == -1:
                    min_num_coins[money] = num_coin

    return min_num_coins[m]

if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
