package com.zm.fda.Z0O00;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z extends Z25O0 {
    public static final String b = "event_time_num_sp";
    public static final String c = "event_today_key";

    public ZZ00Z(Context context, String str, int i) {
        super(context, str, i);
    }

    public static String a(Context context) {
        String strB = com.zm.fda.O52OZ.ZZ00Z.b(context);
        if (strB == null) {
            return "event_time_num_sp";
        }
        return strB + "event_time_num_sp";
    }

    public static String b() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }

    public int c(String str, String str2) {
        if (str2 != null && str2.equals(e(c))) {
            return c(str);
        }
        a();
        b(c, str2);
        return 0;
    }

    public void d(String str, String str2) {
        b(str, c(str, str2) + 1);
    }
}
