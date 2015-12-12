lines = STDIN.readlines
tokens = lines[0].split(',')
total = tokens[0].to_i
progress = tokens[1].to_i
mark = tokens[2].strip
if progress > total
	puts "invalid"
else
	percent = (progress * 100.0 / total).floor	
	percent.times do
		STDOUT.write(mark)
	end	
end