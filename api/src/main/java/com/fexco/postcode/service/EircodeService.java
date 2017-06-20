package com.fexco.postcode.service;

import com.fexco.postcode.constant.PostCoderEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

@Service
public class EircodeService {

    private Logger logger = LoggerFactory.getLogger(EircodeService.class);

    //TODO Try catch
    //TODO Test cache
    //TODO Melhorar a recuperacao de URL
    @Cacheable("ie_address")
    public String findAdresses(String apiKey, String query, Map<String, String> params) {

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.IE.ADDRESS + query;

//        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, premiseRequest);

        String response = new Date().toString();

        return response;
    }

    @Cacheable("ie_addressgeo")
    public String findAdressGeo(String apiKey, String query, Map<String, String> params) {

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.IE.ADDRESSGEO + query;

//        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, premiseRequest);

        String response = new Date().toString();

        return response;
    }


    @Cacheable("ie_position")
    public String findPosition(String apiKey, String query, Map<String, String> params) {

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.IE.POSITION + query;

//        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, premiseRequest);

        String response = new Date().toString();

        return response;
    }

    @Cacheable("ie_rgeo")
    public String findRGeo(String apiKey, String latitude, String longitude, Map<String, String> params) {

        String url = PostCoderEndpoint.BASE + apiKey + PostCoderEndpoint.IE.RGEO + "/" + latitude + "/" + longitude;

//        PremiseResponse[] response = restTemplate.getForObject(url, PremiseResponse[].class, premiseRequest);

        String response = "[{\"addressline1\":\"Irish Pension Trust\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Irish Pension Trust, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Irish Pension Trust\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Marsh Ireland Limited\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Marsh Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Marsh Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Marsh Insurance\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Marsh Insurance, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Marsh Insurance\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Bowring Marsh\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Bowring Marsh, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Bowring Marsh\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Loan Star\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Loan Star, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Loan Star\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Ffh Management Services Limited\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Ffh Management Services Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Ffh Management Services Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Hudson Advisors Ireland Limited\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Hudson Advisors Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Hudson Advisors Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Mercer Global Investments\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Mercer Global Investments, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Mercer Global Investments\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Brown Brothers Harriman Trustee Services Ireland Limited\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Brown Brothers Harriman Trustee Services Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Brown Brothers Harriman Trustee Services Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Extrion Media\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Extrion Media, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Extrion Media\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Mfxchange Ireland Limited\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Mfxchange Ireland Limited, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Mfxchange Ireland Limited\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Lone Star International\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Lone Star International, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Lone Star International\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"Marsh Financial Services\",\"addressline2\":\"25-28 Marsh House\",\"addressline3\":\"Adelaide Road\",\"summaryline\":\"Marsh Financial Services, 25-28 Marsh House, Adelaide Road, Dublin 2, D02 RY98\",\"organisation\":\"Marsh Financial Services\",\"buildingname\":\"Marsh House\",\"number\":\"25-28\",\"premise\":\"Marsh House, 25-28\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 RY98\"},{\"addressline1\":\"37 Symphony House\",\"addressline2\":\"Adelaide Road\",\"summaryline\":\"37 Symphony House, Adelaide Road, Dublin 2, D02 EW71\",\"buildinggroupname\":\"Symphony House\",\"number\":\"37\",\"premise\":\"37, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 EW71\"},{\"addressline1\":\"38 Symphony House\",\"addressline2\":\"Adelaide Road\",\"summaryline\":\"38 Symphony House, Adelaide Road, Dublin 2, D02 H327\",\"buildinggroupname\":\"Symphony House\",\"number\":\"38\",\"premise\":\"38, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 H327\"},{\"addressline1\":\"39 Symphony House\",\"addressline2\":\"Adelaide Road\",\"summaryline\":\"39 Symphony House, Adelaide Road, Dublin 2, D02 PH28\",\"buildinggroupname\":\"Symphony House\",\"number\":\"39\",\"premise\":\"39, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 PH28\"},{\"addressline1\":\"36 Symphony House\",\"addressline2\":\"Adelaide Road\",\"summaryline\":\"36 Symphony House, Adelaide Road, Dublin 2, D02 PX29\",\"buildinggroupname\":\"Symphony House\",\"number\":\"36\",\"premise\":\"36, Symphony House\",\"street\":\"Adelaide Road\",\"posttown\":\"Dublin 2\",\"county\":\"Dublin\",\"postcode\":\"D02 PX29\"}]";

        return response;
    }

}
