package cn.fly.verify;

import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static SparseArray<l> a() {
        if (!new File(ax.g().getFilesDir(), ".preverfy_xhs").exists()) {
            return null;
        }
        long jH = aq.h();
        if (System.currentTimeMillis() > jH) {
            aq.a((HashMap) null);
            if (jH > 0) {
                f.a().b("[FlyVerify] ==>%s", "file config expire");
            }
            return null;
        }
        SparseArray<l> sparseArray = new SparseArray<>();
        l lVarA = a(1);
        if (lVarA != null) {
            sparseArray.append(1, lVarA);
        }
        l lVarA2 = a(2);
        if (lVarA2 != null) {
            sparseArray.append(2, lVarA2);
        }
        l lVarA3 = a(3);
        if (lVarA3 != null) {
            sparseArray.append(3, lVarA3);
        }
        l lVarA4 = a(4);
        if (lVarA4 != null) {
            sparseArray.append(4, lVarA4);
        }
        return sparseArray;
    }

    public static boolean b() {
        long jH = aq.h();
        boolean zJ = aq.j();
        if (!zJ || System.currentTimeMillis() <= jH) {
            return zJ;
        }
        aq.b(false);
        return false;
    }

    private static l a(int i) {
        int i2;
        Integer numValueOf;
        String str;
        HashMap mapB = aq.b();
        if (mapB == null) {
            return null;
        }
        String str2 = (String) mapB.get("appId_" + i);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = (String) mapB.get("secret_" + i);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        if (mapB.containsKey("multiFlag_" + i)) {
            try {
                i2 = Integer.parseInt(String.valueOf(mapB.get("multiFlag_" + i)));
            } catch (Throwable unused) {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (mapB.containsKey("channel_" + i)) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt(String.valueOf(mapB.get("channel_" + i))));
            } catch (Throwable unused2) {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        if (mapB.containsKey("channelAccount_" + i)) {
            try {
                str = (String) mapB.get("channelAccount_" + i);
            } catch (Throwable unused3) {
                str = null;
            }
        } else {
            str = null;
        }
        return new l(i, str2, str3, false, i2, numValueOf, str);
    }

    public static void a(SparseArray<l> sparseArray) {
        HashMap map = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            l lVarValueAt = sparseArray.valueAt(i);
            map.put("appId_" + lVarValueAt.f2403a, lVarValueAt.b);
            map.put("secret_" + lVarValueAt.f2403a, lVarValueAt.c);
            map.put("multiFlag_" + lVarValueAt.f2403a, String.valueOf(lVarValueAt.d()));
            if (lVarValueAt.e() != null) {
                map.put("channel_" + lVarValueAt.f2403a, String.valueOf(lVarValueAt.e()));
            }
            if (!TextUtils.isEmpty(lVarValueAt.f())) {
                map.put("channelAccount_" + lVarValueAt.f2403a, String.valueOf(lVarValueAt.f()));
            }
        }
        aq.a(map);
        aq.a(System.currentTimeMillis() + 600000);
    }
}
