package com.bytedance.sdk.component.a.b;

import android.content.Context;
import com.bytedance.sdk.component.a.fx.x;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static void u(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(u(i2), str);
            }
            fx.nr("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (x.u().u(i2).b() != null) {
                x.u().u(i2).b().u(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String u(Context context, int i, int i2) {
        String strU;
        if (i != 1) {
            strU = "";
        } else {
            try {
                if (x.u().u(i2).b() != null) {
                    strU = x.u().u(i2).b().u(context, u(i2), "");
                }
            } catch (Exception unused) {
            }
        }
        return strU instanceof String ? String.valueOf(strU) : "";
    }

    private static String u(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
