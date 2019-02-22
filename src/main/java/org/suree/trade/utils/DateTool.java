package org.suree.trade.utils;

public class DateTool {

    /**
     * 返回当前时间的秒数
     * @return
     */
    public static int unixTime() {
        return (int)(System.currentTimeMillis() / 1000);
    }
}
