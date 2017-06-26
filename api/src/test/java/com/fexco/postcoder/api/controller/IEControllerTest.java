package com.fexco.postcoder.api.controller;

import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.service.IEService;
import com.fexco.postcoder.api.util.HttpUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = IEController.class, secure = false)
public class IEControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEService ieService;

    private String API_KEY_MOCK = "PCW45-12345-12345-1234X";

    private String QUERY_MOCK = "dublin";

    private String LATITUDE_MOCK = "53.332067";

    private String LONGITUDE_MOCK = "-6.255492";

    @Before
    public void mockServices() {

        when(ieService.findAdresses(anyString(), anyString(), anyMap())).thenReturn("ok");
        when(ieService.findAdressGeo(anyString(), anyString(), anyMap())).thenReturn("ok");
        when(ieService.findPosition(anyString(), anyString(), anyMap())).thenReturn("ok");
        when(ieService.findRGeo(anyString(), anyString(), anyString(), anyMap())).thenReturn("ok");

    }


    @Test
    public void testFindAddress() throws Exception {

        testSuccess(HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.ADDRESS, QUERY_MOCK));

        testNotFound("this method shouldn't be found without apikey", HttpUtil.toAbstractURL(PostCoderEndpoint.IE.ADDRESS, QUERY_MOCK));

        testNotFound("this method shouldn't be found without query", HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.ADDRESS));

    }


    @Test
    public void testFindAddressGEO() throws Exception {

        testSuccess(HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.ADDRESSGEO, QUERY_MOCK));

        testNotFound("this method shouldn't be found without apikey", HttpUtil.toAbstractURL(PostCoderEndpoint.IE.ADDRESSGEO, QUERY_MOCK));

        testNotFound("this method shouldn't be found without query", HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.ADDRESSGEO));

    }


    @Test
    public void testFindAddressPosition() throws Exception {

        testSuccess(HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.POSITION, QUERY_MOCK));

        testNotFound("this method shouldn't be found without apikey", HttpUtil.toAbstractURL(PostCoderEndpoint.IE.POSITION, QUERY_MOCK));

        testNotFound("this method shouldn't be found without query", HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.POSITION));
    }

    @Test
    public void testFindAddressRGEO() throws Exception {

        testSuccess(HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.RGEO, LATITUDE_MOCK, LONGITUDE_MOCK, ""));

        testNotFound("this method shouldn't be found without apikey ", HttpUtil.toAbstractURL(PostCoderEndpoint.IE.RGEO, LATITUDE_MOCK, LONGITUDE_MOCK));

        testNotFound("this method shouldn't be found without latitude and longitude", HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.RGEO));

        testNotFound("this method shouldn't be found without latitude", HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.RGEO, LATITUDE_MOCK));

        testNotFound("this method shouldn't be found without longitude", HttpUtil.toAbstractURL(API_KEY_MOCK, PostCoderEndpoint.IE.RGEO, LONGITUDE_MOCK));


    }

    private void testSuccess(String url) throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("ok", result.getResponse().getContentAsString());
    }


    private void testNotFound(String assertMessage, String url) throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        int statusResponse = result.getResponse().getStatus();

        assertEquals(assertMessage, HttpStatus.NOT_FOUND.value(), statusResponse);
    }

}
