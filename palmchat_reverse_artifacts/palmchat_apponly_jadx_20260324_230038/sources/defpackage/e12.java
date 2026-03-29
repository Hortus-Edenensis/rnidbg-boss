package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e12<F extends Format> {
    public static final ConcurrentMap<a, String> b = new ConcurrentHashMap(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<a, F> f17200a = new ConcurrentHashMap(7);

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f17201a;
        public int b;

        public a(Object... objArr) {
            this.f17201a = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.f17201a, ((a) obj).f17201a);
        }

        public int hashCode() {
            if (this.b == 0) {
                int iHashCode = 0;
                for (Object obj : this.f17201a) {
                    if (obj != null) {
                        iHashCode = (iHashCode * 7) + obj.hashCode();
                    }
                }
                this.b = iHashCode;
            }
            return this.b;
        }
    }

    public static String g(Integer num, Integer num2, Locale locale) {
        a aVar = new a(num, num2, locale);
        ConcurrentMap<a, String> concurrentMap = b;
        String str = concurrentMap.get(aVar);
        if (str != null) {
            return str;
        }
        try {
            String pattern = ((SimpleDateFormat) (num == null ? DateFormat.getTimeInstance(num2.intValue(), locale) : num2 == null ? DateFormat.getDateInstance(num.intValue(), locale) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale))).toPattern();
            String strPutIfAbsent = concurrentMap.putIfAbsent(aVar, pattern);
            return strPutIfAbsent != null ? strPutIfAbsent : pattern;
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("No date time pattern for locale: " + locale);
        }
    }

    public abstract F a(String str, TimeZone timeZone, Locale locale);

    public F b(int i, TimeZone timeZone, Locale locale) {
        return (F) d(Integer.valueOf(i), null, timeZone, locale);
    }

    public F c(int i, int i2, TimeZone timeZone, Locale locale) {
        return (F) d(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    public final F d(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return (F) f(g(num, num2, locale), timeZone, locale);
    }

    public F e() {
        return (F) c(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F f(String str, TimeZone timeZone, Locale locale) {
        if (str == null) {
            throw new NullPointerException("pattern must not be null");
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        a aVar = new a(str, timeZone, locale);
        F f = this.f17200a.get(aVar);
        if (f != null) {
            return f;
        }
        F f2 = (F) a(str, timeZone, locale);
        F f3 = (F) this.f17200a.putIfAbsent(aVar, f2);
        return f3 != null ? f3 : f2;
    }

    public F h(int i, TimeZone timeZone, Locale locale) {
        return (F) d(null, Integer.valueOf(i), timeZone, locale);
    }
}
