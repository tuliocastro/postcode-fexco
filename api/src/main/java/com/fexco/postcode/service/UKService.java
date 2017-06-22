package com.fexco.postcode.service;

import com.fexco.postcode.constant.PostCoderEndpoint;
import com.fexco.postcode.util.ResponseEntityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
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
