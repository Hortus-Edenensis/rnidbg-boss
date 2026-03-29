package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f19380a;
    public static volatile FutureTask<?> b;
    public static final Object c = new Object();
    public static final LinkedHashSet<String> d;
    public static final String e;
    public static final LinkedHashSet<String> f;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends xw2 {
        public final Context c;

        @Override // defpackage.xw2
        public void a() {
            try {
                String strF = mw4.f(this.c);
                LinkedHashSet<String> linkedHashSetG = mw4.g(this.c);
                linkedHashSetG.addAll(mw4.e());
                k63.a("ReportSis", "sis urls=" + linkedHashSetG.toString() + " post json=" + strF);
                if (!ad.w(this.c)) {
                    k63.l("ReportSis", "give up sis, because network is not connected");
                    return;
                }
                for (String str : linkedHashSetG) {
                    if (!TextUtils.isEmpty(str)) {
                        if (Build.VERSION.SDK_INT >= 28 && !str.startsWith(lv2.d)) {
                            k63.l("ReportSis", "won't use http at device since 28");
                        } else if (mw4.h(this.c, str, strF)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }

        public b(Context context) {
            this.c = context;
            this.f22065a = "SisTask";
        }
    }

    static {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        d = linkedHashSet;
        String strB = bf2.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 68, 83, 112, 123, 56, 123, 64, 85, 106, 96, 56, 114, 94});
        e = strB;
        linkedHashSet.add(strB);
        f = new LinkedHashSet<>();
    }

    public static void d(Context context, boolean z) {
        if (f19380a == null) {
            f19380a = new b(context);
        }
        if (b == null || b.isCancelled() || b.isDone()) {
            synchronized (c) {
                if (b == null || b.isCancelled() || b.isDone()) {
                    try {
                        b = new FutureTask<>(f19380a, null);
                        wz4.a("FUTURE_TASK", b);
                    } catch (Throwable th) {
                        k63.l("ReportSis", "new sis task e:" + th);
                    }
                }
            }
        }
        if (z) {
            try {
                b.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                k63.l("ReportSis", "sis task e:" + e2);
            } catch (ExecutionException e3) {
                k63.l("ReportSis", "sis task e:" + e3);
            } catch (TimeoutException e4) {
                k63.l("ReportSis", "sis task e:" + e4);
            } catch (Throwable th2) {
                k63.l("ReportSis", "sis task e:" + th2);
            }
        }
    }

    public static LinkedHashSet<String> e() {
        if (tv2.c()) {
            LinkedHashSet<String> linkedHashSet = f;
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
        }
        return d;
    }

    public static String f(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strE = fv2.e(context);
            long jLongValue = ((Long) lg5.c(context, zz2.K())).longValue();
            int iB = cu5.b(context);
            String strD = cu5.d(context);
            jSONObject.put("type", iB);
            jSONObject.put("appkey", strE);
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, wv2.b);
            jSONObject.put("platform", 0);
            if (jLongValue != 0) {
                jSONObject.put(DeviceInfoUtil.UID_TAG, jLongValue);
            }
            if (strD != null) {
                jSONObject.put("opera", strD);
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static LinkedHashSet<String> g(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String str = (String) lg5.c(context, zz2.u());
        if (TextUtils.isEmpty(str)) {
            return linkedHashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedHashSet.add(jSONArray.optString(i));
            }
        } catch (JSONException unused) {
        }
        return linkedHashSet;
    }

    public static boolean h(Context context, String str, String str2) {
        px4 px4VarD = qw2.d(str, str2, context, true, 3, 2);
        k63.a("ReportSis", "report sis code[" + px4VarD.b() + "] from url=" + str + "\n body=" + px4VarD.a());
        if (px4VarD.b() != 0) {
            return false;
        }
        String strA = px4VarD.a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        try {
            q7.c().h(context, new JSONObject(strA).getJSONObject("ret"));
            return true;
        } catch (Throwable th) {
            k63.l("ReportSis", "getUrls e:" + th);
            return false;
        }
    }
}
