package com.fexco.postcoder.api.controller;

import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.service.UKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UKController {

    @Autowired
    UKService ukService;

    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.UK.ADDRESS + "/{query}")
    public String findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> mapParams) {

        return ukService.findAdresses(apiKey, query, mapParams);

    }

}