import sys

lines = sys.stdin.readlines()
n = int(lines[0])

if n % 2 == 0:
	print 0
else:
	n = (n-1) / 2
	result = 1
	for i in xrange(n+1,2*n+1):
		result *= i
	for i in xrange(1,n+1):
		result /= i
	result /= (n+1)
	print result