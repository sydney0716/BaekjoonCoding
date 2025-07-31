while True:
    n = int(input())
    if n == -1:
        break

    div_arr = []
    for i in range(1, n):
        if n % i == 0:
            div_arr.append(i)
    if n == sum(div_arr):
        print(f"{n} = 1", end=" ")
        for div in div_arr:
            if div != 1:
                print(f"+ {div}", end=" ")
        print()
    else:
        print(f"{n} is NOT perfect.")