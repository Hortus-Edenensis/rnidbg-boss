package com.lantern.core.database;

import android.content.Context;
import defpackage.cn1;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class EventLimitSp extends PubSharedPref {
    public static final String SP_TIME_NUMBER_FILENAME = "event_time_num_sp";
    private static final String SP_TODAY_KEY = "event_today_key";

    public EventLimitSp(Context context, String str, int i) {
        super(context, str, i);
    }

    public static String getCurSpName(Context context) {
        String strA = cn1.a(context);
        if (strA == null) {
            return "event_time_num_sp";
        }
        return strA + "event_time_num_sp";
    }

    public static String getToday() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }

    public int getTodayTimes(String str, String str2) {
        if (str2 != null && str2.equals(readString("event_today_key"))) {
            return readInt(str);
        }
        clear();
        write("event_today_key", str2);
        return 0;
    }

    public void plusOneTimes(String str, String str2) {
        write(str, getTodayTimes(str, str2) + 1);
    }
}
