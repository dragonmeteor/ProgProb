n = int(raw_input())
for i in xrange(n):
	num = raw_input().strip()
	even = 0
	odd = 0
	for i in xrange(15):		
		if i % 2 == 0:
			k = int(num[i])*2
			if k >= 10:
				k = k%10 + k/10
			even += k
		else:
			odd += int(num[i])				
	print (10 - (even+odd) % 10) % 10