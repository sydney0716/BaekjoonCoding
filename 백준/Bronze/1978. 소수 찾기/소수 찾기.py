n = int(input())

str_arr = input().split()
int_arr = []
prime_cnt = 0

for i in str_arr:
    if i == '1':
        continue
    isprime = True
    for l in range(2, int(i)):
        if int(i) % l == 0:
            isprime = False
            break
    if isprime:
        prime_cnt += 1
print(prime_cnt)