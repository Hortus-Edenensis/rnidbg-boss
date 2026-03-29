package com.huawei.hms.ads;

import android.app.Activity;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class lf {
    private static final String Code = "ShareManager";
    private static final Map<String, la> I = new HashMap(5);
    private static final int V = 5;
    private static final Map<String, Class<? extends la>> Z;

    static {
        HashMap map = new HashMap();
        Z = map;
        map.put(ld.B, lb.class);
        map.put(ld.V, lk.class);
        map.put(ld.Code, lc.class);
        map.put(ld.I, lj.class);
        map.put(ld.Z, li.class);
    }

    public static void Code(String str, Activity activity, le leVar, lg lgVar) {
        fh.Code(Code, "shareAd : %s", str);
        try {
            Map<String, la> map = I;
            la laVarV = !map.containsKey(str) ? V(str) : map.get(str);
            if (laVarV != null) {
                laVarV.Code(activity, leVar, lgVar);
            }
        } catch (Throwable unused) {
            fh.I(Code, "Share throws exception");
        }
    }

    @Nullable
    private static la V(String str) throws IllegalAccessException, InstantiationException {
        Class<? extends la> cls = Z.get(str);
        if (cls == null) {
            fh.Code(Code, "There is no matching type for %s", str);
            return null;
        }
        la laVarNewInstance = cls.newInstance();
        I.put(str, laVarNewInstance);
        return laVarNewInstance;
    }

    public static boolean Code(String str) {
        try {
            Class<? extends la> cls = Z.get(str);
            if (cls != null) {
                return cls.newInstance().Code();
            }
            fh.Code(Code, "There is no matching type for %s", str);
            return false;
        } catch (Throwable unused) {
            fh.I(Code, "Share throws exception");
            return false;
        }
    }
}
