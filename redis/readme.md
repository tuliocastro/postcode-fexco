#create image

	docker build -t postcoder/redis .
	
#run

	docker run --name redisdev -p 6379:6379 postcoder/redis