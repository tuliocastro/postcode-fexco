package com.fexco.postcode.controller;

import com.fexco.postcode.base.controller.BaseController;
import com.fexco.postcode.service.PremiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PremiseController extends BaseController {

    @Autowired
    PremiseService premiseService;

    @RequestMapping(value = "{apiKey}/address/uk/{query}")
    public String findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> mapParams) {

        return premiseService.findAdresses(apiKey, query, mapParams);

    }

}
