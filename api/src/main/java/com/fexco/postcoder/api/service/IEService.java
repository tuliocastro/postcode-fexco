package com.fexco.postcoder.api.service;

import com.fexco.postcoder.api.constant.PostCoderCache;
import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.util.HttpUtil;
import com.fexco.postcoder.api.consumer.ResponseEntityConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IEService {

    private Logger logger = LoggerFactory.getLogger(IEService.class);

    @Autowired
    private ResponseEntityConsumer responseEntityConsumer;

    @Cacheable(value = PostCoderCache.IE.ADDRESS, key = "{#query, #params}")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        logger.info("Finding IE addresses ...");

        String endpoint = HttpUtil.toURL(PostCoderEndpoint.BASE, apiKey, PostCoderEndpoint.IE.ADDRESS, query);

        ResponseEntity<String> response = responseEntityConsumer.doGET(endpoint, params);

        return response.getBody();

    }

    @Cacheable(value = PostCoderCache.IE.ADDRESS_GEO, key = "{#query, #params}")
    public String findAdressGeo(String apiKey, String query, Map<String, String> params) {

        logger.info("Finding IE addresses geo ...");

        String endpoint = HttpUtil.toURL(PostCoderEndpoint.BASE, apiKey, PostCoderEndpoint.IE.ADDRESSGEO, query);

        ResponseEntity<String> response = responseEntityConsumer.doGET(endpoint, params);

        return response.getBody();

    }


    @Cacheable(value = PostCoderCache.IE.POSITION, key = "{#query, #params}")
    public String findPosition(String apiKey, String query, Map<String, String> params) {

        logger.info("Finding IE position ...");

        String endpoint = HttpUtil.toURL(PostCoderEndpoint.BASE, apiKey, PostCoderEndpoint.IE.POSITION, query);

        ResponseEntity<String> response = responseEntityConsumer.doGET(endpoint, params);

        return response.getBody();
    }

    @Cacheable(value = PostCoderCache.IE.RGEO, key = "{#query, #params}")
    public String findRGeo(String apiKey, String latitude, String longitude, Map<String, String> params) {

        logger.info("Finding IE reverse geo ...");

        String endpoint = HttpUtil.toURL(PostCoderEndpoint.BASE, apiKey, PostCoderEndpoint.IE.RGEO, latitude, longitude);

        ResponseEntity<String> response = responseEntityConsumer.doGET(endpoint, params);

        return response.getBody();

    }

}
