input_arr = input().split()
input_n = int(input_arr[0])
input_b = int(input_arr[1])

char_list = []
while input_n != 0:
    remainder = input_n % input_b
    input_n //= input_b
    if remainder > 9:
        char_list.append(chr(remainder+55))
    else:
        char_list.append(str(remainder))
char_list = char_list[::-1]
output = "".join(char_list)
print(output)