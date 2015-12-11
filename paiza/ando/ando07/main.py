# coding: utf-8
# 自分の得意な言語で
# Let's チャレンジ！！
line = raw_input()
tokens = line.split()
c_1 = int(tokens[0])
p_1 = int(tokens[1])

line = raw_input()
tokens = line.split()
c_2 = int(tokens[0])
p_2 = int(tokens[1])

if c_1*p_2 > c_2*p_1:
	print 1
else:
	print 2
