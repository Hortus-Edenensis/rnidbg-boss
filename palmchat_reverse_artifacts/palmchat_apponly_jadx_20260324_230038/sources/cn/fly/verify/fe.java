package cn.fly.verify;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, fe> f2348a = new HashMap<>();
    private static final HashMap<String, String> b = new HashMap<>();
    private String c;
    private int d;
    private boolean e;

    public fe() {
        this.e = false;
        this.c = null;
        this.d = -1;
    }

    private int a(int i, int i2, String str) {
        fe feVar;
        try {
            String str2 = Process.myPid() + "-" + Process.myTid() + "(" + Thread.currentThread().getName() + ") " + str;
            if (i2 == 1) {
                String str3 = this.c;
                int i3 = this.d;
                HashMap<String, String> map = b;
                if (!map.isEmpty()) {
                    Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            feVar = null;
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        if (next.getValue() != null && str.contains(next.getValue())) {
                            feVar = f2348a.get(next.getKey());
                            break;
                        }
                    }
                    if (feVar != null) {
                        str3 = feVar.c;
                        i3 = feVar.d;
                    }
                }
                eb.a().a(1, str3, i3, str2);
            }
            eb.a().a(i, str2);
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private String e(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Throwable th2) {
            return th2 instanceof OutOfMemoryError ? bq.a("023IffOgj,fkOjed]emflekYedg-fkRjPekej$f'ffjgfefeeg") : th2.getMessage();
        }
    }

    private String f(Throwable th) {
        try {
            String name = th.getClass().getName();
            String strG = g(th);
            String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
            Throwable cause = th;
            while (cause != null && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause == null || cause == th) {
                return e(th);
            }
            return name + ":" + strG + "\n" + string + "\n......\nCaused by:\n" + e(cause);
        } catch (Throwable unused) {
            return e(th);
        }
    }

    private static String g(Throwable th) {
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, cut!]";
    }

    public final int b(Object obj, Object... objArr) {
        return a(5, obj, objArr);
    }

    public final int c(Object obj, Object... objArr) {
        return a(4, obj, objArr);
    }

    public final int d(Object obj, Object... objArr) {
        return a(6, obj, objArr);
    }

    private fe(String str, int i) {
        this.e = false;
        this.c = str;
        this.d = i;
    }

    public final int a(int i, Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return a(i, 0, string);
    }

    public final int b(String str) {
        return a(5, str, new Object[0]);
    }

    public final int c(Throwable th) {
        return a(6, th);
    }

    public final void d(Throwable th) {
        a(6, 1, f(th));
    }

    public final int a(int i, Throwable th) {
        return a(i, 0, e(th));
    }

    public final int b(Throwable th) {
        return a(5, th);
    }

    public final int a(int i, Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(e(th));
        return a(i, 0, sb.toString());
    }

    public final int a(Object obj, Object... objArr) {
        return a(3, obj, objArr);
    }

    public final int a(Throwable th) {
        return a(3, th);
    }

    public final int a(Throwable th, Object obj, Object... objArr) {
        return a(3, th, obj, objArr);
    }

    @Deprecated
    public static fe a(String str) {
        fe feVar;
        HashMap<String, fe> map = f2348a;
        synchronized (map) {
            feVar = map.get(str);
            if (feVar == null) {
                feVar = new fe(str, -1);
                b.put(str, null);
                map.put(str, feVar);
            }
        }
        return feVar;
    }

    public static fe a(String str, int i, String str2) {
        fe feVar;
        HashMap<String, fe> map = f2348a;
        synchronized (map) {
            feVar = map.get(str);
            if (feVar == null) {
                feVar = new fe(str, i);
                b.put(str, str2);
                map.put(str, feVar);
            }
        }
        return feVar;
    }
}
