package com.fexco.postcoder.api.controller;

import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.service.UKService;
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
@WebMvcTest(value = UKController.class, secure = false)
public class UKControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UKService ukService;

    private String apiKeyMocked = "PCW45-12345-12345-1234X";

    private String queryAddressMocked = "dublin";

    @Before
    public void mockServices() {

        when(ukService.findAdresses(anyString(), anyString(), anyMap())).thenReturn("ok");

    }


    @Test
    public void testFindAddress() throws Exception {

        String url = HttpUtil.toAbstractURL(apiKeyMocked, PostCoderEndpoint.UK.ADDRESS, queryAddressMocked);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("ok", result.getResponse().getContentAsString());

    }

    @Test
    public void testFindAddressWithouApiKey() throws Exception {

        String url = HttpUtil.toAbstractURL(PostCoderEndpoint.UK.ADDRESS, queryAddressMocked);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        int statusResponse = result.getResponse().getStatus();

        assertEquals(HttpStatus.NOT_FOUND.value(), statusResponse);

    }

}
