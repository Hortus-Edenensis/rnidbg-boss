package com.zm.fissionsdk;

import android.content.Context;
import android.util.Base64;
import com.zm.adxsdk.protocol.api.WfConfig;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zzWWV {
    public static final String d = "WfUnityController";
    public static final String e = "Y29tLnptLmFkeHNkay51bml0eS5XZlVuaXR5U2Rr";
    public static zzWWV f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f16763a;
    public Method b;
    public Method c;

    public zzWWV() {
        try {
            Class<?> cls = Class.forName(a(e));
            this.f16763a = cls.getDeclaredMethod(a("aW5pdA=="), Context.class, WfConfig.class);
            this.b = cls.getDeclaredMethod(a("aXNHYW1lUHJvY2Vzcw=="), Context.class);
            this.c = cls.getDeclaredMethod(a("c3RhcnRHYW1lQ2VudGVy"), Context.class, Map.class);
        } catch (Throwable th) {
            th.printStackTrace();
            WVVzW.a(d, "mInitMethod mStartGameCenterMethod error msg", th.getMessage());
        }
    }

    public void a(Context context, WfConfig wfConfig) {
        WVVzW.a(d, "init");
        try {
            Method method = this.f16763a;
            if (method != null) {
                method.invoke(null, context, wfConfig);
                WVVzW.a(d, "init invoke");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            WVVzW.a(d, "init error msg", th.getMessage());
        }
    }

    public boolean a(Context context) {
        WVVzW.a(d, "isGameProcess");
        try {
            Method method = this.b;
            if (method != null) {
                Object objInvoke = method.invoke(null, context);
                WVVzW.a(d, "isGameProcess invoke");
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            WVVzW.a(d, "isGameProcess error msg", th.getMessage());
        }
        return false;
    }

    public void a(Context context, Map<String, Object> map) {
        WVVzW.a(d, "startGameCenter");
        try {
            Method method = this.c;
            if (method != null) {
                method.invoke(null, context, map);
                WVVzW.a(d, "startGameCenter invoke");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            WVVzW.a(d, "startGameCenter error msg", th.getMessage());
        }
    }

    public static zzWWV a() {
        if (f == null) {
            synchronized (zzWWV.class) {
                if (f == null) {
                    f = new zzWWV();
                }
            }
        }
        return f;
    }

    public final String a(String str) {
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
