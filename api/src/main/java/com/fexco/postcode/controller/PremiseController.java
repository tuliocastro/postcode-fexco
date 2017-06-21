package com.fexco.postcode.controller;

import com.fexco.postcode.service.PremiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class PremiseController {

    @Autowired
    PremiseService premiseService;

    @RequestMapping(value = "{apiKey}/address/uk/{query}")
    public String findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> mapParams) {

        return premiseService.findAdresses(apiKey, query, mapParams);

    }

}
