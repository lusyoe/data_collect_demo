package com.infosys.datacollect.utils;

public final class CommonUtils {

    private CommonUtils() {
    }

    public static boolean isEmpty(Object o) {
        return o == null || "".equals(o) || "".equals(o.toString().trim());
    }

}
