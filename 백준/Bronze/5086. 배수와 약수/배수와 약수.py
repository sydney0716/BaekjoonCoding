while True:
    input_arr = input().split()
    if input_arr == ['0', '0']:
        break
    input_a = int(input_arr[0])
    input_b = int(input_arr[1])

    if input_a % input_b == 0:
        print("multiple")
    elif input_b % input_a == 0:
        print("factor")
    else:
        print("neither")