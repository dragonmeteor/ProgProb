line = raw_input()
tokens = line.split()
N = int(tokens[0])
M = int(tokens[1])

total = 0
for i in xrange(M):
	event = 0
	line = raw_input().strip()
	tokens = line.split()
	for j in xrange(N):
		event += int(tokens[j])
	if event > 0:
		total += event

print total