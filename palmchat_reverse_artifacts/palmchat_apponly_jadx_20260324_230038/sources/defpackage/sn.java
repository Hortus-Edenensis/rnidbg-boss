package defpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class sn {
    public static long a() {
        return System.currentTimeMillis() / 1000;
    }

    public static String b(String str) {
        return c(a(), str);
    }

    public static String c(long j, String str) {
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j * 1000);
        return new SimpleDateFormat(str, new Locale("en")).format(calendar.getTime());
    }
}
