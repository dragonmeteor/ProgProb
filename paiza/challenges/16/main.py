n = int(raw_input())

for i in xrange(n):
	s = raw_input()
	tokens = s.split('.')
	correct = True
	if len(tokens) != 4:
		correct = False
	else:		
		for i in xrange(len(tokens)):
			if len(tokens[i]) == 0:
				correct = False
				break
			num = int(tokens[i])
			if num < 0 or num > 255:
				correct = False
				break
	if correct:
		print "True"
	else:
		print "False"