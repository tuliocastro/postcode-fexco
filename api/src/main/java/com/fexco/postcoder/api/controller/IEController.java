package com.fexco.postcoder.api.controller;

import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.service.IEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class IEController {

    @Autowired
    IEService eircodeService;

    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.ADDRESS + "/{query}")
    public String findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findAdresses(apiKey, query, params);

    }

    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.ADDRESSGEO + "/{query}")
    public String findAddressGeo(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findAdressGeo(apiKey, query, params);

    }

    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.POSITION + "/{query}")
    public String findPosition(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findPosition(apiKey, query, params);

    }

    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.RGEO + "/{latitude:.+}/{longitude:.+}")
    public String findReverseGeo(@PathVariable String apiKey, @PathVariable String latitude, @PathVariable String longitude, @RequestParam Map<String, String> params) {

        return eircodeService.findRGeo(apiKey, latitude, longitude, params);

    }


}
