package com.fexco.postcode.service;

import com.fexco.postcode.constant.PostCoderEndpoint;
import com.fexco.postcode.util.ResponseEntityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class IEService {

    private Logger logger = LoggerFactory.getLogger(IEService.class);

    @Cacheable(value = "ie_address", key = "{#query, #params}")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        logger.info("Finding IE addresses ...");

        String endpoint = PostCoderEndpoint.buildEndpoint(apiKey, PostCoderEndpoint.IE.ADDRESS, query);

        ResponseEntity<String> response = ResponseEntityUtil.doGET(endpoint, params);

        return response.getBody();

    }

    @Cacheable(value = "ie_addressgeo", key = "{#query, #params}")
    public String findAdressGeo(String apiKey, String query, Map<String, String> params) {

        logger.info("Finding IE addresses geo ...");

        String endpoint = PostCoderEndpoint.buildEndpoint(apiKey, PostCoderEndpoint.IE.ADDRESSGEO, query);

        ResponseEntity<String> response = ResponseEntityUtil.doGET(endpoint, params);

        return response.getBody();

    }


    @Cacheable(value = "ie_position", key = "{#query, #params}")
    public String findPosition(String apiKey, String query, Map<String, String> params) {

        logger.info("Finding IE position ...");

        String endpoint = PostCoderEndpoint.buildEndpoint(apiKey, PostCoderEndpoint.IE.POSITION, query);

        ResponseEntity<String> response = ResponseEntityUtil.doGET(endpoint, params);

        return response.getBody();
    }

    @Cacheable(value = "ie_rgeo", key = "{#query, #params}")
    public String findRGeo(String apiKey, String latitude, String longitude, Map<String, String> params) {

        logger.info("Finding IE reverse geo ...");

        String endpoint = PostCoderEndpoint.buildEndpoint(apiKey, PostCoderEndpoint.IE.RGEO, latitude, longitude);

        ResponseEntity<String> response = ResponseEntityUtil.doGET(endpoint, params);

        return response.getBody();

    }

}
