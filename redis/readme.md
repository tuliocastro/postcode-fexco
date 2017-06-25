# FEXCO Postcoder REDIS Cache Module

This module is used to num the memory database REDIS. This prevents access to the 3rd API if the results was alredy used by any API-KEY.


## Frameworks

- Redis
- Docker


## Why Redis was chosen?

In this case, cache has to be used to avoid extra/repeated costs. We expect that API will be called by a multiple services that all together add up one million requests per month. The latency of responses in high concurrency conditions should be as low as possible. And the proposed solution has to involves a long term persistent mechanism, that preloads the in-memory cache on startup.

Redis can be easily integrated as a LRU cache. It is very uncommon to use Redis as a standalone database system (some people prefer referring to it as a "key-value"-store). Websites like Craigslist use Redis next to their primary database. Antirez (developer of Redis) demonstrated using Lamernews that it is indeed possible to use Redis as a stand alone database system. 

Beating the performance Redis provides is nearly impossible. Imagine you database being as fast as your cache. That's what it feels like using Redis as a real database.

## How to Start (For DEV mode)

> You don't need to run the following commands if you are running at docker-compose from the previous readme. [Read-it Here](../#Building-API-Image).

#### Create docker image

	docker build -t postcoder/redis .
	
#### Run Docker image

	docker run --name redisdev -p 6379:6379 postcoder/redis