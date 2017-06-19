package com.fexco.postcode.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fexco.postcode.base.controller.BaseController;
import com.fexco.postcode.dto.request.PremiseRequest;
import com.fexco.postcode.dto.response.PremiseResponse;
import com.fexco.postcode.service.PremiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PremiseController extends BaseController {

    @Autowired
    PremiseService premiseService;

    //TODO Change this request mapping route
    @RequestMapping(value = "{apiKey}/address/uk/{query}")
    public PremiseResponse[] findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> mapParams) {

        ObjectMapper mapper = new ObjectMapper();
        PremiseRequest configuration = mapper.convertValue(mapParams, PremiseRequest.class);

        return premiseService.findAdresses(apiKey, query, configuration);

    }

}
