#create image

	docker build -t postcoder/redis .
	
#run

	docker run --name redis -p 6379:6379 -d tuliocastro/redis