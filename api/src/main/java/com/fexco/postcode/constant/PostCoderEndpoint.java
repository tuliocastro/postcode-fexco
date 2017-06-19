package com.fexco.postcode.constant;

//TODO Melhorar a classe de endpoint, talvez usar o message Format
public class PostCoderEndpoint {

    public static final String BASE = "http://ws.postcoder.com/pcw/";

    public static class IE {

        public static final String ADDRESS = "/address/ie/";
        public static final String ADDRESSGEO = "/addressgeo/ie/";
        public static final String POSITION = "/position/ie/";
        public static final String RGEO = "/rgeo/ie/";

    }

    public static class UK {

        public static final String ADDRESS = "/address/uk/";
    }

}
