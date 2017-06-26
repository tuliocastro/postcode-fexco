package com.fexco.postcoder.api.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HttpUtil {

    private static final String PATH_SEPARATOR = "/";

    /**
     * Transform a string array into a valid url path
     *
     * @param parts
     * @return
     */
    public static String toURL(String... parts) {

        if (parts == null) {
            return null;
        }

        return Arrays.stream(parts)
                .map(part -> part == null ? part = "" : part)
                .collect(Collectors.joining(PATH_SEPARATOR));

    }

    /**
     * Transform a string array into an abstract url (it means that starts with slash: "/" )
     *
     * @param parts
     * @return
     */
    public static String toAbstractURL(String... parts) {

        if (parts == null) {
            return null;
        }

        String firstPart = parts[0];

        if (!firstPart.startsWith("http://") && !firstPart.startsWith("https://")) {
            parts[0] = PATH_SEPARATOR + firstPart;
        }

        return toURL(parts);

    }

}
