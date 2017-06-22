package com.fexco.postcode.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PostCoderEndpoint {

    public static final String BASE = "http://ws.postcoder.com/pcw/";

    public static class IE {

        public static final String ADDRESS = "address/ie";
        public static final String ADDRESSGEO = "addressgeo/ie";
        public static final String POSITION = "position/ie";
        public static final String RGEO = "rgeo/ie";

    }

    public static class UK {

        public static final String ADDRESS = "address/uk";
    }

    public static String buildEndpoint(String... parts) {

        return BASE + String.join("/", parts).replace("//", "/");

    }

}
