n = 12

top = [0 for i in xrange(n+1)]
top[0] = 1
for i in xrange(1, n+1):
	top[i] = 4 * top[i-1]
	if i-2 >= 0:
		top[i] += top[i-2]

bottom = [0 for i in xrange(n+1)]
bottom[0] = 1
for i in xrange(1, n+1):
	bottom[i] = 2 * bottom[i-1]
	if i-2 >= 0:
		bottom[i] += bottom[i-2]

both = [0 for i in xrange(n+1)]
both[0] = 1
for i in xrange(1, n+1):	
	for j in xrange(0,i+1):
		l = i-j
		if j > 0:
			both[i] += top[l]*bottom[l]*both[j-1]
		else:
			both[i] += top[l]*bottom[l]

print both[n]