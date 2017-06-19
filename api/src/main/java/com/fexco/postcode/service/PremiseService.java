package com.fexco.postcode.service;

import com.fexco.postcode.constant.PostCoderEndpoint;
import com.fexco.postcode.dto.request.PremiseRequest;
import com.fexco.postcode.dto.response.PremiseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PremiseService {

    private Logger logger = LoggerFactory.getLogger(PremiseService.class);

    //TODO Try catch
    //TODO Test cache
    //TODO Melhorar a recuperacao de URL
    @Cacheable("uk_address")
    public PremiseResponse[] findAdresses(String apiKey, String query, PremiseRequest premiseRequest) {

        logger.debug("Finding address...");

        RestTemplate restTemplate = new RestTemplate();

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.UK.ADDRESS + query;

        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, premiseRequest);

        return response;
    }

}
