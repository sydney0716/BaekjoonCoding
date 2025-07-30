T = int(input())

for i in range(T):
    C = int(input())
    coins = [25, 10, 5, 1]

    for index, coin in enumerate(coins):
        change = C // coin
        C %= coin
        print(change, end= " ")
    print()