package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18057a = new Object();
    public static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> b = new ConcurrentHashMap<>();
    public static String c = "yyyyMMdd_HHmm";

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18058a;

        public a(String str) {
            this.f18058a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f18058a, Locale.ENGLISH);
        }
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> aVar = b.get(str);
        if (aVar == null) {
            synchronized (f18057a) {
                aVar = b.get(str);
                if (aVar == null) {
                    aVar = new a(str);
                    b.put(str, aVar);
                }
            }
        }
        return aVar.get();
    }

    public static String b() {
        return a(c).format(new Date());
    }

    public static String c() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static boolean d(Date date, int i) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date.getTime());
        calendar.roll(6, -i);
        return calendar.after(calendar2);
    }

    public static Date e(String str) {
        try {
            return a(c).parse(str);
        } catch (ParseException e) {
            k63.d("DateUtil", "parse filename datetime error - " + str, e);
            return null;
        }
    }
}
