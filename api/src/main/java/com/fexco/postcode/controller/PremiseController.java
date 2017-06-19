package com.fexco.postcode.controller;

import com.fexco.postcode.base.controller.BaseController;
import com.fexco.postcode.dto.response.PremiseResponse;
import com.fexco.postcode.service.PremiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PremiseController extends BaseController {

    @Autowired
    PremiseService premiseService;

    @RequestMapping(value = "{apiKey}/address/uk/{query}", method = RequestMethod.GET)
    public PremiseResponse[] findAddress(@PathVariable String apiKey, @PathVariable String query, @RequestParam Map<String, String> mapParams) {

        return premiseService.findAdresses(apiKey, query, null);

    }

}
