package com.fexco.postcode.dto.request;

/**
 * É uma boa pratica colocar a requisicao em objetos pois dessa forma podemos tratar os campos pelo tipo,
 * aplicar Regras de negocios especificas e/ou colocar valores padrões para os campos.
 */
public class PremiseRequest {

    public Integer lines;

    public String include;

    public String exclude;

    public String format = "json";

    public String addtags;

    public String identifier;

    public String callback;

    public Integer page = 0;

    public Boolean postcodeonly;

    public Boolean alias;

}
