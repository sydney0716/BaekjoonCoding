import math

input_arr = input().split()
input_a = int(input_arr[0])
input_b = int(input_arr[1])
input_v = int(input_arr[2])

dif_by_day = input_a - input_b
output = 1

if input_v > input_a:
    output += math.ceil((input_v - input_a) / dif_by_day)


print(output)