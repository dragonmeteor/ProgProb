# coding: utf-8
# 自分の得意な言語で
# Let's チャレンジ！！
n = int(raw_input())
words = []
for i in xrange(n):
	words.append(raw_input().strip())
print "_".join(words)