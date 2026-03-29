package com.bytedance.pangle.iz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.a;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    public static int nr = 2;
    public static int u = 1;

    public static String nr(String str) {
        String strSubstring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(strSubstring)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring) || com.huawei.hms.ads.dynamicloader.b.b.equals(strSubstring)) {
            return str2;
        }
        return str + str2;
    }

    public static SharedPreferences u(Context context) {
        return com.bytedance.sdk.openadsdk.ats.b.u(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    public static String[] u(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add(ContainerUtils.FIELD_DELIMITER);
        }
        arrayList.add("--instruction-set=" + u());
        if (i == u) {
            if (a.s()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == nr) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String u() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.iz.u(e);
            return null;
        }
    }

    public static String u(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(strSubstring2)) {
            return strSubstring;
        }
        if (!".zip".equals(strSubstring2) && !com.huawei.hms.ads.dynamicloader.b.b.equals(strSubstring2)) {
            return strSubstring + str2;
        }
        return strSubstring.replace(strSubstring2, str2);
    }

    public static boolean u(String str, String str2) {
        return u.u(u(str, str2, u));
    }

    public static boolean u(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !n.u(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean u(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + u(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
