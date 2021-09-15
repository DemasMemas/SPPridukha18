import math


def doMult(first, second):
    print('Ответ: ' + str(int((10 ** (math.log10(first) + math.log10(second))))))


if __name__ == '__main__':
    inp = input().split('*')
    x1 = int(inp[0])
    x2 = int(inp[1])
    doMult(x1, x2)
