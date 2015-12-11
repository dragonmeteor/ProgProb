import sys

class TheNum:
	def __init__(self, a0, a2, a3, a5):
		self.coeffs = {}
		
		self.coeffs[0] = a0

		self.coeffs[1] = a2
		self.coeffs[10] = a3
		self.coeffs[100] = a5

		self.coeffs[11] = 0
		self.coeffs[101] = 0
		self.coeffs[110] = 0

		self.coeffs[111] = 0

	def __mul__(self, other):
		result = TheNum(0,0,0,0)

		for a in self.coeffs.items():
			for b in other.coeffs.items():
				flag = a[0] + b[0]
				value = (a[1]*b[1]) % (10**7)
				if flag / 100 == 2:
					value = (value * 5) % (10**7)
					flag -= 200
				if (flag % 100) / 10 == 2:
					value = (value * 3) % (10**7)
					flag -= 20
				if (flag % 10) == 2:
					value = (value * 2) % (10**7)
					flag -= 2
				result.coeffs[flag] = (result.coeffs[flag] + value) % (10**7)

		return result

def pow(A, n):
	if n == 1:
		return A
	elif n == 0:
		return TheNum(1,0,0,0)
	elif n % 2 == 0:
		B = pow(A, n/2)
		return B*B
	else:
		B = pow(A, n/2)
		C = B*B
		return C*A

lines = sys.stdin.readlines()
n = int(lines[0])
B = pow(TheNum(1,1,1,1), n)
print B.coeffs[0]