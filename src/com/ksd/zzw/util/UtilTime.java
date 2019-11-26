package com.ksd.zzw.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class UtilTime {
    public static Date FormatTime(String time) {
        String[] t = time.split("T");
        if (t.length < 2) {
            return null;
        }
        if (t[1].length() == 5) {
            t[1] += ":00";
        }
        String str = t[0]+" " + t[1];
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
