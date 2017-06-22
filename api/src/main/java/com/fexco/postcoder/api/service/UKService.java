package com.fexco.postcoder.api.service;

import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.util.ResponseEntityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UKService {

    private Logger logger = LoggerFactory.getLogger(UKService.class);

    @Cacheable(value = "uk_address", key = "{#query, #params}")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        logger.info("finding uk address...");

        String endpoint = PostCoderEndpoint.buildEndpoint(apiKey, PostCoderEndpoint.UK.ADDRESS, query);

        ResponseEntity<String> response = ResponseEntityUtil.doGET(endpoint, params);

        return response.getBody();

    }

}
