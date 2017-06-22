package com.fexco.postcode.service;

import com.fexco.postcode.constant.PostCoderEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UKService {

    private Logger logger = LoggerFactory.getLogger(UKService.class);

    //TODO Try catch
    //TODO Test cache
    //TODO Melhorar a recuperacao de URL
    @Cacheable(value = "uk_address", key = "{#query, #params}")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.UK.ADDRESS + query;

//        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, params);

        String response = new Date().toString();

        return response;
    }

}
