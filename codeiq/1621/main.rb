is_prime = []
100000.times do
	is_prime << true
end
is_prime[0] = false
is_prime[1] = false
k = 2
while k < 100000
	if is_prime[k]
		x = 2*k
		while x < 100000
			is_prime[x] = false
			x += k
		end
	end
	k += 1
end

prime_count = []
100001.times do |i|
	if i == 0
		prime_count[i] = 0
	else		
		prime_count[i] = prime_count[i-1]
		if is_prime[i-1]
			prime_count[i] += 1
		end
	end
end


while str = STDIN.gets
  n = str.to_i
  puts prime_count[n]
end