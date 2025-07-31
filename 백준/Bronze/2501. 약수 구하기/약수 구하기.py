input_arr = input().split()
input_n = int(input_arr[0])
input_k = int(input_arr[1])

division_arr = []

for i in range(1, input_n + 1):
    if input_n % i == 0:
        division_arr.append(i)

if len(division_arr) >= input_k:
    print(division_arr[input_k-1])
else:
    print("0")