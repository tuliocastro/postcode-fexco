package com.fexco.postcode.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

//@Component
//@Order(10)
public class RedisEmbeddedServer {

    private Logger logger = LoggerFactory.getLogger(RedisEmbeddedServer.class);

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void startServer() throws IOException {

        logger.info("Starting Embedded Server");

        redisServer = new RedisServer(redisPort);

        redisServer.start();
    }

    @PreDestroy
    public void stopServer() {

        logger.info("Stopping embedded server");

        redisServer.stop();
    }

}
