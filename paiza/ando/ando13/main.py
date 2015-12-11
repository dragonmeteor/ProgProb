# coding: utf-8
# 自分の得意な言語で
# Let's チャレンジ！！
n = int(raw_input())

fives = 0
for i in xrange(1,n+1):
	k = i
	while k % 5 == 0:
		fives += 1
		k /= 5

twos = fives
prod = 1
for i in xrange(1,n+1):
	k = i
	while (k % 5 == 0) and (fives > 0) :
		fives -= 1
		k = k / 5
	while (k % 2 == 0) and (twos > 0):
		twos -= 1
		k = k / 2
	prod = (prod * k) % 1000000000

print prod