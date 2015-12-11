line = raw_input()
tokens = line.split()
n = int(tokens[0])
m = int(tokens[1])

page = (m-1) / (2*n)
index = (m-1) % (2*n)
print page*(2*n) + 2*n - index