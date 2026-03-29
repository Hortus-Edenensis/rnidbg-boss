package com.zm.fda.utils;

import android.util.Log;
import com.zm.fda.O52OZ.Z0225;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EventLog {
    public static Boolean LOG_SWITCH = Boolean.FALSE;
    public static char LOG_TYPE = 'v';
    public static int SDCARD_LOG_FILE_SAVE_DAYS;

    public static void d(String str, Object obj) {
        log(str, obj.toString(), 'd');
    }

    public static void debug(boolean z) {
        LOG_SWITCH = Boolean.valueOf(z);
    }

    public static void e(String str, Object obj) {
        log(str, obj.toString(), 'e');
    }

    public static Date getDateBefore() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - SDCARD_LOG_FILE_SAVE_DAYS);
        return calendar.getTime();
    }

    public static void i(String str, Object obj) {
        log(str, obj.toString(), 'i');
    }

    public static boolean isDebugEnable() {
        return Z0225.a();
    }

    public static void log(String str, String str2, char c) {
        char c2;
        char c3;
        char c4;
        char c5;
        if (LOG_SWITCH.booleanValue() || isDebugEnable()) {
            if ('e' == c && ('e' == (c5 = LOG_TYPE) || 'v' == c5)) {
                Log.e(str, str2);
                return;
            }
            if ('w' == c && ('w' == (c4 = LOG_TYPE) || 'v' == c4)) {
                Log.w(str, str2);
                return;
            }
            if ('d' == c && ('d' == (c3 = LOG_TYPE) || 'v' == c3)) {
                Log.d(str, str2);
            } else if ('i' == c && ('d' == (c2 = LOG_TYPE) || 'v' == c2)) {
                Log.i(str, str2);
            } else {
                Log.v(str, str2);
            }
        }
    }

    public static void v(String str, Object obj) {
        log(str, obj.toString(), 'v');
    }

    public static void w(String str, Object obj) {
        log(str, obj.toString(), 'w');
    }

    public static void d(String str, String str2) {
        log(str, str2, 'd');
    }

    public static void e(String str, String str2) {
        log(str, str2, 'e');
    }

    public static void i(String str, String str2) {
        log(str, str2, 'i');
    }

    public static void v(String str, String str2) {
        log(str, str2, 'v');
    }

    public static void w(String str, String str2) {
        log(str, str2, 'w');
    }

    public static void d(String str, Object... objArr) {
        if (LOG_SWITCH.booleanValue() || isDebugEnable()) {
            StringBuilder sb = new StringBuilder();
            if (objArr != null && objArr.length > 0) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        sb.append(obj.toString());
                    }
                }
            }
            Log.d(str, sb.toString());
        }
    }
}
