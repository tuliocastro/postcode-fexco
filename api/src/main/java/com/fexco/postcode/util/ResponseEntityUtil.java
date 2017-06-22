package com.fexco.postcode.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class ResponseEntityUtil {

    public static ResponseEntity<String> doGET(String url, Map<String, String> params) {

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        params.forEach((key, value) -> uriBuilder.queryParam(key, value));

        URI uri = uriBuilder.build().encode().toUri();

        return restTemplate.getForEntity(uri, String.class);

    }
}
