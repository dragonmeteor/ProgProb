# coding: utf-8
# 自分の得意な言語で
# Let's チャレンジ！！
yes_count = 0
for i in xrange(5):
	s = raw_input().strip()
	if s == "yes":
		yes_count += 1
if yes_count >= 3:
	print "yes"
else:
	print "no"