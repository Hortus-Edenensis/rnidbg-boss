package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class tw2 implements Thread.UncaughtExceptionHandler {
    public static tw2 d = new tw2();
    public static int e = 1048576;
    public boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f21083a = null;
    public final Object c = new Object();

    public tw2() {
        this.b = true;
        this.b = ((Boolean) lg5.c(tv2.a(null), zz2.m())).booleanValue();
    }

    public static void b(Context context) {
        if (context == null) {
            k63.l("JPushCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            hv1.c(hv1.e(context, "jpush_uncaughtexception_file"));
        }
    }

    public static tw2 e() {
        return d;
    }

    public static JSONArray f(Context context) {
        String strI = hv1.i(hv1.e(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        try {
            return new JSONArray(strI);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final JSONArray a(Context context, Throwable th) {
        String strI = hv1.i(hv1.e(context, "jpush_uncaughtexception_file"));
        JSONArray jSONArray = null;
        int length = 0;
        if (!TextUtils.isEmpty(strI)) {
            try {
                JSONArray jSONArray2 = new JSONArray(strI);
                try {
                    length = strI.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return c(context, jSONArray, length, th);
    }

    public final JSONArray c(Context context, JSONArray jSONArray, int i, Throwable th) {
        JSONObject jSONObjectOptJSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis() + mg5.a(context);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= jSONArray.length()) {
                    jSONObjectOptJSONObject = null;
                    break;
                }
                jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && string.equals(jSONObjectOptJSONObject.getString("stacktrace"))) {
                    jSONObjectOptJSONObject.put("count", jSONObjectOptJSONObject.getInt("count") + 1);
                    jSONObjectOptJSONObject.put("crashtime", jCurrentTimeMillis);
                    break;
                }
                i2++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObjectOptJSONObject == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("crashtime", jCurrentTimeMillis);
            jSONObject.put("stacktrace", string);
            jSONObject.put("message", d(th));
            jSONObject.put("count", 1);
            jSONObject.put("networktype", ad.k(context));
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = b.m;
                }
                String str2 = packageInfo.versionCode + "";
                jSONObject.put(f.aF, str);
                jSONObject.put("versioncode", str2);
            }
            if (i + jSONObject.toString().length() < e) {
                jSONArray.put(jSONObject);
            } else {
                long j = -1;
                int i3 = 0;
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i4);
                    if (jSONObjectOptJSONObject2 != null) {
                        long jOptLong = jSONObjectOptJSONObject2.optLong("crashtime");
                        if (j == -1 || jOptLong < j) {
                            i3 = i4;
                            j = jOptLong;
                        }
                    }
                }
                jSONArray.put(i3, jSONObject);
            }
        }
        return jSONArray;
    }

    public final String d(Throwable th) {
        String string = th.toString();
        try {
            String[] strArrSplit = string.split(":");
            if (strArrSplit.length <= 1) {
                return string;
            }
            for (int length = strArrSplit.length - 1; length >= 0; length--) {
                if (!strArrSplit[length].endsWith("Exception") && !strArrSplit[length].endsWith("Error")) {
                }
                return strArrSplit[length];
            }
            return string;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return string;
        }
    }

    public final void g(Throwable th) {
        if (this.b) {
            Context contextA = tv2.a(null);
            if (contextA == null) {
                k63.c("JPushCrashHandler", "handleException failed: context is null");
                return;
            }
            JSONArray jSONArrayA = a(contextA, th);
            b(contextA);
            k(contextA, jSONArrayA);
        }
    }

    public void h(Context context) {
        if (this.b) {
            return;
        }
        this.b = true;
        k63.a("JPushCrashHandler", "init caughtException");
        lg5.h(tv2.a(context), zz2.m().a0(Boolean.TRUE));
    }

    public final void i(long j) throws InterruptedException {
        synchronized (this.c) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (j < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            if (j == 0) {
                while (wz4.c("FUTURE_TASK")) {
                    this.c.wait(0L);
                }
            } else {
                long jCurrentTimeMillis2 = 0;
                while (wz4.c("FUTURE_TASK")) {
                    long j2 = j - jCurrentTimeMillis2;
                    if (j2 <= 0) {
                        break;
                    }
                    this.c.wait(j2);
                    jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                }
            }
        }
    }

    public void j(Context context) {
        if (context == null) {
            k63.l("JPushCrashHandler", "Action - reportCrashLog context is null");
            return;
        }
        if (mg5.d(context)) {
            try {
                wz4.a("FUTURE_TASK", new ew4());
            } catch (Throwable th) {
                k63.c("JPushCrashHandler", "report crash e:" + th);
            }
        }
    }

    public final void k(Context context, JSONArray jSONArray) {
        File fileE;
        String string = jSONArray != null ? jSONArray.toString() : null;
        if (TextUtils.isEmpty(string) || (fileE = hv1.e(context, "jpush_uncaughtexception_file")) == null) {
            return;
        }
        hv1.j(fileE, string);
    }

    public void l() {
        if (this.f21083a == null) {
            this.f21083a = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void m(Context context) {
        if (this.b) {
            k63.a("JPushCrashHandler", "stop caughtException");
            this.b = false;
            lg5.h(tv2.a(context), zz2.m().a0(Boolean.FALSE));
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.b) {
            k63.j("JPushCrashHandler", "enable crash report");
            g(th);
            try {
                wz4.a("FUTURE_TASK", new ew4());
                i(2000L);
            } catch (Throwable th2) {
                k63.c("JPushCrashHandler", "report crash e:" + th2);
            }
        } else {
            k63.j("JPushCrashHandler", "disable crash report");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f21083a;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
