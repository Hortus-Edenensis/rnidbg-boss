package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11332a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Context f4a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f10a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f11b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f7a = "XMPush-" + Process.myPid();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static LoggerInterface f5a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f8a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Integer f6a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicInteger f9a = new AtomicInteger(1);

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements LoggerInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11333a = b.f7a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f11333a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f11333a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f11333a, str, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m77a() {
        return false;
    }

    public static void b(String str) {
        if (m78a(0)) {
            a(0, m73a(str));
        }
    }

    public static void c(String str) {
        if (m78a(0)) {
            a(1, m73a(str));
        }
    }

    public static void d(String str) {
        if (m78a(4)) {
            a(4, m73a(str));
        }
    }

    public static void e(String str) {
        if (f10a) {
            m74a(str);
            return;
        }
        Log.w(f7a, m73a(str));
        if (f11b) {
            return;
        }
        m74a(str);
    }

    public static void a(LoggerInterface loggerInterface) {
        f5a = loggerInterface;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m79b(String str, String str2) {
        if (m78a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (m78a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f10a) {
            m75a(str, str2);
            return;
        }
        Log.w(f7a, b(str, str2));
        if (f11b) {
            return;
        }
        m75a(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m78a(int i) {
        return i >= f11332a || m77a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m74a(String str) {
        if (m78a(2)) {
            a(2, m73a(str));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m78a(1)) {
            a(1, a(str, objArr));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m75a(String str, String str2) {
        if (m78a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m76a(String str, Object... objArr) {
        if (m78a(2)) {
            a(2, a(str, objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (m78a(4)) {
            a(4, m73a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m78a(4)) {
            a(4, th);
        }
    }

    public static Integer a(String str) {
        if (f11332a <= 1) {
            Integer numValueOf = Integer.valueOf(f9a.incrementAndGet());
            f8a.put(numValueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(numValueOf, str);
            f5a.log(str + " starts");
            return numValueOf;
        }
        return f6a;
    }

    public static void a(Integer num) {
        if (f11332a <= 1) {
            HashMap<Integer, Long> map = f8a;
            if (map.containsKey(num)) {
                long jLongValue = map.remove(num).longValue();
                String strRemove = b.remove(num);
                long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                f5a.log(strRemove + " ends in " + jCurrentTimeMillis + " ms");
            }
        }
    }

    public static void a(int i, String str) {
        if (i >= f11332a) {
            f5a.log(str);
            return;
        }
        if (m77a()) {
            Log.d("MyLog", "-->log(" + i + "): " + str);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f11332a) {
            f5a.log("", th);
            return;
        }
        if (m77a()) {
            Log.w("MyLog", "-->log(" + i + "): ", th);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f11332a) {
            f5a.log(str, th);
            return;
        }
        if (m77a()) {
            Log.w("MyLog", "-->log(" + i + "): " + str, th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m73a(String str) {
        return b() + str;
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f11332a = i;
    }

    public static int a() {
        return f11332a;
    }

    public static void a(Context context) {
        f4a = context;
        if (j.m651a(context)) {
            f10a = true;
        }
        if (j.m650a()) {
            f11b = true;
        }
    }
}
