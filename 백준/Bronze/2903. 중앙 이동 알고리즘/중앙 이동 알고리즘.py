def calc_point(input_int):
    if input_int == 0:
        return 4
    else:
        return ((2 ** (input_int - 1) + 1) * 2 ** input_int + 4 ** (input_int - 1)) + calc_point(input_int - 1)

N = int(input())

output = calc_point(N)

print(output)