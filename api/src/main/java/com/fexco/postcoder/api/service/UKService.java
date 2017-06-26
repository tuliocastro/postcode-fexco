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

/**
 * UK Service responsible to cache repeated requests (Ignoring api key) and consumes 3rd api when it's not cached.
 */
@Service
public class UKService {

    private Logger logger = LoggerFactory.getLogger(UKService.class);

    @Autowired
    private ResponseEntityConsumer responseEntityConsumer;

    /**
     * Returns full UK addresses for a postcode
     *
     * @param apiKey
     * @param query
     * @param params
     * @return
     */
    @Cacheable(value = PostCoderCache.UK.ADDRESS, key = "{#query, #params}")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        logger.info("finding uk address...");

        String endpoint = HttpUtil.toURL(PostCoderEndpoint.BASE, apiKey, PostCoderEndpoint.UK.ADDRESS, query);

        ResponseEntity<String> response = responseEntityConsumer.doGET(endpoint, params);

        return response.getBody();

    }

}
