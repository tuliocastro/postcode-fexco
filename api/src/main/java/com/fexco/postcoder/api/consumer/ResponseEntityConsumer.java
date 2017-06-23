package com.fexco.postcoder.api.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Component
public class ResponseEntityConsumer {

    public ResponseEntity<String> doGET(String url, Map<String, String> params) {

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        params.forEach((key, value) -> uriBuilder.queryParam(key, value));

        URI uri = uriBuilder.build().encode().toUri();

        return restTemplate.getForEntity(uri, String.class);

    }
}
