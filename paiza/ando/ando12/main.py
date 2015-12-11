line = raw_input()
tokens = line.split()
X = int(tokens[0])
Y = int(tokens[1])
Z = int(tokens[2])
N = int(tokens[3])

xx = [0, X]
yy = [0, Y]
for i in xrange(N):
	line = raw_input()
	tokens = line.split()
	d = int(tokens[0])
	a = int(tokens[1])
	if d == 0:
		xx.append(a)
	else:
		yy.append(a)

xx.sort()
yy.sort()

dx = []
for i in xrange(len(xx)-1):
	dx.append(xx[i+1]-xx[i])
dy = []
for i in xrange(len(yy)-1):
	dy.append(yy[i+1]-yy[i])

min_area = 2000*2000
for i in xrange(len(dx)):
	for j in xrange(len(dy)):
		if dx[i]*dy[j] < min_area:
			min_area = dx[i]*dy[j]

print min_area * Z