package com.fexco.postcoder.api.controller;

import com.fexco.postcoder.api.constant.PostCoderEndpoint;
import com.fexco.postcoder.api.service.IEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Irish Rest Controller
 */
@RestController
@CrossOrigin(origins = "*")
public class IEController {

    @Autowired
    IEService eircodeService;

    /**
     * Irish address lookup -
     * Perform an address lookup using an Eircode or address fragment
     * <p>
     * Lookup: /api/address/ie/query?params
     *
     * @param apiKey
     * @param query
     * @param params
     * @return
     */
    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.ADDRESS + "/{query}")
    public String findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findAdresses(apiKey, query, params);

    }

    /**
     * Irish address and coordinate lookup -
     * Perform an address and coordinate lookup using an Eircode or address fragment
     * <p>
     * Lookup: /api/addressgeo/ie/query?params
     *
     * @param apiKey
     * @param query
     * @param params
     * @return
     */
    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.ADDRESSGEO + "/{query}")
    public String findAddressGeo(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findAdressGeo(apiKey, query, params);

    }

    /**
     * Coordinate lookup - Perform a coordinate lookup using an Eircode
     * <p>
     * Lookup: /api/position/ie/query?params
     *
     * @param apiKey
     * @param query
     * @param params
     * @return
     */
    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.POSITION + "/{query}")
    public String findPosition(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> params) {

        return eircodeService.findPosition(apiKey, query, params);

    }

    /**
     * Reverse geocode coordinates to an Irish address -
     * Return an address from its latitude and longitude
     * <p>
     * Lookup: /api/rgeo/ie/latitude/longitude?params
     *
     * @param apiKey
     * @param latitude
     * @param longitude
     * @param params
     * @return
     */
    @GetMapping(value = "{apiKey}/" + PostCoderEndpoint.IE.RGEO + "/{latitude:.+}/{longitude:.+}")
    public String findReverseGeo(@PathVariable String apiKey, @PathVariable String latitude, @PathVariable String longitude, @RequestParam Map<String, String> params) {

        return eircodeService.findRGeo(apiKey, latitude, longitude, params);

    }


}
