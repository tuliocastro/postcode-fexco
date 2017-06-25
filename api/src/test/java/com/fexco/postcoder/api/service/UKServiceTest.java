package com.fexco.postcoder.api.service;


import com.fexco.postcoder.api.constant.PostCoderCache;
import com.fexco.postcoder.api.consumer.ResponseEntityConsumer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UKService.class, secure = false)
public class UKServiceTest extends BaseServiceTest {

    @MockBean
    ResponseEntityConsumer responseEntityConsumer;

    @Autowired
    private UKService ukService;


    @Before
    public void mockDependencies() {

        ResponseEntity<String> responseMock = Mockito.mock(ResponseEntity.class);

        when(responseMock.getBody()).thenReturn("ok");

        when(responseEntityConsumer.doGET(anyString(), anyMapOf(String.class, String.class))).thenReturn(responseMock);

    }

    @Test
    public void testFindAddress() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("distance", "50");

        String response = ukService.findAdresses(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(response, "ok");

        String secondResponse = ukService.findAdresses(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(secondResponse, "ok");

        int cacheSize = getCache(PostCoderCache.UK.ADDRESS).size();

        assertTrue("Cache wasn't changed", cacheSize > 0);

        params.put("distance", "100");

        String thirdResponse = ukService.findAdresses(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(thirdResponse, "ok");

        int newCacheSize = getCache(PostCoderCache.UK.ADDRESS).size();

        assertTrue("Cache size should have changed from the last call", cacheSize != newCacheSize);

    }

}