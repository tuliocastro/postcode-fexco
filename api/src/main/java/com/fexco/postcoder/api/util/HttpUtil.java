package com.fexco.postcoder.api.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HttpUtil {

    private static final String PATH_SEPARATOR = "/";

    public static String toURL(String... parts) {

        if (parts == null) {
            return null;
        }

        return Arrays.stream(parts)
                .map(part -> part == null ? part = "" : part)
                .collect(Collectors.joining(PATH_SEPARATOR));

//        return String.join(PATH_SEPARATOR, parts);

    }

    public static String toAbstractURL(String... parts) {

        if (parts == null) {
            return null;
        }

        String firstPart = parts[0];

        if (!firstPart.startsWith("http://") && !firstPart.startsWith("https://")) {
            parts[0] = PATH_SEPARATOR + firstPart;
        }

//        String lastPart = parts[parts.length - 1];
//        if (!lastPart.endsWith(PATH_SEPARATOR)) {
//            parts[parts.length - 1] = lastPart + PATH_SEPARATOR;
//        }

        return toURL(parts);

    }

}
