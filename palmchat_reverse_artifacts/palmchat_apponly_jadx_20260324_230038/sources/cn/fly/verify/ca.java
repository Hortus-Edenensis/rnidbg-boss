package cn.fly.verify;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2138a = dx.a("005-dbbddf[b1df");

    private static HashMap<String, Object> a() {
        HashMap<String, Object> map;
        File file = new File(ax.g().getFilesDir().getAbsolutePath() + dx.a("005j;facbdc[j"), f2138a);
        if (file.exists()) {
            map = (HashMap) fz.a(file.getAbsolutePath());
            bv.a().b("all_ds", map);
            file.delete();
        } else {
            map = null;
        }
        return (map == null || map.isEmpty()) ? (HashMap) bv.a().c("all_ds", null) : map;
    }

    public static boolean b(Context context) {
        if (Cdo.a()) {
            return cb.b(context);
        }
        return false;
    }

    public static String c(Context context) {
        return cb.c(context);
    }

    public static synchronized HashMap<String, Object> a(Context context) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> mapA = a();
        boolean z = mapA != null && mapA.size() > 0;
        if (z) {
            HashMap map2 = new HashMap();
            if (mapA.containsKey(dx.a("004(bebabgba"))) {
                mapA.put(dx.a("005b(bebabgba"), mapA.remove(dx.a("004,bebabgba")));
            }
            if (mapA.containsKey(dx.a("009=dfbe4hhZcbbhZgd1ba"))) {
                mapA.put(dx.a("011 bgbachbe<hh,cbbhQgd=ba"), mapA.remove(dx.a("009'dfbeFhhEcbbh5gd4ba")));
            }
            map2.putAll(mapA);
            map.put(dx.a("009Dcdbgbadfei%bafd"), map2);
        }
        String strAh = er.a(context).d().ah();
        if (!z && TextUtils.isEmpty(strAh)) {
            return null;
        }
        boolean zB = b(context);
        map.put(dx.a("004FcbUbMbgba"), strAh);
        map.put(dx.a("011RbgbachbeBhhUcbbhMgdKba"), Boolean.valueOf(zB));
        a(strAh, zB);
        return map;
    }

    private static void a(String str, boolean z) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put(dx.a("004$cb4bLbgba"), str);
        }
        map.put(dx.a("009NdfbeHhh cbbh,gdXba"), Boolean.valueOf(z));
        bv.a().b("all_ds", map);
    }
}
