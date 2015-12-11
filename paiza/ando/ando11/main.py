import sys

N = int(raw_input())
image = []
for i in xrange(N):
	row = []
	line = raw_input()
	tokens = line.split()
	for j in xrange(N):
		row.append(int(tokens[j]))
	image.append(row)

M = int(raw_input())
pattern = []
for i in xrange(M):
	row = []
	line = raw_input()
	tokens = line.split()
	for j in xrange(M):
		row.append(int(tokens[j]))
	pattern.append(row)

for a in xrange(N-M+1):
	for b in xrange(N-M+1):
		found = True
		for i in xrange(M):
			for j in xrange(M):
				if image[a+i][b+j] != pattern[i][j]:					
					found = False
					break
			if not found:
				break			
		if found:
			print a, b
			sys.exit(0)