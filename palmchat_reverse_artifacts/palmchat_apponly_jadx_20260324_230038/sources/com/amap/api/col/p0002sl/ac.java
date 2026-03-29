package com.amap.api.col.p0002sl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ac {
    public static String a() {
        return a(Calendar.getInstance());
    }

    private static String a(Calendar calendar) {
        return a(calendar.getTime(), "yyyy-MM-dd");
    }

    private static String a(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static double a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return (simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime()) / 86400000;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1.0d;
        }
    }
}
