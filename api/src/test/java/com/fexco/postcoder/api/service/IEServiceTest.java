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
@WebMvcTest(value = IEService.class, secure = false)
public class IEServiceTest extends BaseServiceTest {

    @MockBean
    ResponseEntityConsumer responseEntityConsumer;

    @Autowired
    private IEService ieService;


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

        String response = ieService.findAdresses(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(response, "ok");

        String secondResponse = ieService.findAdresses(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(secondResponse, "ok");

        int cacheSize = getCache(PostCoderCache.IE.ADDRESS).size();

        assertTrue("Cache wasn't changed", cacheSize > 0);

        params.put("distance", "100");

        String thirdResponse = ieService.findAdresses(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(thirdResponse, "ok");

        int newCacheSize = getCache(PostCoderCache.IE.ADDRESS).size();

        assertTrue("Cache size should have changed from the last call", cacheSize != newCacheSize);

    }

    @Test
    public void testFindAddressGEO() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("distance", "50");

        String response = ieService.findAdressGeo(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(response, "ok");

        String secondResponse = ieService.findAdressGeo(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(secondResponse, "ok");

        int cacheSize = getCache(PostCoderCache.IE.ADDRESS_GEO).size();

        assertTrue("Cache wasn't changed", cacheSize > 0);

        params.put("distance", "100");

        String thirdResponse = ieService.findAdressGeo(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(thirdResponse, "ok");

        int newCacheSize = getCache(PostCoderCache.IE.ADDRESS_GEO).size();

        assertTrue("Cache size should have changed from the last call", cacheSize != newCacheSize);

    }

    @Test
    public void testFindPosition() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("distance", "50");

        String response = ieService.findPosition(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(response, "ok");

        String secondResponse = ieService.findPosition(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(secondResponse, "ok");

        int cacheSize = getCache(PostCoderCache.IE.POSITION).size();

        assertTrue("Cache wasn't changed", cacheSize > 0);

        params.put("distance", "100");

        String thirdResponse = ieService.findPosition(API_KEY_MOCK, QUERY_MOCK, params);

        assertEquals(thirdResponse, "ok");

        int newCacheSize = getCache(PostCoderCache.IE.POSITION).size();

        assertTrue("Cache size should have changed from the last call", cacheSize != newCacheSize);

    }


    @Test
    public void testFindRGEO() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("distance", "50");

        String response = ieService.findRGeo(API_KEY_MOCK, LATITUDE_MOCK, LONGITUDE_MOCK, params);

        assertEquals(response, "ok");

        String secondResponse = ieService.findRGeo(API_KEY_MOCK, LATITUDE_MOCK, LONGITUDE_MOCK, params);

        assertEquals(secondResponse, "ok");

        int cacheSize = getCache(PostCoderCache.IE.RGEO).size();

        assertTrue("Cache wasn't changed", cacheSize > 0);

        params.put("distance", "100");

        String thirdResponse = ieService.findRGeo(API_KEY_MOCK, LATITUDE_MOCK, LONGITUDE_MOCK, params);

        assertEquals(thirdResponse, "ok");

        int newCacheSize = getCache(PostCoderCache.IE.RGEO).size();

        assertTrue("Cache size should have changed from the last call", cacheSize != newCacheSize);

    }


}