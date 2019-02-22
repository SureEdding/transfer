package org.suree.middleware.generator;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SerialNumberGenerator {

    public static String generate(int length) {
        Calendar cal = Calendar.getInstance();
        String strTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(cal.getTime());
        return strTime +
                RandomStringUtils.randomNumeric(length - strTime.length());
    }

}
