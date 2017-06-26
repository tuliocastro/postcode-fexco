package com.fexco.postcoder.api.service;

import com.fexco.postcoder.api.constant.PostCoderCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseServiceTest {

    protected String API_KEY_MOCK = "PCW45-12345-12345-1234X";

    protected String QUERY_MOCK = "dublin";

    protected String LATITUDE_MOCK = "53.332067";

    protected String LONGITUDE_MOCK = "-6.255492";

    @Autowired
    protected CacheManager cacheManager;

    public ConcurrentHashMap getCache(String key) {

        return ((ConcurrentHashMap) cacheManager.getCache(key).getNativeCache());

    }


    @Configuration
    @EnableCaching
    public static class TestConfiguration {

        @Bean
        public SimpleCacheManager cacheManager() {
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            List<Cache> caches = new ArrayList<Cache>();
            caches.add(cacheBeanUKAddress().getObject());
            caches.add(cacheBeanIEAddress().getObject());
            caches.add(cacheBeanIEPosition().getObject());
            caches.add(cacheBeanIERGeo().getObject());
            caches.add(cacheBeanIEAddressGeo().getObject());
            cacheManager.setCaches(caches);
            return cacheManager;
        }

        @Bean
        public ConcurrentMapCacheFactoryBean cacheBeanUKAddress() {
            ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
            cacheFactoryBean.setName(PostCoderCache.UK.ADDRESS);
            return cacheFactoryBean;
        }

        @Bean
        public ConcurrentMapCacheFactoryBean cacheBeanIEAddress() {
            ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
            cacheFactoryBean.setName(PostCoderCache.IE.ADDRESS);
            return cacheFactoryBean;
        }


        @Bean
        public ConcurrentMapCacheFactoryBean cacheBeanIEAddressGeo() {
            ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
            cacheFactoryBean.setName(PostCoderCache.IE.ADDRESS_GEO);
            return cacheFactoryBean;
        }

        @Bean
        public ConcurrentMapCacheFactoryBean cacheBeanIEPosition() {
            ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
            cacheFactoryBean.setName(PostCoderCache.IE.POSITION);
            return cacheFactoryBean;
        }

        @Bean
        public ConcurrentMapCacheFactoryBean cacheBeanIERGeo() {
            ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
            cacheFactoryBean.setName(PostCoderCache.IE.RGEO);
            return cacheFactoryBean;
        }

    }
}
