package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.embedapplog.collector.Collector;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class u {
    public static nr b = null;
    public static ConcurrentHashMap<String, String> fx = new ConcurrentHashMap<>(4);
    private static boolean iz = true;
    private static volatile b n = null;
    public static boolean nr = true;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile mh pn = null;

    @SuppressLint({"StaticFieldLeak"})
    public static yd u = null;
    private static boolean x = false;

    public static String a() {
        yd ydVar = u;
        return ydVar != null ? ydVar.x() : "";
    }

    public static nr b() {
        return b;
    }

    public static b fx() {
        return n;
    }

    @Nullable
    public static JSONObject iz() {
        if (pn != null) {
            return pn.dw();
        }
        return null;
    }

    public static String jk() {
        yd ydVar = u;
        return ydVar != null ? ydVar.jk() : "";
    }

    @NonNull
    public static fx l() {
        return qe.u();
    }

    public static n mv() {
        if (pn != null) {
            return pn.tk();
        }
        return null;
    }

    public static boolean n() {
        return true;
    }

    public static void nr() {
        xg.u();
    }

    public static String pn() {
        yd ydVar = u;
        if (ydVar != null) {
            return ydVar.s();
        }
        return null;
    }

    public static String t() {
        yd ydVar = u;
        return ydVar != null ? ydVar.t() : "";
    }

    public static void u(@NonNull Context context, @NonNull n nVar) {
        if (pn != null) {
            ti.nr(new RuntimeException("Init Twice!"));
            return;
        }
        if (nVar.bf() == null) {
            ti.nr(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        xg xgVarIz = xg.iz();
        mh mhVar = new mh(application, nVar);
        pn = mhVar;
        yd ydVar = new yd(application, mhVar);
        xgVarIz.u(application, mhVar, ydVar, new sx(nVar.jk()));
        u = ydVar;
        if (pn.sx()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        ti.b("Inited", null);
    }

    public static String x() {
        yd ydVar = u;
        return ydVar != null ? ydVar.n() : "";
    }

    public static void nr(@NonNull String str, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            ti.nr("call onEventData with invalid params, return", null);
            return;
        }
        try {
            xg.u(new uq(str, jSONObject));
        } catch (Exception e) {
            ti.fx("call onEventData get exception: ", e);
        }
    }

    public static void u(boolean z) {
        nr = z;
    }

    public static void u() {
        yd ydVar;
        if (!nr || (ydVar = u) == null) {
            return;
        }
        ydVar.b();
    }

    public static void u(HashMap<String, Object> map) {
        yd ydVar = u;
        if (ydVar != null) {
            ydVar.u(map);
        }
    }

    public static <T> T u(String str, T t) {
        yd ydVar = u;
        if (ydVar != null) {
            return (T) ydVar.u(str, t);
        }
        return null;
    }

    public static void u(@NonNull String str, @Nullable JSONObject jSONObject) {
        xg.u(new rg(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void u(@NonNull String str, @Nullable JSONObject jSONObject, int i) {
        xg.u(new rg(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void u(@NonNull String str, @Nullable Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        ti.nr(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        u(str, jSONObject);
    }

    public static void u(@NonNull String str, @Nullable Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        ti.nr(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        u(str, jSONObject, i);
    }

    @AnyThread
    public static void u(@Nullable pn pnVar) {
        ec.u(pnVar);
    }
}
