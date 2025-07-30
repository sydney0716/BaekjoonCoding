def sum_all(input_num):
    return input_num * (input_num + 1) // 2

n = int(input())
count = 0
while n - sum_all(count + 1) > 0:
    count += 1
if count % 2 == 0:
    print(f"{count - n + 2 + sum_all(count)}/{n - sum_all(count)}")
else:
    print(f"{n - sum_all(count)}/{count - n + 2 + sum_all(count)}")