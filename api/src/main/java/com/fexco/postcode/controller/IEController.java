package com.fexco.postcode.controller;

import com.fexco.postcode.service.IEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class IEController {

    @Autowired
    IEService eircodeService;

    @RequestMapping(value = "{apiKey}/address/ie/{query}")
    public String findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findAdresses(apiKey, query, params);

    }

    @RequestMapping(value = "{apiKey}/addressgeo/ie/{query}")
    public String findAddressGeo(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findAdressGeo(apiKey, query, params);

    }


    @RequestMapping(value = "{apiKey}/position/ie/{query}")
    public String findPosition(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findPosition(apiKey, query, params);

    }


    @RequestMapping(value = "{apiKey}/rgeo/ie/{latitude:.+}/{longitude:.+}")
    public String findReverseGeo(@PathVariable String apiKey, @PathVariable String latitude, @PathVariable String longitude, @RequestParam Map<String, String> params) {

        return eircodeService.findRGeo(apiKey, latitude, longitude, params);

    }

}
