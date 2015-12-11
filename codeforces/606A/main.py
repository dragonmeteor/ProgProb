line = raw_input()
start = [int(s) for s in line.strip().split()]
line = raw_input()
target = [int(s) for s in line.strip().split()]

diff = [start[i] - target[i] for i in xrange(3)]
negCount = 0
for i in xrange(3):
	if diff[i] < 0:
		negCount += 1

if negCount == 3:
	print "No"
elif negCount == 0:
	print "Yes"
elif negCount == 1:
	negIndex = 0
	for i in xrange(3):
		if diff[i] < 0:
			negIndex = i
	canMake = diff[(negIndex+1)%3]/2 + diff[(negIndex+2)%3]/2
	if canMake >= - diff[negIndex]:
		print "Yes"
	else:
		print "No"
else:
	posIndex = 0
	for i in xrange(3):
		if diff[i] >= 0:
			posIndex = i
	demand = -(diff[(posIndex+1)%3] + diff[(posIndex+2)%3])*2
	if diff[posIndex] >= demand:
		print "Yes"
	else:
		print "No"
