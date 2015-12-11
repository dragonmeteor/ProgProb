line = raw_input()
tokens = line.split()
L = int(tokens[0])
n = int(tokens[1])
m = int(tokens[2])

def encode(a, b):
	return a*(L+1)+b

nodes = []
edges = {}
for i in xrange(1,n):
	nodes.append(encode(i,0))
	nodes.append(encode(i,L))
	edges[encode(i,0)] = []
	edges[encode(i,L)] = []

for i in xrange(m):
	line = raw_input()
	tokens = line.split()
	a = int(tokens[0])
	b = int(tokens[1])
	c = int(tokens[2])

	nodes.append(encode(a,b))
	nodes.append(encode(a+1,c))
	edges[encode(a,b)] = [encode(a+1,c)]
	edges[encode(a+1,c)] = [encode(a,b)]

nodes.sort()
for i in xrange(len(nodes)):
	node = nodes[i]
	if node % (L+1) > 0:
		edges[node].append(nodes[i-1])

current = encode(1, L)
while current % (L+1) > 0:
	#print (current / (L+1)), (current % (L+1))
	if len(edges[current]) == 1:		
		current = edges[current][0]
	else:
		x = edges[current][0]
		y = edges[current][1]
		if x / (L+1) == current / (L+1):
			current = y
		else:
			current = x	

		x = edges[current][0]
		y = edges[current][1]
		if x / (L+1) == current / (L+1):
			current = x
		else:
			current = y	

print (current / (L+1))