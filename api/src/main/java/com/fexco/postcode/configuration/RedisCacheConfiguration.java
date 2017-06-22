package com.fexco.postcode.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport {

    private Logger logger = LoggerFactory.getLogger(RedisCacheConfiguration.class);

    @Value("${cache.redis.hostname}")
    private String hostname;

    @Value("${cache.redis.port}")
    private Integer port;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {

        logger.info("Initializing Redis connection on " + hostname + ":" + port);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(hostname);
        jedisConnectionFactory.setPort(port);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {

        logger.info("Initializing Redis Template ...");

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setExposeConnection(true);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager cacheManager() {

        logger.info("Getting redis cache manager");

        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        redisCacheManager.setTransactionAware(true);
        redisCacheManager.setLoadRemoteCachesOnStartup(true);
        redisCacheManager.setUsePrefix(true);
        return redisCacheManager;
    }
}